import java.util.Random;
public class MapElement {
private int key;
private int value;
private Random rand = new Random();

public MapElement(int value) {
	key=rand.nextInt(65535);
	this.value=value;
}

public MapElement(int key, int value) {
	this.key=key;
	this.value=value;
}
//Casting to an Integer
public int hashCode() {
	return key;
}

public int getKey() {
	return key;
}

public int value() {
	return value;
}

public void setVal(int val) {
	value=val;
}

public String toString() {
	return "<"+key+","+value+">";
}
}
