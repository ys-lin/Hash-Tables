
public class LinearProbing extends HashTable{
	private Bucket[] list;
	public LinearProbing(int capacity) {
		super(capacity);
		list =new Bucket[capacity];
	}

	@Override
	public int put(MapElement e) {
		start=System.nanoTime();
		size++;
		int i=index(e);
		if(list[i]==null) {
			list[i]=new Bucket(e);
		}else if (list[i].available) {
			list[i].v=e;
			list[i].available=false;
		}else {
			
		}
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
