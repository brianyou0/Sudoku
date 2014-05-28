package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board {

    public void generateBoard() {
        JFrame mainFrame = new JFrame("Sudoku");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel bottomPanel = new JPanel();

        ArrayList<JButton> jButtons = new ArrayList<>(81);
        for (int Jbutts = 0; Jbutts < 81; Jbutts++) {
            JButton b = new JButton();
            b.setBackground(Color.GREEN);

            jButtons.add(b);

        }

        class buttonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                JButton source = (JButton) event.getSource();
                ChangeNumber changeNum = new ChangeNumber();
                changeNum.Change(source);
                changeNum.setVisible();

            }
        }
        ActionListener changedBut = new buttonListener();
        JPanel panelNumbers = new JPanel();
        for (int r = 0; r < 9; r++) {
            JPanel panel = new JPanel();
            for (int c = 0; c < 9; c++) {
                jButtons.set((r * 9) + (c), new JButton(c + 1 + ""));
                panel.add(jButtons.get((r * 9) + (c)));
                jButtons.get((r * 9) + (c)).addActionListener(changedBut);
                panel.setBackground(Color.CYAN);
            }
            panelNumbers.add(panel);
        }
        panelNumbers.setBackground(Color.BLUE);

        BottomButtons bottomButtons = new BottomButtons();
        bottomPanel.add(bottomButtons.bottomButtons());

        AddLines lines = new AddLines();

        mainFrame.setResizable(false);
        mainPanel.add(panelNumbers, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        //mainPanel.add(lines);
        mainFrame.add(mainPanel);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 450);
        mainFrame.setVisible(true);

    }
}
