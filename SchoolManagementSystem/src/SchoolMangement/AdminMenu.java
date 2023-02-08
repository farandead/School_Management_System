package SchoolMangement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static SchoolMangement.AdminMenu.frame2;
import static SchoolMangement.AdminMenu.title2;
import static SchoolMangement.AdminProfile.*;
import static SchoolMangement.MainMenu.*;




    public  class AdminMenu  implements MouseListener {
        Thread thread = new Thread(new LoginConfirmationAdmin());
        Thread thread2 = new Thread(new loginFailureAdmin());
        public static JFrame frame2 = new JFrame();

        Color textColor = Color.white;

        RoundJTextField adminUsernamenull = new RoundJTextField(20);
        RoundJTextField adminPassword = new RoundJTextField(35);
        public static RoundJTextField adminUsername = new RoundJTextField(35);

        HoverButton loginButton = new HoverButton("Login");
        HoverButton homeButton = new HoverButton("Home");

        JLabel username = new JLabel("Admin ID/ Email :");
        JLabel password = new JLabel("Password :");


        public  static  HoverLabel title2 = new HoverLabel("ADMIN LOGIN");
        HoverLabel label1 = new HoverLabel("SCHOOL ");
        HoverLabel label2 = new HoverLabel("MANAGEMENT ");
        HoverLabel label3 = new HoverLabel("SYSTEM");

        ImageIcon icon = new ImageIcon("Button1.png");


        AdminMenu() {
            loginButton.setBounds(110, 430, 150, 40);
            loginButton.setIcon(icon);
            loginButton.setForeground(Color.white);
            loginButton.addMouseListener(this);
            frame2.add(loginButton);

            homeButton.setBounds(250, 430, 150, 40);
            homeButton.setIcon(icon);
            homeButton.setForeground(Color.white);
            homeButton.addMouseListener(this);
            frame2.add(homeButton);


            label1.setFont(new Font("Nirmala UI", Font.BOLD, 30));
            label1.setForeground(Color.white.brighter());
            label1.setBounds(185, 100, 300, 50);

            frame2.add(label1);
            label2.setFont(new Font("Nirmala UI", Font.BOLD, 30));
            label2.setForeground(Color.white);
            label2.setBounds(145, 130, 300, 50);

            frame2.add(label2);
            label3.setFont(new Font("Nirmala UI", Font.BOLD, 30));
            label3.setForeground(Color.white);
            label3.setBounds(180, 160, 300, 50);

            frame2.add(label3);


            title2.setBounds(170, 230, 170, 35);
            title2.setFont(new Font("Nirmala UI", Font.BOLD, 20));
            title2.setForeground(Color.white.darker());
            frame2.add(title2);


            username.setFont(myFont);
            username.setForeground(Color.white);
            username.setBounds(30, 295, 150, 35);
            frame2.add(username);

            password.setFont(myFont);
            password.setForeground(Color.white);
            password.setBounds(50, 345, 150, 35);
            frame2.add(password);


            adminUsernamenull.setBounds(180, 190, 150, 20);
            adminUsernamenull.setVisible(false);
            adminUsername.setBounds(160, 290, 170, 35);
            adminUsername.setFont(myFont);
            adminPassword.setBounds(160, 340, 170, 35);
            adminPassword.setOpaque(false);
            adminPassword.setFont(myFont);

            frame2.add(adminUsername);
            frame2.add(adminPassword);
            frame2.add(adminUsernamenull);


            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.getContentPane().setBackground(myColor);
            frame2.setVisible(true);
            frame2.setSize(500, 600);
            frame2.addMouseListener(this);
            frame2.setLayout(new BorderLayout());
            frame2.setResizable(true);
        }
        public static String [] loadAdminData(String username,String filename) throws IOException {
            Properties properties1 = new Properties();
            properties1.load(new FileInputStream(filename));

            for (String key : properties1.stringPropertyNames()) {
                loadCredentials.put(key, properties1.get(key).toString());
            }
            if (loadCredentials.containsKey(username)) {
                System.out.println(loadCredentials.values());
                String[] data = loadCredentials.values().toString().trim().replace("[", "").replace("]", "").split(",");
                System.out.println(data.length);
//                for (String element : data) {
//                    System.out.println(element);
//
//                }
                return data;
            } else {
                return null;
            }
        }

        public static void main(String[] args) {
            new AdminMenu();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == homeButton) {
                new MainMenu();
                frame2.dispose();
            }


            if (e.getSource() == loginButton) {
                try {
                    if (loadCredentialsCheck(adminUsername.getText(), adminPassword.getText(), "admin.properties")) {
                        thread.start();

//                        String [] adminData = loadAdminData(adminUsername.getText(),"adminData.properties");
                        System.out.println("Working");
                    } else {
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

class loginFailureAdmin implements Runnable {
    @Override
    public void run() {
        title2.setForeground(Color.white);
        try {
            for (int i = 0; i < 6; i++) {
                title2.setText("LOADING.");
                TimeUnit.MILLISECONDS.sleep(100);
                title2.setText("LOADING..");
                TimeUnit.MILLISECONDS.sleep(100);

                title2.setText("LOADING...");
                TimeUnit.MILLISECONDS.sleep(100);


            }
            title2.setForeground(Color.red);
            title2.setText("LOGIN FAILURE");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


class LoginConfirmationAdmin implements Runnable {


    @Override
    public void run() {
        title2.setForeground(Color.white);
        try {
            for (int i = 0; i < 6; i++) {
                title2.setText("LOADING.");
                TimeUnit.MILLISECONDS.sleep(100);
                title2.setText("LOADING..");
                TimeUnit.MILLISECONDS.sleep(100);

                title2.setText("LOADING...");
                TimeUnit.MILLISECONDS.sleep(100);


            }
            title2.setForeground(Color.green);
            title2.setText("LOGIN SUCCESS");
            new AdminConsole();
            frame2.dispose();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

