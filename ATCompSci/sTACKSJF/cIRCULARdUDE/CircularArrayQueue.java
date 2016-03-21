package cIRCULARdUDE;

import java.util.ArrayList;

public class CircularArrayQueue {
	private int head; 
	private int tail;
	private int theSize;
	private Object[] elements;
	
	public CircularArrayQueue(int capacity) {
		head = -1;
		tail = -1;
		theSize = 0;
		elements = new Object[capacity];
	} 
	public void add(Object x) { 
		if(head == -1){
			head = 0;
			tail = 1;
			theSize = 1;
			elements[0] = x;
		}
		else{
			if(tail == elements.length)
				for(int i = 0; i < head; i++)
					if(elements[i] == null){
						tail = i;
						break;
					}
			if(tail == elements.length || tail == head){
				doubleIt();
				elements[tail] = x;
				tail++;
			}
			else{
				elements[tail] = x;
				tail++;
			}
		}
		
		theSize++;
	} 
	private void doubleIt(){
		Object[] doubled = new Object[elements.length * 2];
		int index = 0;
		int size = theSize;
		while(theSize > 0){
			doubled[index] = remove();
			index++;
		}
		
		head = 0;
		tail = size - 1;
		theSize = size;
		elements = doubled;	
	}
	public Object remove() {
		Object object = elements[head];
		elements[head] = null;
		head++;
		if(head == elements.length)
			head = 0;
		theSize--;
		return object;
	} 
	public int size() { 
		return theSize;
	}
	public String toString(){
		ArrayList<Object> print = new ArrayList<Object>();
		for(Object x : elements)
			print.add(x);
		
		return print.toString();
	}
}