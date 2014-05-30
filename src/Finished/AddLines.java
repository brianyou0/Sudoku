
package sudoku;

import java.awt.*;
import javax.swing.*;
import java.awt.GridLayout; 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
public class AddLines extends JComponent{
    public void paintComponent(Graphics arunSux){
        Graphics2D g2 = (Graphics2D) arunSux;
        Line2D.Double line1 = new Line2D.Double(5, 170, 105, 170);
        g2.draw(line1);
        g2.setColor(Color.ORANGE);
        Line2D.Double line2 = new Line2D.Double(205, 170, 305, 170);
        g2.draw(line2);
    }
}