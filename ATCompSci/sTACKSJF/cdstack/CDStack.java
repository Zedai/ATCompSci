package cdstack;

import java.util.Iterator;
import java.util.Stack;


public class CDStack {
	Stack <String> myStack;

	public CDStack(){
		myStack = new Stack<String>();
		myStack.push("Journey");
		myStack.push("Iggy Pop");
		myStack.push("Hall & Oats");
		myStack.push("Genesis");
		myStack.push("Foreigner");
		myStack.push("Eagles");
		myStack.push("Deep Purple");
		myStack.push("Cheap Trick");
		myStack.push("Beatles");
		myStack.push("Aerosmith");
	}
	
	public String nextCD(){
		return myStack.peek();
	}
	
	public String playNext(){
		return myStack.pop();
	}
	
	public void printCDs(){
		while(!myStack.isEmpty())
			System.out.print(myStack.pop() + " ");
	}
	
	public void printCDs2(){
		Iterator<String> i = myStack.iterator();
		while(i.hasNext())
			System.out.println(i.next());
	}
	
	public void printCDs3(){
		for(String x : myStack)
			System.out.println(x);
	}
	
	public void printCDs4(Stack<String> stack){
		if(stack.iterator().hasNext()){
			System.out.println(stack.pop());
			printCDs4(stack);
		}
	}
	
	public void reverse(){
		Stack<String> reverse = new Stack<String>();
		while(!myStack.isEmpty())
			reverse.push(myStack.pop());
		myStack = reverse;
	}
	
	public void combine(CDStack two){
		two.reverse();
		while(!two.myStack.isEmpty())
			myStack.push(two.myStack.pop());
	}
	
	public static int convertToBinary(int x){
		Stack<Integer> stack = new Stack<Integer>();
		while(x > 0){
			stack.push(x % 2);
			x /= 2;
		}
		
		String string = "";
		while(!stack.isEmpty())
			string += stack.pop();
		
		return Integer.parseInt(string);
	}
	
	public static void main(String[] args){
		CDStack stack = new CDStack();
//		ListIterator iter = stack.myStack.listIterator();
//		while(iter.hasNext())
//			if(iter.next().equals("Beatles"))
//		stack.printCDs();
//		stack.printCDs4(stack.myStack);		
		CDStack two = new CDStack();
		two.myStack = new Stack<String>();
		two.myStack.push("CookiesRFun");
		two.myStack.push("BartGoesToSchool");
		two.myStack.push("AlphabetSongs");
		
		stack.printCDs2();
		System.out.println("\n\n");
		two.printCDs2();
		System.out.println("\n\n");
		stack.combine(two);
		stack.printCDs2();
		System.out.println("\n\n");

		System.out.println(convertToBinary(34));
		System.out.println(convertToBinary(127));
		System.out.println(convertToBinary(24));
	}
}
