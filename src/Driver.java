import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Driver {
	
	public static void timeToPutSC(MapElement array[], int nbOfValues, String title) {
		SeparateChaining HSChaining = new SeparateChaining(100);
		Random randomValue = new Random();
		long start = System.nanoTime();
		for(int i = 0; i < nbOfValues; i++) {
			array[i] = new MapElement(randomValue.nextInt(100));
			HSChaining.put(array[i]);
		}
		long end = System.nanoTime();
		long time = end-start;
		
		try {
			FileWriter writer = new FileWriter(title+".txt",true);
			writer.write("SeparateChaining" + " at " + nbOfValues + ": " + time + " ns");
			writer.write("\n\n");
			writer.close();
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void timeToPutLP(MapElement array[], int nbOfValues, String title) {
		LinearProbing HSLinear = new LinearProbing(100);
		Random randomValue = new Random();
		long start = System.nanoTime();
		for(int i = 0; i < nbOfValues; i++) {
			array[i] = new MapElement(randomValue.nextInt(100));
			HSLinear.put(array[i]);
		}
		long end = System.nanoTime();
		long time = end-start;
		
		try {
			FileWriter writer = new FileWriter(title+".txt",true);
			writer.write("LinearProbing" + " at " + nbOfValues + ": " + time + " ns");
			writer.write("\n\n");
			writer.close();
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void timeToPutQP(MapElement array[], int nbOfValues, String title) {
		QuadraticProbing HSQuadratic = new QuadraticProbing(100);
		Random randomValue = new Random();
		long start = System.nanoTime();
		for(int i = 0; i < nbOfValues; i++) {
			array[i] = new MapElement(randomValue.nextInt(100));
			HSQuadratic.put(array[i]);
		}
		long end = System.nanoTime();
		long time = end-start;
		
		try {
			FileWriter writer = new FileWriter(title+".txt",true);
			writer.write("QuadraticProbing" + " at " + nbOfValues + ": " + time + " ns");
			writer.write("\n\n");
			writer.close();
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void timeToPutQP101(MapElement array[], int nbOfValues, String title) {
		QuadraticProbing HSQuadratic101 = new QuadraticProbing(101);
		Random randomValue = new Random();
		long start = System.nanoTime();
		for(int i = 0; i < nbOfValues; i++) {
			array[i] = new MapElement(randomValue.nextInt(100));
			HSQuadratic101.put(array[i]);
		}
		long end = System.nanoTime();
		long time = end-start;
		
		try {
			FileWriter writer = new FileWriter(title+".txt",true);
			writer.write("QuadraticProbing101" + " at " + nbOfValues + ": " + time + " ns");
			writer.write("\n\n");
			writer.close();
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	LinearProbing LP = new LinearProbing(128);
	
	public void DynamicResizing() {
		LinearProbing newLP = new LinearProbing(2*LP.size);
		LP = newLP;	
	}
	
	public static void main(String[] args) {
		
		// Create 150 pairs
		MapElement Pairs[] = new MapElement[150];
		
		// For SeparateChaining
		timeToPutSC(Pairs, 50, "Report");
		timeToPutSC(Pairs, 75, "Report");
		timeToPutSC(Pairs, 95, "Report");
		timeToPutSC(Pairs, 100, "Report");
		timeToPutSC(Pairs, 150, "Report");
		
		
		// For LinearProbing
		timeToPutLP(Pairs, 50, "Report");
		timeToPutLP(Pairs, 75, "Report");
		timeToPutLP(Pairs, 95, "Report");
		timeToPutLP(Pairs, 100, "Report");
		timeToPutLP(Pairs, 150, "Report");
		
		// For QuadraticProbing
		timeToPutQP(Pairs, 50, "Report");
		timeToPutQP(Pairs, 75, "Report");
		timeToPutQP(Pairs, 95, "Report");
		timeToPutQP(Pairs, 100, "Report");
		timeToPutQP(Pairs, 150, "Report");
		
		// For QuadraticProbing at capacity 101
		timeToPutQP101(Pairs, 50, "Report");
		timeToPutQP101(Pairs, 75, "Report");
		timeToPutQP101(Pairs, 95, "Report");
		timeToPutQP101(Pairs, 100, "Report");
		timeToPutQP101(Pairs, 150, "Report");
		
	}
}
