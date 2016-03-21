package linkList;

import java.util.LinkedList;
import java.util.ListIterator;

public class Fruits {
	LinkedList<String> bowl;
	
	public Fruits(){
		bowl = new LinkedList<String>();
		bowl.addLast("apple");
		bowl.addLast("bannana");
		bowl.addLast("cherry");
		bowl.addLast("lemon");
		bowl.addLast("lime");
		bowl.addLast("orange");
		bowl.addLast("papaya");
		bowl.addLast("strawberry");
		bowl.addLast("watermelon");
		
		displayEveryOtherFruit();
	}
	
	public void displayEveryOtherFruit(){
		ListIterator<String> i = bowl.listIterator();
		int c = 0;
		while(i.hasNext())
			if(c == 0){
				System.out.println(i.next());
				c++;
			}
			else{
				i.next();
				c--;
			}
	}
	
	public static void main(String[] args){
		@SuppressWarnings("unused")
		Fruits fruit = new Fruits();
	}
}
