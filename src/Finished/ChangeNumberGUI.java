package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChangeNumberGUI {

    private final JFrame frame;
    private final JPanel panel;
    private final JPanel subPanel1;
    private final JPanel subPanel2;

    private final JLabel query;
    private ArrayList<JButton> numbers;

    public ChangeNumberGUI() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(450, 130);

        panel = new JPanel();

        query = new JLabel("Which number?");
        subPanel1 = new JPanel();
        subPanel1.add(query);
        panel.add(subPanel1);
        
        class Act implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent Event) {
                int x = Integer.parseInt(Event.getActionCommand());
                switch (x) {
                    case 1:
                        // Change to 1
                        break;
                    case 2:
                        // change to 2
                        break;
                    case 3:
                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:

                        break;
                }
                frame.dispose();
            }
        }
        
        Act a = new Act();
        subPanel2 = new JPanel();
        for (int x = 1; x <= 9; x++) {
            JButton b = new JButton(x + "");
            b.addActionListener(a);
            subPanel2.add(b);
        }

        ActionListener act = new Act();
        JPanel num = new JPanel();
        for (int x = 1; x <= 9; x++) {
            JButton button = new JButton(x + "");
            button.addActionListener(act);
            num.add(button);

        }
        panel.add(subPanel1);
        panel.add(subPanel2);

        frame.add(panel);
        frame.setVisible(true);

    }
}
