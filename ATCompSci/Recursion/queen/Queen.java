package queen;

public class Queen {
	static boolean board[][];
	int row, col, size, checkX = 0, checkY = 0;

	public static void main(String[] args){
		
		@SuppressWarnings("unused")
		Queen q = new Queen(3, 5, 8);
		displayBoard();
	}
	
	public Queen(int x, int y, int size){
		this.row = x;
		this.col =
				y;
		this.size = size;
		board = new boolean[size][size];
		isSafe(0, 0);
	}
	
	public static void displayBoard(){
		for(boolean[] r : board){
			for(boolean c : r)
				if(c)
					System.err.print("T ");
				else
					System.err.print("F ");

			System.err.println();
		}

	}
	public void isSafe(int x, int y){
		if(y == size)
			return;
		
		if(x != row && y != col){
			if(x == row || y == col)
				board[x][y] = false;
			else{
				checkX = x;
				checkY = y;
				board[x][y] = checkDiag(row, col);
			}
			
//			if (x == row)
//				for (int i = 0; i < board[0].length; i ++)
//					board[x][i] = false;
//			if (y == col)
//				for (int i = 0; i < board.length; i ++)
//					board[i][y] = false;
		}		
		
		if(x == size - 1)
			isSafe(0, ++y);
		else
			isSafe(++x, y);
	}
	
	private boolean checkDiag(int x, int y){
		return !(checkUpRDiag(x, y) || checkDownRDiag(x, y) || checkUpLDiag(x, y) || checkDownLDiag(x, y));
	} 
	
	private boolean checkUpLDiag(int x, int y){
		if (x == 0 || y == 0)
			if(x == checkX && y == checkY)
				return true;
			else
				return false;
		
		if(x == checkX && y == checkY)
			return true;
		return checkUpLDiag(--x, --y);
	}	

	private boolean checkDownRDiag(int x, int y){
		if (x == board.length-1 || y == board[0].length-1)
			if(x == checkX && y == checkY)
				return true;
			else
				return false;
		
		if(x == checkX && y == checkY)
			return true;
		return checkDownRDiag(++x, ++y);
	}	
	
	private boolean checkDownLDiag(int x, int y){
		if (y == 0 || x == board.length-1)
			if(x == checkX && y == checkY)
				return true;
			else
				return false;
		
		if(x == checkX && y == checkY)
			return true;
		return checkDownLDiag(++x, --y);
	}
	
	private boolean checkUpRDiag(int x, int y){
		if (x == 0 || y == board[0].length-1)
			if(x == checkX && y == checkY)
				return true;
			else
				return false;
			
		if(x == checkX && y == checkY)
			return true;
		return checkUpRDiag(--x, ++y);
	}
	
	public boolean[][] getBoard(){
		return board;
	}
}
