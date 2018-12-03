import java.util.Random;
public class Validate {
public static void main(String[] args) {
Random ran=new Random();
int[] capacity= {50};
QuadraticProbing quadra=new QuadraticProbing(100);
LinearProbing linear= new LinearProbing(100);
SeparateChaining sepa = new SeparateChaining(100);

for (int i : capacity) {
	
	MapElement e[]=new MapElement[i];
	
	for(int b=0;b<i;b++) {
		e[b]=new MapElement(ran.nextInt(100));
		System.out.println("\nQuadraric Probing");
		quadra.put(e[b]);
		System.out.println("\nLinear Probing");
		linear.put(e[b]);
		System.out.println("\nSeparate Chaining");
		sepa.put(e[b]);
	}
	System.out.println();
	sepa.printTable("sepa100","put(k,v)");
	linear.printTable("linear100","put(k,v)");
	quadra.printTable("quadra100","put(k,v)");
	for(MapElement m: e) {
		int key=m.getKey();
		System.out.println("\nQuadraric Probing" );
		quadra.get(key);
		System.out.println("\nLinear Probing");
		linear.get(key);
		System.out.println("\nSeparate Chaining");
		sepa.get(key);
	}
	sepa.printTable("sepa100","get(k)");
	linear.printTable("linear100","get(k)");
	quadra.printTable("quadra100","get(k)");
	
	System.out.println();
	for(int c=0;c<25;c++) {
		int key=e[c].getKey();
		System.out.println("\nQuadraric Probing");
		quadra.remove(key);
		System.out.println("\nLinear Probing");
		linear.remove(key);
		System.out.println("\nSeparate Chaining");
		sepa.remove(key);
	}
	sepa.printTable("sepa100","remove(k)");
	linear.printTable("linear100","remove(k)");
	quadra.printTable("quadra100","remove(k)");
	
	for(MapElement m: e) {
		int key=m.getKey();
		System.out.println("\nQuadraric Probing" );
		quadra.get(key);
		System.out.println("\nLinear Probing");
		linear.get(key);
		System.out.println("\nSeparate Chaining");
		sepa.get(key);
	}
	sepa.printTable("sepa100","get(k)");
	linear.printTable("linear100","get(k)");
	quadra.printTable("quadra100","get(k)");
}

}
}
