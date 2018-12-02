
public class QuadraticProbing extends HashTable {

	public QuadraticProbing(int capacity) {
		super(capacity);
		elements =new MapElement[capacity];
	}

	@Override
	public int put(MapElement e) {
		//return old value if old value exists
		return -1;
		
	}

	@Override
	public int get(int key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(int key) {
		// TODO Auto-generated method stub
		return 0;
	}

}
