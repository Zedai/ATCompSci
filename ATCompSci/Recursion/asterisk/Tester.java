package asterisk;

public class Tester {

	public static void main(String[] args) {
		String[][] a = new String[5][7];
		AsteriskArrayMaker.fillArray(a);
		
		for(String[] r : a){
			for(String c : r)
				System.out.print(c);
			System.out.println();
		}
	}

}
