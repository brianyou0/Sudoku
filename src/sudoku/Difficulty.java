package sudoku;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Difficulty {
    final JFrame frame = new JFrame();
    public void Difficult() {
        frame.setSize(250, 75);
        JPanel panel = new JPanel();

        final JRadioButton easy = new JRadioButton("Easy");
        final JRadioButton medium = new JRadioButton("Medium");
        final JRadioButton hard = new JRadioButton("Hard");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(easy);
        buttonGroup.add(medium);
        buttonGroup.add(hard);
        
        panel.add(easy);
        panel.add(medium);
        panel.add(hard);

        class MenuListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                Board b = new Board();
                if (easy.isSelected()) {
                    final Board easyBoard = new Board();
                    easyBoard.generateBoard(20);      
                } else if (medium.isSelected()) {
                    final Board mediumBoard = new Board();
                    mediumBoard.generateBoard(30);
                } else if (hard.isSelected()) {
                    final Board hardBoard = new Board();
                    hardBoard.generateBoard(45);                    
                }
                frame.dispose();

            }
        }

        ActionListener listener = new MenuListener();
        easy.addActionListener(listener);
        medium.addActionListener(listener);
        hard.addActionListener(listener);
        
        
        frame.add(panel);
        frame.setVisible(false);
       
    }
    public void setVisible() {
        frame.setVisible(true);
    }
    
    public void remove() {
        frame.dispose();
    }
}