package sudokiller;

/**
 * This is the base class for implementing a Sudoku solver.
 * It provides a simple method for guessing the solution, but lets subclasses
 * decide how to display it.
 * 
 * @author Daniele Mazzocchio
 * @version 1.0
 */
abstract class SudoKiller {
    private SudokuBoard sb;    // Puzzle to solve;

    /**
     * Initializes the game board.
     * @param sb The puzzle to solve.
     */
    public SudoKiller(SudokuBoard sb) {
        this.sb = sb;
    }
    
    /**
     * Check if a number is, according to Sudoku rules, a legal candidate for
     * the given cell.
     * @param num Number to check.
     * @param row Cell's row.
     * @param col Cell's column.
     * @return &lt;false&gt; if &lt;num&gt; already appears in the row, column
     *         or box the cell belongs to or &lt;true&gt; otherwise.
     */
    private boolean check(int num, int row, int col) {
        int r = (row / sb.box_size) * sb.box_size;
        int c = (col / sb.box_size) * sb.box_size;
        
        for (int i = 0; i < sb.size; i++) {
            if (sb.getCell(row, i) == num ||
                sb.getCell(i, col) == num ||
                sb.getCell(r + (i % sb.box_size), c + (i / sb.box_size)) == num) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Test all candidate numbers for a given cell until the board is complete.
     * @param row Cell's row.
     * @param col Cell's column.
     * @return &lt;false&gt; if no legal numbers are found for this cell.
     */
    public boolean guess(int row, int col) {
        int nextCol = (col + 1) % sb.size;
        int nextRow = (nextCol == 0) ? row + 1 : row;
        
        try {
            if (sb.getCell(row, col) != sb.EMPTY)
                return guess(nextRow, nextCol);
        }
        catch (ArrayIndexOutOfBoundsException e) {
                return true;
        }
        
        for (int i = 1; i <= sb.size; i++) {
            if (check(i, row, col)) {
                sb.setCell(i, row, col);
                if (guess(nextRow, nextCol)) {
                    return true;
                }
            }
        }
        sb.setCell(sb.EMPTY, row, col);
        return false;
    }
}