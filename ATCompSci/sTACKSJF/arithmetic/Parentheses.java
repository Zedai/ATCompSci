package arithmetic;

import java.util.ArrayList;
import java.util.Stack;

public class Parentheses {
	private Stack<Double> numbers = new Stack<Double>();
	private Stack<String> operators = new Stack<String>();
	
	public static void main(String[] args){
		Parentheses rP = new Parentheses();
//		System.out.println(rP.compute("4 - 2 / 2 ^ 2 * 2 * 7 ^ 2"));
		System.out.println("( ( ( 4 + 2 ) * 3 ) / 2 ) ^ ( 1 / 2 )");
		System.out.println("= " + rP.compute("( ( ( 4 + 2 ) * 3 ) / 2 ) ^ ( 1 / 2 )"));
		System.out.println("\n( 3 + 3 ) * ( 4 + 4 ) - 9");
		System.out.println("= " + rP.compute("( 3 + 3 ) * ( 4 + 4 ) - 9"));
		System.out.println("\n4 + 2 * 10 - 3 * 2");
		System.out.println("= " + rP.compute("4 + 2 * 10 - 3 * 2"));
		System.out.println("\n3 * ( 4 + 2 ) + 5");
		System.out.println("= " + rP.compute("3 * ( 4 + 2 ) + 5"));

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
			if(arr.size() == 1 && arr.get(0).equals(")")){
				break;
			}
			else if(arr.get(0).equals("(")){
				Parentheses p = new Parentheses();
				String compute = "";
				arr.remove(0);
				
				int numOpen = 1, numClose = 0;
				while(numOpen != numClose){
					if(arr.get(0).equals(")"))
						numClose++;
					else if(arr.get(0).equals("("))
						numOpen++;
					compute += arr.remove(0) + " ";
					
				}
							
				numbers.push(p.compute(compute));
			}
			else{
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