package arithmetic;

import java.util.ArrayList;
import java.util.Stack;

public class ReversePolish {
	private Stack<Double> numbers = new Stack<Double>();
	private Stack<String> operators = new Stack<String>();
	
	public static void main(String[] args){
		ReversePolish rP = new ReversePolish();
		System.out.println(rP.compute("4 - 2 / 2 ^ 2 * 2 * 7 ^ 2"));
	}
	
	//delineated by spaces
	public double compute(String expression){
		expression = expression.trim();
		numbers = new Stack<Double>();
		operators = new Stack<String>();
		
		String [] toList = expression.split(" ");
		ArrayList<String> arr = new ArrayList<String>();
		
		for(String s : toList)
			arr.add(s.trim());
		
		while(arr.size() > 0){
			if(arr.get(0).equals("+") || arr.get(0).equals("-") || arr.get(0).equals("/") || arr.get(0).equals("*") || arr.get(0).equals("^")){
				if(operators.size() > 0){
					if(operators.peek().equals("+") || operators.peek().equals("-"))
						operators.push(arr.remove(0));
					else{
						if((operators.peek().equals("/") || operators.peek().equals("*")) && (arr.get(0).equals("^")))
							operators.push(arr.remove(0));
						else if((operators.peek().equals("/") || operators.peek().equals("*")) && !(arr.get(0).equals("^")))
							simplify();
						else if(operators.peek().equals("^") && arr.get(0).equals("^"))
							operators.push(arr.remove(0));
						else if(operators.peek().equals("^") && !arr.get(0).equals("^"))
							simplify();
					}
				}
				else
					operators.push(arr.remove(0));
			}
			else{
				numbers.push(Double.parseDouble(arr.remove(0)));
			}
		}
		
		while(operators.size() > 0)
			simplify();
		
		return numbers.pop();
	}
	
	private void simplify(){
		String op = operators.pop();
		double last = numbers.pop();
		double first = numbers.pop();
		if(op.equals("+"))
			numbers.push(first + last);
		else if(op.equals("-"))
			numbers.push(first - last);
		else if(op.equals("*"))
			numbers.push(first * last);
		else if(op.equals("/"))
			numbers.push(first / last);
		else if(op.equals("^"))
			numbers.push(Math.pow(first, last));
	}
}
