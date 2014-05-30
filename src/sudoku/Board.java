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
    int [][] soln;
    public void generateBoard(int p){
        final JFrame mainFrame = new JFrame("Sudoku");
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel bottomPanel = new JPanel();
        SolutionGenerator numbers = new SolutionGenerator(p);
        soln = numbers.solve();
        
        ArrayList<JButton> jButtons = new ArrayList<>(81);
        for(int Jbutts = 0; Jbutts < 81; Jbutts++){
            JButton b = new JButton();
            jButtons.add(b);
        }
                
         class buttonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event){
                JButton source = (JButton)event.getSource();
                ChangeNumber changeNum = new ChangeNumber();
                changeNum.Change(source);
                changeNum.setVisible();
                
            }
        }
        ActionListener changedBut = new buttonListener();
        
        class cannotChangeListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event){
                JOptionPane.showMessageDialog(mainFrame, "You can't change this!");               
            }
        }
        ActionListener noChangedBut = new cannotChangeListener();
        
        JPanel panelNumbers = new JPanel();
        boolean isGreen = true;
        int row = 0;
        for(int r = 0; r < 9; r++){
            JPanel panel = new JPanel();
            int col = 0;
            for(int c = 0; c < 9; c++){
                int x = numbers.getNumber(r,c);
                if(x==0){                  
                    jButtons.set((r*9)+(c), new JButton(""));
                    jButtons.get((r*9)+(c)).addActionListener(changedBut);
                    jButtons.get((r*9)+(c)).setPreferredSize(new Dimension(42, 27));
                         
                }
                else{
                    jButtons.set((r*9)+(c), new JButton(x+""));
                    jButtons.get((r*9)+(c)).addActionListener(noChangedBut);
                    jButtons.get((r*9)+(c)).setPreferredSize(new Dimension(42, 27));
                    jButtons.get((r*9)+(c)).setForeground(new Color(204, 0, 0));
                }
                if (isGreen)
                    jButtons.get((r*9)+c).setBackground(Color.YELLOW);
                else
                    jButtons.get((r*9)+c).setBackground(new Color(225,211,255));
                panel.add(jButtons.get((r*9)+(c)));
                panel.setBackground(Color.WHITE);
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
               
        BottomButtons bottomButtons = new BottomButtons();
        bottomPanel.add(bottomButtons.bottomButtons());
        
        //TO ADD THE LINES TO MAKE IT LOOK CLEARER
        AddLines lines = new AddLines();
                
        mainFrame.setResizable(false);
        mainPanel.add(panelNumbers, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        //mainPanel.add(lines);
        mainFrame.add(mainPanel);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500,460);
        mainFrame.setVisible(true);
        
    }
}
