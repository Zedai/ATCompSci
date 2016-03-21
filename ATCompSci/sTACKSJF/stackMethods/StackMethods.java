package stackMethods;
import java.util.Stack;

public class StackMethods {

	public static double getAverage(Stack<Integer> one) {
		Stack<Integer> temp = new Stack<Integer>();
		double sum = 0;
		while(!one.isEmpty()){
			sum += one.peek();
			temp.push(one.pop());
		}
		
		while(!temp.isEmpty())
			one.push(temp.pop());
		
		return sum/one.size();
	}

	public static Stack<String> alternateStack(Stack<String> one,
			Stack<String> two) {
		Stack<String> kay = new Stack<String>();
		
		if(one.size() > two.size()){
			while(!two.isEmpty()){
				kay.push(one.pop());
				kay.push(two.pop());
			}
			while(!one.isEmpty())
				kay.push(one.pop());
		}
		else{
			while(!one.isEmpty()){
				kay.push(one.pop());
				kay.push(two.pop());
			}
			while(!two.isEmpty())
				kay.push(two.pop());
		}
		
		return kay;
	}

	public static Stack<String> removeEveryOther(Stack<String> one) {
		Stack<String> temp = new Stack<String>();
		while(!one.isEmpty())
			temp.push(one.pop());
		
		while(!temp.isEmpty()){
			one.push(temp.pop());
			if(!temp.isEmpty())
				temp.pop();
		}
		
		return one;
	}


	public static String display(Stack<String> one) {
		if(one.size() == 0)
			return "EMPTY";
		
		if(one.size() == 1)
			return "[" + one.peek() + "]";
		
		Stack<String> temp = new Stack<String>();
		String string = "[" + one.peek();
		temp.push(one.pop());
		
		while(!one.isEmpty()){
			string += ", " + one.peek();
			temp.push(one.pop());
		}
		
		return string += "]";
	}
}