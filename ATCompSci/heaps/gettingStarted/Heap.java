package gettingStarted;

import java.util.List;
import java.util.ArrayList;
import static java.lang.System.*;

public class Heap {
	private List<Integer> list;

	public Heap() {
		list = new ArrayList<Integer>();
	}

	public void add(int value) {
		list.add(value);
		swapUp(list.size() - 1);
	}

	public void swapUp(int bot) {
		if (bot > 0) {
			int parent = (bot - 1) / 2;
			if (list.get(parent) < list.get(bot)) {
				swap(parent, bot);
				swapUp(parent);
			} 
		}
	}

	public void remove() {
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		swapDown(list.size());
	}

	public void swapDown(int top) {
		int root = 0;
		while(root < list.size()){
			int left = root*2+1, right = root*2+2;
			int max = root;
			if(left < list.size())
				if(list.get(left) > list.get(max))
					max = left;
			if(right < list.size())
				if(list.get(right) > list.get(max))
					max = right;
			
			if(max > root){
				swap(max, root);
				root = max;
			}
			else
				break;
		}
	}

	private void swap(int start, int finish) {
		int temp = list.get(start);
		list.set(start, list.get(finish));
		list.set(finish, temp);
	}

	public void print() {
		out.println("\n\nPRINTING THE HEAP!\n\n");
		out.println(toString());
		double l = Math.sqrt(list.size());
		int levels = (int)l;
		if(l > (int)l)
			levels++;
		
		int index = 0;
		if(levels <= 0)
			return;		
		for(int lIndex = 0; lIndex <= levels; lIndex++){
				tab(levels - lIndex, (int)(4 + lIndex/-2));
			for(int i = 0; i < Math.pow(2, lIndex); i++)
				if(index < list.size()){
					out.print(list.get(index) + "    ");
					index++;
				}
			System.out.println();
		}
			
	}
	
	public void tab(int levels, int length){
		for(int i = 0; i < levels; i++)
			for(int a = 0; a < length; a++)
				System.out.print(" ");
	}

	public String toString() {
		return list.toString();
	}
}