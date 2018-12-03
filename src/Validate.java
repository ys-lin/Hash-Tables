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
		System.out.println("Quadraric Probing");
		quadra.put(e[b]);
		System.out.println("Linear Probing");
		linear.put(e[b]);
		System.out.println("Separate Chaining");
		sepa.put(e[b]);
	}
	System.out.println();
	
	for(MapElement m: e) {
		int key=m.getKey();
		System.out.println("Quadraric Probing: " + quadra.get(key));
		
		System.out.println("Linear Probing: "+linear.get(key));
		
		System.out.println("Separate Chaining:"+sepa.get(key));
		
	}
	System.out.println();
	for(int c=0;c<25;c++) {
		System.out.println(c);
		int key=e[c].getKey();
		System.out.println("Quadraric Probing:" + quadra.remove(key));
		
		System.out.println("Linear Probing: " + linear.remove(key));
		
		System.out.println("Separate Chaining: "+sepa.remove(key));
		
	}
	int counter=0;
	for(MapElement m: e) {
		System.out.println(++counter);
		int key=m.getKey();
		System.out.println("Quadraric Probing: " + quadra.get(key));
		
		System.out.println("Linear Probing: "+linear.get(key));
		
		System.out.println("Separate Chaining: "+sepa.get(key));
		
	}
	
}

}
}
