package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow {

    public final JFrame frame = new JFrame("Sudoku");
    public final JPanel panel = new JPanel();
    public JPanel textPanel = new JPanel();
    public JLabel words = new JLabel("Welcome to Sudoku!");

    public void createBoard() {
        words.setForeground(Color.BLUE);
        textPanel.add(words);

        ButtonGroup buttonGroup = new ButtonGroup();
        final JRadioButton easy = new JRadioButton("Easy");
        final JRadioButton medium = new JRadioButton("Medium");
        final JRadioButton hard = new JRadioButton("Hard");

        buttonGroup.add(easy);
        buttonGroup.add(medium);
        buttonGroup.add(hard);

        easy.setBackground(Color.CYAN);
        medium.setBackground(Color.CYAN);
        hard.setBackground(Color.CYAN);

        panel.add(easy);
        panel.add(medium);
        panel.add(hard);

        class MenuListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                if (easy.isSelected()) {
                    // Call method "cover" with param "15"
                    final Board mediumBoard = new Board();
                    mediumBoard.generateBoard(20);
                } else if (medium.isSelected()) {
                    // Call method "cover" with param "10"
                    final Board mediumBoard = new Board();
                    mediumBoard.generateBoard(35);
                } else if (hard.isSelected()) {
                    // Call method "cover" with param "5"
                    final Board hardBoard = new Board();
                    hardBoard.generateBoard(50);
                }
                frame.dispose();
            }
        }

        ActionListener listener = new MenuListener();
        easy.addActionListener(listener);
        medium.addActionListener(listener);
        hard.addActionListener(listener);

        panel.setBackground(Color.GREEN);
        frame.setResizable(false);
        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
