import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public abstract class HashTable {
	
	protected static int capacity;
	protected int size;
	protected int collision;
	protected static double start;
	protected static double end;

	public HashTable(int capacity) {
		this.capacity=capacity;
		collision=0;
	}


	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public static int index(MapElement m) {
		return (m.hashCode()%capacity);
	}

	public static int index(int key) {
		return (key%capacity);
	}

	public static void timer(String method) {
	System.out.println(method+" runtime: "+(end-start)+" ns");
	}

	public void printInfo() {
		System.out.println("Size of the table: "+capacity);
		System.out.println("Number of elements: "+size);
		System.out.println("number of collisions: "+collision);
	}
	
	public void timeToPut(MapElement array[], int nbOfValues, String title, String method) {
		Random randomValue = new Random();
		long start = System.nanoTime();
		for(int i = 0; i < nbOfValues; i++) {
			array[i] = new MapElement(randomValue.nextInt(100));
		}
		long end = System.nanoTime();
		long time = end-start;
		
		try {
			FileWriter writer = new FileWriter(title+".txt",true);
			writer.write(method + " at " + nbOfValues + ": " + time + " ns");
			writer.write("\n");
			writer.close();
		}
		catch (UnsupportedEncodingException e) {
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
	
	public abstract int put(int key,int value);
	public abstract int get(int key);
	public abstract int remove(int key);
	
}
