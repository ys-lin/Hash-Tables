import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class SeparateChaining extends HashTable{
private static Bucket[] list;

	public SeparateChaining(int capacity) {
		super(capacity);
		//create a list of buckets (list of pointers to nodes only)
		list =new Bucket[capacity];
			
	}

	public void insert(MapElement e) {
		
		//find index of e using the hash function
		int i=index(e);
		//create a new node with value e and next point to null
		Node n=new Node(e,null);
		//increment number of elements in the hash table
		size++;
		if(list[i]==null) {
			list[i]=new Bucket(null);
		}else if(list[i].hasNext()) //if collision occurs
			collision++;	
		//traverse the linked list of a specific bucket and add the node
		traverse(list[i]).next=n;
		printInfo();
		//increment the number of items in the bucket list
		++list[i].numItem;
		
		System.out.println("Number of items in bucket "+i+": "+list[i].numItem);
	}
	
	@Override
	public int put(int key, int value) {
		start=System.nanoTime();
		if(find(key)!=null) {
			//change the value of the k,v set
			int v=find(key).v.value();
			find(key).v.setVal(value);
			printInfo();
			System.out.println("Number of items in bucket "+key+": "+list[index(key)].numItem);
			end=System.nanoTime();
			timer("put(k,v");
			return v;
		}else {
			//create a new k,v set
			MapElement e=new MapElement(key,value);
			insert(e);
			end=System.nanoTime();
			timer("put(k,v)");
			return -1;
		}
		
	}

	public int put(MapElement e) {
		start=System.nanoTime();
		int key=e.getKey();
		if(find(key)!=null) {
			//change the value of the k,v set
			int v=find(key).v.value();
			find(key).v=e;
			printInfo();
			System.out.println("Number of items in bucket "+key+": "+list[index(key)].numItem);
			end=System.nanoTime();
			timer("put(k,v");
			return v;
		}else {
			//create a new k,v set
			insert(e);
			end=System.nanoTime();
			timer("put(k,v)");
			return -1;
		}
		
	}
	
	@Override
	public int get(int key) {
		start=System.nanoTime();
	//if key is found
	if(find(key)!=null) {
		end=System.nanoTime();
		timer("get(key)");
		return find(key).v.value();
		}
	//else return -1
	end=System.nanoTime();
	timer("get(k)");
		return -1;
	}

	@Override
	public int remove(int key) {
		if(find(key)!=null) {
		Node t=find(key);
		int val=t.v.value();
		t=null;
		size--;
		list[index(key)].numItem--;
		end=System.nanoTime();
		timer("remove(key)");
		return val;
		}
		end=System.nanoTime();
		timer("remove(k)");
		return -1;
	}

	
	
	private static Node traverse(Node n) {
		Node t=n;
		while(t!=null && t.hasNext()) {
			t=t.next;
		}
		return t;
	}
	
	private static Node find(int key) {
		Node t=list[index(key)];
		while (t!=null && t.hasNext()) {
			t=t.next;
			//if key of the map element== key
			if (t.v.getKey()==key)
				//return the value of the map element
				return t;
				}
		return null;
	}
	
	public void printTable(String title, String method) {
		try (FileWriter writer = new FileWriter(title+".txt",true)) {
			writer.write(method+"\n");
			writer.write("\ncapacity: "+capacity+"\n");
			int counter=0;
			for (Bucket b : list) {
				 writer.write("index "+counter+": ");
				Node t=b;
				while(t!=null&&t.hasNext()) {
					t=t.next;
					 writer.write(t.v+"  ");
				}
				counter++;
				 writer.write("\n");
				
			}
			writer.write("-----------------------------------------------------------------------------------\n");
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	private class Node{
		MapElement v;
		Node next;
	
		Node(Node next){
			this.next=next;
		}
		
		Node(MapElement e, Node next){
			v=e;
			this.next=next;
		}
		
		boolean hasNext() {
			return this.next!=null;
		}
		
		
	}
	
	private class Bucket extends Node{
		int numItem;
		
		Bucket(Node next) {
			super(next);
			numItem=0;
		}
		
	}

	
}
