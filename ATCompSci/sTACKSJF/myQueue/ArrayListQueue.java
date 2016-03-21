package myQueue;

import java.util.ArrayList;

public class ArrayListQueue implements MyQueue{
	ArrayList<Object> myArrayList = new ArrayList<Object>();
	
	@Override
	public Object push(Object item) {
		myArrayList.add(item);
		return item;
	}

	@Override
	public Object pop() {
		return myArrayList.remove(0);
	}

	@Override
	public Object peek() {
		return myArrayList.get(0);
	}

	@Override
	public boolean isEmpty() {
		return myArrayList.size() == 0;
	}

	@Override
	public int size() {
		return myArrayList.size();
	}

	@Override
	public int search(Object a) {
		for(int i = 0; i < myArrayList.size(); i++)
			if(myArrayList.get(i).equals(a))
				return i + 1;
		
		return -1;
	}
	
	public String toString(){
		if(myArrayList.size() == 0)
			return "EMPTY";
		
		if(myArrayList.size() == 1)
			return "[" + myArrayList.get(0) + "]";
		
		String string = "[";
		string += myArrayList.get(0);
		for(int i = 1; i < myArrayList.size(); i++)
			string += ", " + myArrayList.get(i);
		
		return string += "]";
	}
}