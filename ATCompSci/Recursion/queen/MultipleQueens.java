package queen;

import java.util.ArrayList;

public class MultipleQueens {	
	char board[][];
	int solution = 0, numQueens = 0;
	ArrayList<char[][]> solutions = new ArrayList<char[][]>();
		
	public void displayBoard() {
		System.out.println("Solution: " + solution) ;
		for (char[] row : board) {
			for (char col : row)
				System.out.print(col + " ");
			System.out.println();
		}
	}

	public MultipleQueens(int r){
		board = new char[r][r];
		for(int row = 0; row < r; row++)
			for(int col = 0; col < r; col++)
				board[row][col] = ' ';
//		prevBoard = new char[r][r];
//		prevBoard = copy(board, prevBoard);
	}
	
	public static char[][] copy(char[][] src, char[][] dest){
		for(int i = 0; i < src.length; i++)
			System.arraycopy(src[i], 0, dest[i], 0, src[i].length);
		
		return dest;
	}
	
	private boolean isSafe(int r, int c){
		return board[r][c] != 'Q' && board[r][c] != '*';
	}
	
	public boolean move() {				
		for(int row = 0; row < board.length; row++)
			for(int col = 0; col < board.length; col++){
				if(isSafe(row, col)){
					char[][] prevBoard = new char[board.length][board.length];
					prevBoard = copy(board, prevBoard);
					updateBoard(row, col);
					numQueens++;
					if(!move()){
						numQueens--;
						board = prevBoard;
					}
					
					if(numQueens == 8){
						solution++;
//						displayBoard();
//						System.out.println("\n\n\n");
						char[][] addSol = new char[board.length][board.length];
						addSol = copy(board, addSol);
						solutions.add(addSol);
						numQueens--;
						board = prevBoard;
					}
				}
			}
		
//		if(numQueens == 8){
//			displayBoard();
//			numQueens = 0;
//			
//			return true;
//		}
		
		if(numQueens == 8){
//			displayBoard();
			return true;
		}
		return false;
	}

	private void updateBoard(int row, int col) {
		board[row][col] = 'Q';
		Queen q = new Queen(row, col, board.length);
	    boolean[][] newBoard = q.getBoard();
	    
	    for(int r = 0; r < board.length; r++)
	    	for(int c = 0; c < board.length; c++){
	    		if(board[r][c] == ' ')
	    			if(newBoard[r][c] == false)
	    				board[r][c] = '*';
	    	}
	}
	
	public ArrayList<char[][]> getSols(){
		return solutions;
	}
	public void removeDuplicates(){		
		for(int i = 0; i < solutions.size() - 1; i++)
			for(int j = solutions.size() - 1; j > 0; j--)
				if(i < solutions.size() && j < solutions.size())
					if(equals(solutions.get(i), solutions.get(j)))
						solutions.remove(j);
	}
	
	private boolean equals(char[][] one, char[][] two){
		for(int row = 0; row < one.length; row++)
			for(int col = 0; col < one.length; col++)
				if(one[row][col] != two[row][col])
					return false;
		
		return true;
	}
}
