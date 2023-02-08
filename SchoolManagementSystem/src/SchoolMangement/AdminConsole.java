package SchoolMangement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import static SchoolMangement.MainMenu.myColor;

public class AdminConsole implements MouseListener {
    JFrame frame3 = new JFrame();
    public static JPanel AdminMenuPanel = new JPanel();
    public  static JPanel AdminMenuPanel2 = new JPanel();

    Border border = (Border) new LineBorder(Color.white,1);

    ImageIcon staffIcon = new ImageIcon("StaffIcon.png");
    ImageIcon studentsIcon = new ImageIcon("StudentIcon.png");
    ImageIcon databaseIcon = new ImageIcon("DataBaseButton.png");
    ImageIcon profileIcon = new ImageIcon("ProfileIcon.png");
    ImageIcon homeIcon = new ImageIcon("HomeButton.png");

    HoverButton studentsButton = new HoverButton("");
    HoverButton studentDataButton = new HoverButton("");
    HoverButton staffbutton = new HoverButton("");
    HoverButton profileButton = new HoverButton("");
    HoverButton homeButton = new HoverButton("");

    public AdminConsole() {
        profileButton.setBounds(10,30,200,80);
        profileButton.setForeground(Color.white.brighter());
        profileButton.setIcon(profileIcon);
        profileButton.addMouseListener(this);

        studentDataButton.setBounds(10,150,200,80);
        studentDataButton.setForeground(Color.white.brighter());
        studentDataButton.setIcon(databaseIcon);
        studentDataButton.addMouseListener(this);

        staffbutton.setBounds(10,270,200,80);
        staffbutton.setForeground(Color.white.brighter());
        staffbutton.setIcon(staffIcon);
        staffbutton.addMouseListener(this);

        studentsButton.setBounds(10,390,200,80);
        studentsButton.setForeground(Color.white);
        studentsButton.setIcon(studentsIcon);
        studentsButton.addMouseListener(this);

        homeButton.setBounds(10,510,200,80);
        homeButton.setIcon(homeIcon);
        homeButton.addMouseListener(this);

        AdminMenuPanel.setBounds(-5,-5,230,700);
        AdminMenuPanel.setBackground(new Color(255, 255, 255, 23));
        AdminMenuPanel.setBorder(new LineBorder(new Color(12, 12, 12, 73),3));
        AdminMenuPanel.setFocusable(false);
        AdminMenuPanel.setRequestFocusEnabled(false);
        frame3.add(profileButton);
        frame3.add(studentsButton);
        frame3.add(studentDataButton);
        frame3.add(staffbutton);
        frame3.add(homeButton);



        AdminMenuPanel.setVisible(true);

        frame3.add(AdminMenuPanel);
        AdminMenuPanel2.setBounds(100,1000,0,600);
//        AdminMenuPanel2.setBackground(Color.white.darker());
        AdminMenuPanel2.setVisible(false);
        frame3.add(AdminMenuPanel2);


        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.getContentPane().setBackground(myColor);
        frame3.setVisible(true);
        frame3.setSize(800, 700);
        frame3.addMouseListener(this);
        frame3.setLayout(new BorderLayout());
        frame3.setResizable(true);
    }

    public static void main(String[] args) {
        new AdminConsole();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==homeButton){
            new MainMenu();
            frame3.dispose();
        }
        if (e.getSource()==profileButton){
            try {
                new AdminProfile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            frame3.dispose();
        }
        if (e.getSource()== studentDataButton){
            new StudentDataWindow();
            frame3.dispose();
        }
        if(e.getSource()==staffbutton){
            new StaffManagementWindow();
            frame3.dispose();
        }
        if (e.getSource()==studentsButton){
            new StudentAdditionWindow();
            frame3.dispose();
        }
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
