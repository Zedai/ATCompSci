package knights;

public class Knights {
	static int steps = 1;
	int[][] board;
	int size;

	public Knights(int size) {
		board = new int[size][size];
		this.size = size;
	}

	public int[][] getBoard() {
		return board;
	}

	public void displayBoard() {
		for (int[] row : board) {
			for (int col : row)
				System.out.printf("%,3d", col);
			System.out.println();
		}
	}

	private boolean move(int startX, int startY){
		return move(startX, startY, 1);
	}
	
	private boolean move(int i, int j, int moveNum) {
		steps++;
		displayBoard();
		System.out.println();
		// off the board
		if (i < 0 || j < 0 || i >= size || j >= size)
			return false;
		// not empty
		if (board[i][j] > 0)
			return false;
		
		board[i][j] = moveNum;
		if(moveNum == size * size)
			return true;
		
		int[] myHorizMove = { 0, 1, 1, -1, -1, 2, 2, -2, -2 };
		int[] myVertMove = { 0, -2, 2, -2, 2, 1, -1, -1, 1 };
		for (int c = 1; c <= 8; c++){
			int nextI = i + myHorizMove[c];
			int nextJ = j + myVertMove[c];
			
			if(move(nextI, nextJ, moveNum + 1))
				return true;
		}
		board[i][j] = 0;
		return false;
	}

	public static void main(String[] args) {
		Knights one = new Knights(8);
		one.move(0, 0);
		one.displayBoard();
	}
}