package SchoolMangement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static SchoolMangement.MainMenu.myColor;


public class StudentConsole extends JFrame implements MouseListener {
     StudentConsole(){
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         getContentPane().setBackground(myColor);
         setVisible(true);
         setSize(500,600);
         addMouseListener(this);
         setLayout(new BorderLayout());
         setResizable(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
