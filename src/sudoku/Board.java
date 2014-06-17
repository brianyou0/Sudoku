package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board {

    int[][] soln;
    JFrame mainFrame;
    JButton toggleMode;
    JPanel mainPanel;
    ArrayList<JButton> jButtons;

    public void generateBoard(int p) {
        int seconds = 0;
        int minutes = 0;

        mainFrame = new JFrame("Sudoku");
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        SolutionGenerator numbers = new SolutionGenerator(p);
        soln = numbers.solve();

        jButtons = new ArrayList<>(81);
        for (int Jbutts = 0; Jbutts < 81; Jbutts++) {
            JButton b = new JButton();
            jButtons.add(b);
        }

        class buttonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                JButton source = (JButton) event.getSource();
                if (toggleMode.getText().equals("Notes")) {
                    ChangeNumber changeNum = new ChangeNumber();
                    changeNum.Change(source);
                    changeNum.setVisible();
                } else {
                    ChangeNote changeNote = new ChangeNote();
                    changeNote.Change(source);
                    changeNote.setVisible();
                }

            }
        }
        ActionListener changedBut = new buttonListener();

        class cannotChangeListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(mainFrame, "You can't change this!");
            }
        }
        ActionListener noChangedBut = new cannotChangeListener();

        JPanel panelNumbers = new JPanel();
        boolean isGreen = true;
        int row = 0;
        for (int r = 0; r < 9; r++) {
            JPanel panel = new JPanel();
            int col = 0;
            for (int c = 0; c < 9; c++) {
                int x = numbers.getNumber(r, c);
                if (x == 0) {
                    jButtons.set((r * 9) + (c), new JButton(""));
                    jButtons.get((r * 9) + (c)).addActionListener(changedBut);
                    jButtons.get((r * 9) + (c)).setPreferredSize(new Dimension(42, 27));

                } else {
                    jButtons.set((r * 9) + (c), new JButton(x + ""));
                    jButtons.get((r * 9) + (c)).addActionListener(noChangedBut);
                    jButtons.get((r * 9) + (c)).setPreferredSize(new Dimension(42, 27));
                    jButtons.get((r * 9) + (c)).setForeground(new Color(204, 0, 0));
                }
                if (isGreen) {
                    jButtons.get((r * 9) + c).setBackground(Color.YELLOW);
                } else {
                    jButtons.get((r * 9) + c).setBackground(new Color(225, 211, 255));
                }
                jButtons.get((r * 9) + c).setFont(new Font("Arial", Font.PLAIN, 25));
                panel.add(jButtons.get((r * 9) + (c)));
                panel.setLayout(new GridLayout(9, 9, 0, 0));
                col++;
                if (col == 3) {
                    isGreen = !isGreen;
                    col = 0;
                }
            }
            isGreen = !isGreen;
            row++;
            if (row == 3) {
                isGreen = !isGreen;
                row = 0;
            }
            panelNumbers.add(panel);
        }
        panelNumbers.setBackground(Color.BLUE);
        panelNumbers.setLayout(new java.awt.GridLayout(1, 1, 0, 0));

        JPanel bottomPanel = new JPanel();

        final JButton check = new JButton("Check");
        final JButton solve = new JButton("Solve");
        JButton newGame = new JButton("New Game");
        toggleMode = new JButton("Notes");

        class CheckListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {

                if (check() == 0) {
                    JOptionPane.showMessageDialog(mainFrame, "Congratulations, you won!");
                } else {
                    String mess = check() + " numbers are wrong!";
                    JOptionPane.showMessageDialog(mainFrame, mess);
                }

            }

            public int check() {
                int amountWrong = 0;
                int[][] b = new int[9][9];
                int i = 0;
                for (int x = 0; x < 9; x++) {
                    for (int y = 0; y < 9; y++) {
                        if (jButtons.get(i).getText().equals("")) {
                            b[x][y] = 0;
                        } else {
                            b[x][y] = Integer.parseInt(jButtons.get(i).getText());
                        }
                        i++;
                    }

                }
                for (int x = 0; x < 9; x++) {
                    for (int y = 0; y < 9; y++) {
                        if (!(soln[x][y] == b[x][y]) || jButtons.get(x * 9 + y).getFont().equals(new Font("Arial", Font.PLAIN, 10))) {
                            amountWrong++;
                        }
                    }
                }
                if (amountWrong == 0) {
                    solve.setEnabled(false);
                }
                return amountWrong;
            }

        }
        ActionListener check1 = new CheckListener();
        check.addActionListener(check1);

        class SolveListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                check.setEnabled(false);

                //  ChangeNumber changeNum = new ChangeNumber();
                int i = 0;
                for (int a = 0; a < 9; a++) {
                    for (int b = 0; b < 9; b++) {
                        if (!jButtons.get(i).getForeground().equals(new Color(204, 0, 0))) {
                            jButtons.get(i).setForeground(new Color(112, 0, 186));
                            jButtons.get(i).setText(soln[a][b] + "");
                            jButtons.get(i).setFont(new Font("Arial", Font.PLAIN, 25));
                            jButtons.get(i).removeActionListener(jButtons.get(i).getActionListeners()[0]);
                            jButtons.get(i).addActionListener(new cannotChangeListener());
                        } else {
                        }

                        i++;
                    }
                }
            }
        }
        ActionListener solve1 = new SolveListener();
        solve.addActionListener(solve1);

        class NewListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                Difficulty difficult = new Difficulty();
                difficult.Difficult();
                difficult.setVisible();
                mainFrame.dispose();
            }
        }
        ActionListener new1 = new NewListener();
        newGame.addActionListener(new1);

        class HintListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                if (toggleMode.getText().equals("Notes")) {
                    toggleMode.setText("Numbers");
                } else {
                    toggleMode.setText("Notes");
                }
            }
        }

        ActionListener H = new HintListener();
        toggleMode.addActionListener(H);

        bottomPanel.add(check);
        bottomPanel.add(solve);
        bottomPanel.add(newGame);
        bottomPanel.add(toggleMode);

        bottomPanel.setBackground(Color.GREEN);

        mainFrame.setResizable(false);
        mainPanel.add(panelNumbers, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainFrame.add(mainPanel);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        


    }

    public void setNonVisible() {
        mainPanel.setVisible(false);
    }

    public int getText() {
        if (toggleMode.getText().equals("Notes")) {
            return 0;
        } else {
            return 1;
        }
    }
}
