package maze;

public class Maze {
	private char[][]maze;
	private int x, y, steps = 0;
	private char breadCrumb = 63;
	
	public Maze(char[][] m, int i, int j) {
		maze = m;
		x = i;
		y = j;
	}

	public int getJExit() {
		for(int col = 0; col < maze[0].length; col++)
			if(maze[0][col] == ' '|| maze[maze.length - 1][col] == ' ')
				return col;
		
		for(int row = 0; row < maze.length; row++)
			if(maze[row][0] == ' ')
				return 0;
			else if(maze[row][maze[0].length - 1] == ' ')
				return maze[0].length - 1;

		return -1;
	}

	public void display() {
		for(char[] r : maze){
			for(char c : r)
				System.out.print(c);
			System.out.println();
		}		
	}

	public boolean findExit() {
		for(int col = 0; col < maze[0].length; col++)
			if(maze[0][col] == ' '|| maze[maze.length - 1][col] == ' ')
				return true;
		
		for(int row = 0; row < maze.length; row++)
			if(maze[row][0] == ' ' || maze[row][maze[0].length - 1] == ' ')
				return true;
		return false;
	}

	public int getIExit() {
		for(int col = 0; col < maze[0].length; col++)
			if(maze[0][col] == ' ')
				return 0;
			else if(maze[maze.length - 1][col] == ' ')
				return maze.length - 1;
		
		for(int row = 0; row < maze.length; row++)
			if(maze[row][0] == ' ' || maze[row][maze[0].length - 1] == ' ')
				return row;
		return -1;
	}

	public String getSteps() {
		steps++;
		breadCrumb++;
		if(x == getIExit() && y == getJExit()){
			maze[x][y] = breadCrumb;
			System.out.println("\n\n");
			display();
			return null;
		}
		maze[x][y] = breadCrumb;
		System.out.println("\n\n");
		display();
		System.out.println("Steps: " + steps + "\t Moved to (" + x + ", " + y + ")");
		char up = maze[x - 1][y], down = maze[x + 1][y], left = maze[x][y - 1], right = maze[x][y + 1];
		if(up == ' '){
			x--;
			getSteps();
		}
		else if(right == ' '){
			y++;
			getSteps();
		}
		else if(left == ' '){
			y--;
			getSteps();
		}
		else if(down == ' '){
			x++;
			getSteps();
		}
		else{
		int traceBreadCrumb = breadCrumb;
		while(up != ' ' && down != ' ' && left != ' ' && right != ' '){
			traceBreadCrumb--;
			char searchChar = (char) traceBreadCrumb;
			x = this.getSearchRow(searchChar);
			y = this.getSearchCol(searchChar);
			up = maze[x - 1][y];
			down = maze[x + 1][y];
			left = maze[x][y - 1];
			right = maze[x][y + 1];
		}
		
		if(up == ' '){
			x--;
			getSteps();
		}
		else if(right == ' '){
			y++;
			getSteps();
		}
		else if(left == ' '){
			y--;
			getSteps();
		}
		else if(down == ' '){
			x++;
			getSteps();
		}
		}
		return steps + "\t Reached Exit";
	}
	
	public int getSearchRow(char s){
		for(int row = 0; row < maze.length; row++)
			for(int col = 0; col < maze[0].length; col++)
				if(maze[row][col] == s)
					return row;
		return - 1;
	}
	
	public int getSearchCol(char s){
		for(int row = 0; row < maze.length; row++)
			for(int col = 0; col < maze[0].length; col++)
				if(maze[row][col] == s)
					return col;
		return - 1;
	}
}
