package myStack;

public class ArrayStack implements MyStack{
	Object[] myArray = new Object[0];
	
	@Override
	public Object push(Object item) {
		if(myArray.length > 0){
			Object[] newArray = new Object[myArray.length + 1];
			for(int i = 0; i < myArray.length; i++)
				newArray[i] = myArray[i];
			
			newArray[myArray.length] = item;
			myArray = newArray;
		}
		else{
			myArray = new Object[1];
			myArray[0] = item;
		}
		
		return item;
	}

	@Override
	public Object pop() {
		if(myArray.length == 0)
			return null;
		
		Object item = myArray[myArray.length - 1];
		Object[] newArray = new Object[myArray.length - 1];
		
		for(int i = 0; i < newArray.length; i++)
			newArray[i] = myArray[i];
		
		myArray = newArray;
		return item;
	}

	@Override
	public Object peek() {
		if(myArray.length == 0)
			return null;
		
		return myArray[myArray.length - 1];
	}

	@Override
	public boolean isEmpty() {
		return myArray.length == 0;
	}

	@Override
	public int size() {
		return myArray.length;
	}

	@Override
	public int search(Object a) {
		for(int i = 0; i < myArray.length; i++)
			if(myArray[i].equals(a))
				return myArray.length - i;
		return -1;
	}
	
	public String toString(){
		if(myArray.length == 0)
			return "EMPTY";
		
		if(myArray.length == 1)
			return "[" + myArray[0] + "]";
		
		String string = "[";
		string += myArray[myArray.length - 1];
		for(int i = myArray.length - 2; i >= 0; i--)
			string += ", " + myArray[i];
		
		return string += "]";
	}
}