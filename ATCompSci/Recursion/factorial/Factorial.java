package factorial;

public class Factorial {
	public static int factorial(int f){
		if(f == 2)
			return 2;
		
		return f * factorial(f - 1);
	}
}
