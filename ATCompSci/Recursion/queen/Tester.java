package queen;

import java.util.ArrayList;

public class Tester {

	public static void main(String[] args){
		MultipleQueens mq = new MultipleQueens(8);
		System.out.println("Finding All Solutions>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(">Please Wait\n>\n>");
		mq.move();
		System.out.println("Solutions Found>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("\n\n");
		System.out.println("Removing Duplicates>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(">Please Wait\n>\n>");
		mq.removeDuplicates();
		System.out.println("Duplicates Removed>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n\n\n");
		
		ArrayList<char[][]> sols = mq.getSols();
		for(int i = 0; i < sols.size(); i++){
			int numSol = i + 1;
			System.out.println("Solution: " + numSol);
			print(sols.get(i));
			System.out.println("\n\n\n");
		}
//		mq.displayBoard();		
	}

	public static void print(char[][] board){
		for (char[] row : board) {
			for (char col : row)
				System.out.print(col + " ");
			System.out.println();
		}
	}
}
