package sudoku;

import java.awt.Color;
<<<<<<< HEAD
=======
import java.awt.Font;
>>>>>>> 244b16fe8c71decaf313fe19f152b4c60dfdcf7c
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChangeNumber {

    final JFrame change = new JFrame();

<<<<<<< HEAD
=======

>>>>>>> 244b16fe8c71decaf313fe19f152b4c60dfdcf7c
    public void Change(JButton button) {
        final JButton changeBut = button;
        change.setSize(475, 130);

        JPanel query = new JPanel();
        JLabel ask = new JLabel("Which number?");
        query.add(ask);

        class Act implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent Event) {
<<<<<<< HEAD
                changeBut.setForeground(new Color(0,180,180));
=======
                changeBut.setForeground(new Color(0, 180, 180));
                changeBut.setFont(new Font("Arial", Font.PLAIN, 25));

>>>>>>> 244b16fe8c71decaf313fe19f152b4c60dfdcf7c
                if (Event.getActionCommand().equals("-")) {
                    changeBut.setText("");
                } else {
                    int x = Integer.parseInt(Event.getActionCommand());
<<<<<<< HEAD
=======
                    changeBut.removeAll();
>>>>>>> 244b16fe8c71decaf313fe19f152b4c60dfdcf7c
                    switch (x) {
                        case 1:
                            changeBut.setText("1");
                            break;
                        case 2:
                            changeBut.setText("2");
                            break;
                        case 3:
                            changeBut.setText("3");
                            break;
                        case 4:
                            changeBut.setText("4");
                            break;
                        case 5:
                            changeBut.setText("5");
                            break;
                        case 6:
                            changeBut.setText("6");
                            break;
                        case 7:
                            changeBut.setText("7");
                            break;
                        case 8:
                            changeBut.setText("8");
                            break;
                        case 9:
                            changeBut.setText("9");
                            break;

                    }
                }
                change.dispose();
            }
        }

        ActionListener act = new Act();
        JPanel numbers = new JPanel();
        for (int x = 0; x <= 9; x++) {
            if (x == 0) {
                JButton changed = new JButton("-");
                changed.addActionListener(act);
                numbers.add(changed);
            } else {
                JButton changed = new JButton(x + "");
                changed.addActionListener(act);
                numbers.add(changed);
            }

        }

        JPanel everything = new JPanel();
        everything.add(query);
        everything.add(numbers);

        change.add(everything);
        change.setVisible(false);
        change.setResizable(false);
    }

    public void setVisible() {
        change.setLocationRelativeTo(null);
        change.setVisible(true);

    }
}
