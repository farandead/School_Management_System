package SchoolMangement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static SchoolMangement.MainMenu.*;
import static SchoolMangement.StudentMenu.frame;
import static SchoolMangement.StudentMenu.title;



public class StudentMenu implements MouseListener {


            public  static JFrame frame = new JFrame();
            Thread thread = new Thread(new LoginConfirmationStudent());
            Thread thread2 = new Thread(new LoginFailureStudent());

            RoundJTextField studentUsernamenull = new RoundJTextField(20);
            RoundJTextField studentPassword = new RoundJTextField(35);
            RoundJTextField studentUsername = new RoundJTextField(35);

            HoverButton loginButton = new HoverButton("Login");
            HoverButton homeButton = new HoverButton("Home");

            JLabel username = new JLabel("Student ID/ Email :");
            JLabel password = new JLabel("Password :");


            static HoverLabel title = new HoverLabel("STUDENT LOGIN");
            HoverLabel label1 = new HoverLabel("SCHOOL ");
            HoverLabel label2 = new HoverLabel("MANAGEMENT ");
            HoverLabel label3 = new HoverLabel("SYSTEM");

            ImageIcon icon = new ImageIcon("Button1.png");


     public StudentMenu(){
         loginButton.setBounds(110,430,150,40);
         loginButton.setIcon(icon);
         loginButton.setForeground(Color.white);
         loginButton.addMouseListener(this);
         frame.add(loginButton);

         homeButton.setBounds(250,430,150,40);
         homeButton.setIcon(icon);
         homeButton.setForeground(Color.white);
         homeButton.addMouseListener(this);
         frame.add(homeButton);


         label1.setFont(new Font("Nirmala UI",Font.BOLD,30));
         label1.setForeground(Color.white.brighter());
         label1.setBounds(185,100,300,50);

         frame.add(label1);
         label2.setFont(new Font("Nirmala UI",Font.BOLD,30));
         label2.setForeground(Color.white);
         label2.setBounds(145,130,300,50);

         frame.add(label2);
         label3.setFont(new Font("Nirmala UI",Font.BOLD,30));
         label3.setForeground(Color.white);
         label3.setBounds(180,160,300,50);

         frame.add(label3);


            title.setBounds(165,230,170,35);
            title.setFont(new Font("Nirmala UI",Font.BOLD,20));
            title.setForeground(Color.white.darker());
            frame.add(title);



         username.setFont(myFont);
         username.setForeground(Color.white);
         username.setBounds(30,295,150,35);
         frame.add(username);

         password.setFont(myFont);
         password.setForeground(Color.white);
         password.setBounds(50,345 ,150,35);
         frame.add(password);


         studentUsernamenull.setBounds(180,190,150,20);
         studentUsernamenull.setVisible(false);
         studentUsername.setBounds(160,290,170,35);
         studentUsername.setFont(myFont);
         studentPassword.setBounds(160,340,170,35);
         studentPassword.setOpaque(false);
         studentPassword.setFont(myFont);

         frame.add(studentUsername);
         frame.add(studentPassword);
        frame.add(studentUsernamenull);



         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.getContentPane().setBackground(myColor);
         frame.setVisible(true);
         frame.setSize(500,600);
         frame.addMouseListener(this);
         frame.setLayout(new BorderLayout());
         frame.setResizable(true);
     }

    @Override
    public void mouseClicked(MouseEvent e) {

         if (e.getSource()==homeButton){
             new MainMenu();
             frame.dispose();
             frame.dispose();
         }
         if (e.getSource()==loginButton){
             try {
                 if(loadCredentialsCheck(studentUsername.getText(),studentPassword.getText(),"data.properties")){
                     thread.start();
                     System.out.println("Working");






                 }else{
                     thread2.start();
                     System.out.println("not working");
                 }
                     ;
             } catch (IOException ex) {
                 System.out.println("not working");
                 ex.printStackTrace();
             }


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




