package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChangeNumber {
    public static void main (String [] args) {
        final JFrame change = new JFrame();
        change.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        change.setSize(450, 130);

        JPanel query = new JPanel();       
        JLabel ask = new JLabel("Which number?");
        query.add(ask);
        

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
                        System.out.print(x);
                        break;
                    case 8:
                        
                        break;
                    case 9:
                        
                        break;
                }
                change.dispose();
            }
        }
        
        ActionListener act = new Act();
        JPanel numbers = new JPanel();
        for (int x = 1; x <= 9; x++) {
            JButton button = new JButton(x + "");
            button.addActionListener(act);
            numbers.add(button);
           
        }
               
        
        JPanel everything = new JPanel();        
        everything.add(query);
        everything.add(numbers);
        
        change.add(everything);
        change.setVisible(true);
        change.setResizable(false);
    }
}
