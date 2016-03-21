package queen;

public class OneSolutionWorking {	
	char board[][];
	int steps = 0, numQueens = 0;
		
	public void displayBoard() {
		for (char[] row : board) {
			for (char col : row)
				System.out.print(col + " ");
			System.out.println();
		}
	}

	public OneSolutionWorking(int r){
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
		steps++;		
		for(int row = 0; row < board.length; row++)
			for(int col = 0; col < board.length; col++){
				if(isSafe(row, col)){
					char[][] prevBoard = new char[board.length][board.length];
					prevBoard = copy(board, prevBoard);
					updateBoard(row, col);
					numQueens++;
					
					displayBoard();
					System.out.println("\n\n\n");
					
					if(!move()){
						numQueens--;
						board = prevBoard;
					}
				}
			}
		
		if(numQueens == 8)			
			return true;
		
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
}