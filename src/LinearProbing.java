
public class LinearProbing extends HashTable{
	public LinearProbing(int capacity) {
		super(capacity);
		elements =new MapElement[capacity];
	}

	@Override
	public int put(MapElement e) {
		return -1;
		
	}

	@Override
	public int get(int key) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public int remove(int key) {
		// TODO Auto-generated method stub
		return 0;
	}

}
