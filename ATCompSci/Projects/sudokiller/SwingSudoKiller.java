package sudokiller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Graphical Sudoku game solver.
 * The user should fill the board with the puzzle to solve and click the
 * 'Start' button (or type 'ALT-s') to get the solution.
 *
 * @author Daniele Mazzocchio
 * @version 1.0
 */
public class SwingSudoKiller extends SudoKiller{

    /**
     * Draw the game board.
     * @param ssb The puzzle to solve.
     */
    public SwingSudoKiller(SwingSudokuBoard ssb) {
        super(ssb);
        final JPanel panel = ssb.getPanel();

        Runnable runner = new Runnable() {
            public void run() {
                final JFrame frame = new JFrame("SudoKiller");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                ActionListener al = new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        if (! guess(0, 0))
                            JOptionPane.showMessageDialog(frame, "Solution not found!");
                    }
                };
                frame.setLayout(new GridBagLayout());
                addComponent(frame, panel, 0, 0, 1, 1);
                
                JButton b = new JButton("Start!");
                b.setMnemonic(KeyEvent.VK_S);
                b.addActionListener(al);
                addComponent(frame, b, 0, 1, 1, 1);

                frame.setSize(240, 280);
                frame.setVisible(true);
            }
        };
        EventQueue.invokeLater(runner);
    }
    
    /**
     * Add a component to the GUI.
     * @param container Container to add the component to.
     * @param component The component to be added.
     * @param gridx Horizontal cell position inside the grid.
     * @param gridy Vertical cell position inside the grid.
     * @param gridwidth Number of cells in a row for the text field.
     * @param gridheight Number of cells in a column for the text field.
     */
    private static void addComponent(Container container, Component component,
        int gridx, int gridy, int gridwidth, int gridheight) {
        Insets insets = new Insets(0, 0, 0, 0);
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy, gridwidth,
                gridheight, 1, 1, GridBagConstraints.CENTER,
                GridBagConstraints.BOTH, insets, 0, 0);
        container.add(component, gbc);
    }
}