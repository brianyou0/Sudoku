package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomButtons {

    private JPanel panel;
    

    
    public BottomButtons() {
        
        
        check = new JButton("Check");
        solve = new JButton("Solve");
        newGame = new JButton("New Game");
        
        panel.add(check);
        panel.add(solve);
        panel.add(newGame);
    }
    
    public void bottomButtons() {
        JFrame frame = new JFrame();

        JPanel bottomPanel = new JPanel();


        class CheckListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {

            }
        }
        ActionListener check1 = new CheckListener();
        check.addActionListener(check1);

        class SolveListener implements ActionListener {

            public void actionPerformed(ActionEvent event) {

            }
        }
        ActionListener solve1 = new CheckListener();
        check.addActionListener(solve1);

        class NewListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                Difficulty difficult = new Difficulty();
                difficult.frame.setVisible(true);
            }
        }
        ActionListener new1 = new CheckListener();
        check.addActionListener(new1);

        bottomPanel.add(check);
        bottomPanel.add(solve);
        bottomPanel.add(newGame);

        bottomPanel.setBackground(Color.GREEN);
        frame.setBackground(Color.GREEN);
        frame.add(bottomPanel);
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
