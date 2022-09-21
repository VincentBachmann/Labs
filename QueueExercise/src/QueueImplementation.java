import java.util.ArrayList;

public class QueueImplementation<T> implements Queue<T>{
	
	private ArrayList<T> myItems = new ArrayList<T>();

	@Override
	public void add(T item) {
		myItems.add(0, item);
	}

	@Override
	public T remove() {
		if(! myItems.isEmpty())
		{
			T pop = myItems.get(myItems.size()-1);
			myItems.remove(myItems.size() - 1);
			return pop;
			}
		else
		{	
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		if (myItems.isEmpty())
		{
			return true;
						}
		else
		{
			return false;
		}
	}
	

}
