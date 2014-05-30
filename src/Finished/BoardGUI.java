package sudoku;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardGUI {

    private JFrame frame;

    private final JPanel bottomButtons;
    private final JButton check;
    private final JButton solve;
    private final JButton newGame;

    private JPanel board;

    public BoardGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setResizable(false);
        
        board = new JPanel();
        
        
        bottomButtons = new JPanel();

        check = new JButton();
        solve = new JButton();
        newGame = new JButton();

        bottomButtons.add(check);
        bottomButtons.add(solve);
        bottomButtons.add(newGame);



    }
}
