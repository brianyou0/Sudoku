package sudoku;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DifficultyGUI {

    private final JFrame frame;
    private final JPanel panel;

    private final JButton easy;
    private final JButton medium;
    private final JButton hard;

    public DifficultyGUI() {
        easy = new JButton("Easy");
        easy.setBackground(Color.GREEN);
        medium = new JButton("Medium");
        hard = new JButton("Hard");

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
        panel = new JPanel();
        panel.add(easy);
        panel.add(medium);
        panel.add(hard);

        frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 75);
        frame.setVisible(true);

    }

}
