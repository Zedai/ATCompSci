package monsters;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("rawtypes")
public class YourPQ
{
	private List<Comparable> list;

	public YourPQ()
	{
		list = new ArrayList<Comparable>();
	}

	public void add(Comparable obj)
	{
		list.add(obj);
		swapUp(list.size() - 1);
	}
	
	private void swap(int start, int finish) {
		Comparable temp = list.get(start);
		list.set(start, list.get(finish));
		list.set(finish, temp);
	}

	@SuppressWarnings("unchecked")
	public void swapUp(int bot) {
		if (bot > 0) {
			int parent = (bot - 1) / 2;
			if (list.get(parent).compareTo(list.get(bot)) > 0) {
				swap(parent, bot);
				swapUp(parent);
			} 
		}
	}

	public boolean isEmpty(){
		return list.size() == 0;
	}
	
	public Object getMin()
	{
		return list.get(0);
	}
	
	public Object removeMin()
	{
		Object obj = list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		swapDown(list.size());
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public void swapDown(int top) {
		int root = 0;
		while(root < list.size()){
			int left = root*2+1, right = root*2+2;
			int max = root;
			if(left < list.size())
				if(list.get(left).compareTo(list.get(max)) < 0)
					max = left;
			if(right < list.size())
				if(list.get(right).compareTo(list.get(max)) < 0)
					max = right;
			
			if(max > root){
				swap(max, root);
				root = max;
			}
			else
				break;
		}
	}

	public String getNaturalOrder()
	{
		String output="";
		while(!this.isEmpty())
		{
			output+=this.removeMin()+ " ";
		}
		return output;		
	}

	public String toString() {
		return list.toString();
	}
}