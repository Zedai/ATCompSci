package sudokiller;

/**
 * Sudoku game solver.
 * It creates a GUI with a default puzzle; you can replace it with the puzzle
 * you want to solve. Then click the 'Start' button (or type 'ALT-s') to get the
 * solution.
 *
 * @author Daniele Mazzocchio
 * @version 1.0
 */
public class Main {
    
    /**
     * Creates the GUI with a default puzzle.
     * @params args Command-line arguments (unused)
     */
    public static void main(String[] args) {
        int[][] board = {{0, 6, 0, 1, 0, 4, 0, 5, 0},
                         {0, 0, 8, 3, 0, 5, 6, 0, 0},
                         {2, 0, 0, 0, 0, 0, 0, 0, 1},
                         {8, 0, 0, 4, 0, 7, 0, 0, 6},
                         {0, 0, 6, 0, 0, 0, 3, 0, 0},
                         {7, 0, 0, 9, 0, 1, 0, 0, 4},
                         {5, 0, 0, 0, 0, 0, 0, 0, 2},
                         {0, 0, 7, 2, 0, 6, 9, 0, 0},
                         {0, 4, 0, 5, 0, 8, 0, 7, 0}};
        
        new SwingSudoKiller(new SwingSudokuBoard(board));
    }   
}