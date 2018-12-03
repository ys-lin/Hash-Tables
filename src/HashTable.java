
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
	System.out.println("Size of the table: "+capacity+"\n");
	System.out.println("Number of elements: "+size);
	System.out.println("number of collisions: "+collision);
}

public abstract int put(int key,int value);
public abstract int get(int key);
public abstract int remove(int key);
}
