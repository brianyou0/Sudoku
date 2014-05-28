package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomButtons {

    public JPanel bottomButtons() {

        JPanel bottomPanel = new JPanel();

        JButton check = new JButton("Check");
        JButton solve = new JButton("Solve");
        JButton newGame = new JButton("New Game");

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

            public void actionPerformed(ActionEvent event) {
                Difficulty difficult = new Difficulty();
                difficult.setVisible();
            }
        }
        ActionListener new1 = new CheckListener();
        check.addActionListener(new1);

        bottomPanel.add(check);
        bottomPanel.add(solve);
        bottomPanel.add(newGame);

        bottomPanel.setBackground(Color.GREEN);
        return bottomPanel;
    }

}
