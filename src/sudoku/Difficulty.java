package sudoku;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Difficulty {
    final JFrame frame = new JFrame();
    public void Difficult() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 75);
        JPanel panel = new JPanel();

        final JButton easy = new JButton("Easy");
        final JButton medium = new JButton("Medium");
        final JButton hard = new JButton("Hard");

        panel.add(easy);
        panel.add(medium);
        panel.add(hard);

        class MenuListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                if (easy.isSelected()) {
                    // Call method "cover" with param "15"
                } else if (medium.isSelected()) {
                    // Call method "cover" with param "10"
                } else if (hard.isSelected()) {
                    // Call method "cover" with param "5"
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
    public void setVisible(){
            frame.setVisible(true);
        }

}