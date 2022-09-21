import java.util.ArrayList;

public class StackImplementation<T> implements Stack<T>{
	
	private ArrayList<T> myItems = new ArrayList<T>();
	
	@Override
	public void push(T item) {
		myItems.add(item);
		
	}

	@Override
	public T pop() {
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
