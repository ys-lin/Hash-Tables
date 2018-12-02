
public class LinearProbing extends HashTable{
	private Bucket[] list;
	public LinearProbing(int capacity) {
		super(capacity);
		list =new Bucket[capacity];
	}

	@Override
	public int put(MapElement e) {
		start=System.nanoTime();
		end=System.nanoTime();
		timer("put(e)");
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

	private class Bucket{
		boolean available;
		MapElement v;
		Bucket(MapElement e){
			available=false;
			v=e;
		}
	}
}
