package asterisk;

public class AsteriskArrayMaker {
	public static void fillArray(String[][] a){
		fill(a.length, a);
	}
	private static void fill(int rows, String[][] a){
		if(rows == 0)
			return;

		for(int i = 0; i < a[0].length; i++)
			a[rows - 1][i] = "*";
		
		fill(rows - 1, a);
	}
}
