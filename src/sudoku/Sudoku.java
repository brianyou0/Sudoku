package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sudoku {
    public static void main (String [] args) {
        JFrame board = new JFrame();
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setSize(800, 900);
                
        board.setVisible(true);
    }
}
