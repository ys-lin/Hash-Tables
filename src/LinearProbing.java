import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class LinearProbing extends HashTable{
	private Bucket[] list;
	private int prob;
	public LinearProbing(int capacity) {
		super(capacity);
		list =new Bucket[capacity];
	}

	
	
	public void insert(MapElement e) {
		size++;
		int i=index(e);
		int prob=0;
		for(int a=i; a<capacity;a=(a+1)%capacity) {
			if(prob==capacity)
				break;
				if(list[a]==null) {
					list[a]=new Bucket(e);
					System.out.println("Number of Probing: "+prob);
					break;
				}
				if (list[a].available) {
					list[a].v=e;
					list[a].available=false;
					System.out.println("Number of Probing: "+prob);
					break;
				}
				prob++;
			}
		
	}

	@Override
	public int put(int key,int value) {
		start=System.nanoTime();
		int i=search(key);
		if(i !=-1) {
			int val=list[i].v.value();
			list[i].v.setVal(value);
			printInfo();
			System.out.println("Number of Probing: "+prob);
			end=System.nanoTime();
			timer("put(k.v)");
			return val;
		}else {
			MapElement e=new MapElement(key,value);
			insert(e);
			printInfo();
			end=System.nanoTime();
			timer("put(k.v)");
			return -1;
		}
	}
	
	public int put(MapElement e) {
		start=System.nanoTime();
		int key =e.getKey();
		int i=search(key);
		if(i !=-1) {
			int val=list[i].v.value();
			list[i].v=e;
			printInfo();
			System.out.println("Number of Probing: "+prob);
			end=System.nanoTime();
			timer("put(k.v)");
			return val;
		}else {
			insert(e);
			printInfo();
			end=System.nanoTime();
			timer("put(k.v)");
			return -1;
		}
	}
	@Override
	public int get(int key) {
		start=System.nanoTime();
		int i = search (key);
		if(i==-1) {
		end=System.nanoTime();
		timer("get(k)");
		return -1;
		}
		else {
			end=System.nanoTime();
			timer("get(k)");
			return list[i].v.value();}
	}

	@Override
	public int remove(int key) {
		start=System.nanoTime();
		int i = search (key);
		if(i!=-1) {
			size--;
			int val=list[i].v.value();
			list[i].v=null;
			list[i].available=true;
			end=System.nanoTime();
			timer("remove(k)");
			return val;
		}else {
			end=System.nanoTime();
			timer("remove(k)");
			return -1;
		}
	}

	public int search(int key) {
		int i= index(key);
		prob=0;
		for(int a=i;a<capacity;a=(a+1)%capacity) {
			if(prob==capacity || list[a]==null)
				return -1;
			if(list[a].available) {
				prob++;
				continue;
				}
			if(list[a].v.getKey()==key) {
				return a;
				}	
			prob++;
		}
		return -1;
	}
	
	public void printTable(String title, String method) {
		try (FileWriter writer = new FileWriter(title+".txt",true)) {
			writer.write(method+"\n");
			writer.write("\ncapacity: "+capacity+"\n");
			int counter=0;
			for (Bucket b : list) {
				 writer.write("index "+counter+": ");
				 if(b!=null)
					 	writer.write(b.v+" ");
				 writer.write("\n");
				counter++;
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
	private class Bucket{
		boolean available;
		MapElement v;
		
		Bucket(MapElement e){
			available=false;
			v=e;
		} 
	}
}
