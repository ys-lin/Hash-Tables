import java.util.Random;

public class Driver {
	
	public void DynamicResizing(LinearProbing LB) {
		int capacity = 128;
		if(LB.size() == 0.5*LB.size()) {
			LB.size = 2*LB.size();
		}
	}
	
	public static void main(String[] args) {
		
		SeparateChaining HSChaining = new SeparateChaining(100);
		LinearProbing HSLinear = new LinearProbing(100);
		QuadraticProbing HSQuadratic = new QuadraticProbing(100);
		
		// Create 150 pairs
		MapElement Pairs[] = new MapElement[150];
		
		// For SeparateChaining
		HSChaining.timeToPut(Pairs, 50, "SeparateChaining", "HSChaining");
		HSChaining.timeToPut(Pairs, 75, "SeparateChaining", "HSChaining");
		HSChaining.timeToPut(Pairs, 95, "SeparateChaining", "HSChaining");
		HSChaining.timeToPut(Pairs, 150, "SeparateChaining", "HSChaining");
		
		// For LinearProbing
		HSLinear.timeToPut(Pairs, 50, "LinearProbing", "HSLinear");
		HSLinear.timeToPut(Pairs, 75, "LinearProbing", "HSLinear");
		HSLinear.timeToPut(Pairs, 95, "LinearProbing", "HSLinear");
		HSLinear.timeToPut(Pairs, 150, "LinearProbing", "HSLinear");
		
		// For QuadraticProbing
		HSQuadratic.timeToPut(Pairs, 50, "QuadraticProbing", "HSQuadratic");
		HSQuadratic.timeToPut(Pairs, 75, "QuadraticProbing", "HSQuadratic");
		HSQuadratic.timeToPut(Pairs, 95, "QuadraticProbing", "HSQuadratic");
		HSQuadratic.timeToPut(Pairs, 150, "QuadraticProbing", "HSQuadratic");
		
		// For QuadraticProbing at capacity 101
		QuadraticProbing QP = new QuadraticProbing(101);
		QP.timeToPut(Pairs, 50, "QP101", "QP");
		QP.timeToPut(Pairs, 75, "QP101", "QP");
		QP.timeToPut(Pairs, 95, "QP101", "QP");
		QP.timeToPut(Pairs, 150, "QP101", "QP");
		
	}
}
