package sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChangeNote extends ChangeNumber {

    private String notes;

    @Override
    public void Change(final JButton button) {
        final JButton changeBut = button;
        change.setSize(475, 150);

        JPanel query = new JPanel();
        JLabel ask = new JLabel("Which number(s)?");
        query.add(ask);

        class Act implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent Event) {
                if (button.getFont().equals(new Font("Arial", Font.PLAIN, 25))) {
                    button.setText("");
                }
                notes = button.getText();

                changeBut.setForeground(new Color(0, 180, 180));
                changeBut.setFont(new Font("Arial", Font.PLAIN, 11));
                int x = Integer.parseInt(Event.getActionCommand());
                switch (x) {
                    case 1:
                        /*if (notes.indexOf("1") == -1) {
                         notes += "1";
                         } else {
                         String a = notes.substring(0, notes.indexOf("1"));
                         String b = notes.substring(notes.indexOf("1") + 1);
                         notes = a + b;
                         }*/
                        check(1);
                        break;
                    case 2:
                        check(2);
                        break;
                    case 3:
                        check(3);
                        break;
                    case 4:
                        check(4);
                        break;
                    case 5:
                        check(5);
                        break;
                    case 6:
                        check(6);
                        break;
                    case 7:
                        check(7);
                        break;
                    case 8:
                        check(8);
                        break;
                    case 9:
                        check(9);
                        break;
                }
                /*if (notes.length() > 3) {
                 String a = notes.substring(0, 3);
                 String b = notes.substring(3);
                 notes = a + "\n" + b;
                 }
                 else if (notes.length() > 6) {
                 String a = notes.substring(0, 3);
                 String b = notes.substring(3, 6);
                 String c = notes.substring(6);
                 notes = a + "\n" + b + "\n" + c;
                 }
                 */
                changeBut.removeAll();
                if (notes.length() > 3 && notes.length() < 6) {

                    JLabel a = new JLabel(notes.substring(0, 3));
                    JLabel b = new JLabel(notes.substring(3));
                    a.setForeground(changeBut.getForeground());
                    b.setForeground(changeBut.getForeground());
                    changeBut.setForeground(changeBut.getBackground());
                    JPanel master = new JPanel();
                    a.setFont(changeBut.getFont());
                    b.setFont(changeBut.getFont());
                    master.add(a);
                    master.add(b);
                    master.setBackground(changeBut.getBackground());
                    master.setLayout(new GridLayout(2, 1, 1, 1));
                    changeBut.add(master);
                } else if (notes.length() > 6) {
                    JLabel a = new JLabel(notes.substring(0, 3));
                    JLabel b = new JLabel(notes.substring(3, 6));
                    JLabel c = new JLabel(notes.substring(6));
                    a.setForeground(changeBut.getForeground());
                    b.setForeground(changeBut.getForeground());
                    c.setForeground(changeBut.getForeground());
                    changeBut.setForeground(changeBut.getBackground());
                    JPanel master = new JPanel();
                    a.setFont(changeBut.getFont());
                    b.setFont(changeBut.getFont());
                    c.setFont(changeBut.getFont());
                    master.add(a);
                    master.add(b);
                    master.add(c);
                    master.setBackground(changeBut.getBackground());
                    master.setLayout(new GridLayout(3, 1, 1, 1));

                    changeBut.add(master);

                }
                changeBut.setText(notes);
                System.out.println(notes);
            }
        }

        ActionListener act = new Act();
        JPanel numbers = new JPanel();
        for (int x = 1; x <= 9; x++) {
            JButton changed = new JButton(x + "");
            changed.addActionListener(act);
            numbers.add(changed);
        }

        JPanel everything = new JPanel();

        everything.add(query);

        everything.add(numbers);

        change.add(everything);

        change.setVisible(
                false);
        change.setResizable(
                false);
    }

    public void check(int x) {
        String p = x + "";
        if (notes.indexOf(p) == -1) {
            notes += p;
        } else {
            String a = notes.substring(0, notes.indexOf(p));
            String b = notes.substring(notes.indexOf(p) + 1);
            notes = a + b;
        }
    }
}
