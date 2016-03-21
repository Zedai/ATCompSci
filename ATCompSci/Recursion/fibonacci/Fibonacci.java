package fibonacci;

public class Fibonacci {
	public static int fibonacci(int i){
		if(i <= 2)
			return 1;
		return fibonacci(i - 1) + fibonacci(i - 2);
	}
}