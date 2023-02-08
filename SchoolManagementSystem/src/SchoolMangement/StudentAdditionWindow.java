package SchoolMangement;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import static SchoolMangement.LoginSystem.patternMatches;
import static SchoolMangement.MainMenu.*;


public class StudentAdditionWindow implements MouseListener {
        JPanel AdminMenuPanel = new JPanel();
        JPanel AdminMenuPanel2 = new JPanel();

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


//    -----------------------------------------------------------

        StudentAddTextField username, title, forname, surname, prefferedname, dateOB, personalEmail, mobileNumber, emegergencyContact, emergContactNo, campusEmail2, campusEmail;
        JFrame frame4 = new JFrame();

        StudentDataLabel usernamelabel, titlelabel, fornamelabel, surnamelabel, prefferednamelabel, dateOBlabel, personalEmaillabel, mobileNumberlabel, emegergencyContactlabel, emergContactNolabel, campusEmail2label, campusEmaillabel;
        HoverButton addButton = new HoverButton("Add");
        HoverButton SendButton = new HoverButton("Send Button");
        HoverLabel heading = new HoverLabel("Student Recruitment");


        public StudentAdditionWindow() {
            profileButton.setBounds(10, 30, 200, 80);
            profileButton.setForeground(Color.white.brighter());
            profileButton.setIcon(profileIcon);
            profileButton.addMouseListener(this);


            studentDataButton.setBounds(10, 150, 200, 80);
            studentDataButton.setForeground(Color.white.brighter());
            studentDataButton.setIcon(databaseIcon);
            studentDataButton.addMouseListener(this);

            staffbutton.setBounds(10, 270, 200, 80);
            staffbutton.setForeground(Color.white.brighter());
            staffbutton.setIcon(staffIcon);
            staffbutton.addMouseListener(this);

            studentsButton.setBounds(10, 390, 200, 80);
            studentsButton.setForeground(Color.white);
            studentsButton.setIcon(studentsIcon);
            studentsButton.addMouseListener(this);

            homeButton.setBounds(10, 510, 200, 80);
            homeButton.setIcon(homeIcon);
            homeButton.addMouseListener(this);

            AdminMenuPanel.setBounds(-5, -5, 230, 700);
            AdminMenuPanel.setBackground(new Color(255, 255, 255, 23));
            AdminMenuPanel.setBorder(new LineBorder(new Color(12, 12, 12, 73), 3));
            AdminMenuPanel.setFocusable(false);
            AdminMenuPanel.setRequestFocusEnabled(false);
            frame4.add(profileButton);
            frame4.add(studentsButton);
            frame4.add(studentDataButton);
            frame4.add(staffbutton);
            frame4.add(homeButton);


            AdminMenuPanel.setVisible(true);

            frame4.add(AdminMenuPanel);
            AdminMenuPanel2.setBounds(100, 1000, 0, 600);
//        AdminMenuPanel2.setBackground(Color.white.darker());
            AdminMenuPanel2.setVisible(false);
            frame4.add(AdminMenuPanel2);


//        -----------------------------------------------------
            heading.setBounds(370, 10, 250, 40);
            heading.setFont(new Font("Nirmala UI", Font.BOLD, 20));
            heading.setForeground(Color.white);


            SendButton.setBounds(340, 580, 250, 90);
            SendButton.addMouseListener(this);
            addButton.setBounds(340, 525, 250, 90);
            addButton.addMouseListener(this);


            usernamelabel = new StudentDataLabel("Username");
            titlelabel = new StudentDataLabel("Title");
            fornamelabel = new StudentDataLabel("Forename");
            surnamelabel = new StudentDataLabel("Surname");
            prefferednamelabel = new StudentDataLabel("Preferred Name");
            dateOBlabel = new StudentDataLabel("Date of Birth");
            personalEmaillabel = new StudentDataLabel("Personal Email");
            mobileNumberlabel = new StudentDataLabel("Mobile Number");
            emegergencyContactlabel = new StudentDataLabel("Emergency Contact");
            emergContactNolabel = new StudentDataLabel("Emergency Contact No");
            campusEmail2label = new StudentDataLabel("Campus Email");
            campusEmaillabel = new StudentDataLabel("Campus Email");

            username = new StudentAddTextField(10);
            title = new StudentAddTextField(10);
            forname = new StudentAddTextField(10);
            surname = new StudentAddTextField(10);
            prefferedname = new StudentAddTextField(10);
            dateOB = new StudentAddTextField(10);
            personalEmail = new StudentAddTextField(10);
            mobileNumber = new StudentAddTextField(10);
            emegergencyContact = new StudentAddTextField(10);
            emergContactNo = new StudentAddTextField(10);
            campusEmail2 = new StudentAddTextField(10);
            campusEmail = new StudentAddTextField(10);


            usernamelabel.setBounds(240, 70, 200, 30);
            titlelabel.setBounds(480, 70, 200, 30);
            fornamelabel.setBounds(240, 150, 200, 30);
            surnamelabel.setBounds(480, 150, 200, 30);
            prefferednamelabel.setBounds(240, 230, 200, 30);
            dateOBlabel.setBounds(480, 230, 200, 30);
            personalEmaillabel.setBounds(240, 310, 200, 30);
            mobileNumberlabel.setBounds(480, 310, 200, 30);
            emegergencyContactlabel.setBounds(240, 390, 200, 30);
            emergContactNolabel.setBounds(480, 390, 200, 30);
            campusEmail2label.setBounds(360, 470, 200, 30);
//        campusEmaillabel.setBounds(330,480,200,30);


            username.setBounds(240, 100, 200, 30);
            title.setBounds(480, 100, 200, 30);
            forname.setBounds(240, 180, 200, 30);
            surname.setBounds(480, 180, 200, 30);
            prefferedname.setBounds(240, 260, 200, 30);
            dateOB.setBounds(480, 260, 200, 30);
            personalEmail.setBounds(240, 340, 200, 30);
            mobileNumber.setBounds(480, 340, 200, 30);
            emegergencyContact.setBounds(240, 420, 200, 30);
            emergContactNo.setBounds(480, 420, 200, 30);
            campusEmail2.setBounds(360, 500, 200, 30);
            campusEmail.setBounds(330, 500, 200, 30);

            frame4.add(SendButton);
            frame4.add(heading);
            frame4.add(addButton);


            frame4.add(usernamelabel);
            frame4.add(titlelabel);
            frame4.add(fornamelabel);
            frame4.add(surnamelabel);
            frame4.add(prefferednamelabel);
            frame4.add(dateOBlabel);
            frame4.add(personalEmaillabel);
            frame4.add(mobileNumberlabel);
            frame4.add(emegergencyContactlabel);
            frame4.add(emergContactNolabel);
            frame4.add(campusEmail2label);
            frame4.add(campusEmaillabel);

            frame4.add(username);
            frame4.add(title);
            frame4.add(forname);
            frame4.add(surname);
            frame4.add(prefferedname);
            frame4.add(dateOB);
            frame4.add(personalEmail);
            frame4.add(mobileNumber);
            frame4.add(emegergencyContact);
            frame4.add(emergContactNo);
            frame4.add(campusEmail2);
            frame4.add(campusEmail);

            frame4.setIconImage(new ImageIcon("CMS_Icon.png").getImage());
            frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame4.getContentPane().setBackground(myColor);
            frame4.setTitle("CMS - Campus Management System");
            frame4.setVisible(true);
            frame4.setSize(800, 700);
            frame4.addMouseListener(this);
            frame4.setLayout(null);
            frame4.setResizable(true);
        }


        public static void main(String[] args) {
            new StudentAdditionWindow();
        }
        public static char[] PasswordGenerator() {
            {
                int length = 5;
                String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String small_letter = "abcdefghijklmnopqrstuvwxyz";
                String numbers = "0123456789";
                String finalString = cap_letter + small_letter +
                        numbers ;
                Random random = new Random();
                char[] password = new char[length];
                for (int i = 0; i < length; i++) {
                    password[i] = finalString.charAt(random.nextInt(finalString.length()));
                }
                return password;
            }
        }
        public static boolean SendEmail(String recepient, String email, String Password, String username) throws MessagingException {
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
            String myAccountEmail = "mycampus.uk@gmail.com";
            String myAccountPassword = "Zafar@2020";

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myAccountEmail, myAccountPassword);
                }
            });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Login Details - EMS");
            message.setText("Hi there "+username+" !"+"\n"+"Here are your Login Details for Accessing the University CMS:\nEmail: "+email+"\nPassword: "+Password+"\n\nDon't Share Your Login Details with ANYONE !\n\n\n\n\n ®All Rights Reserved | MyCampus.co.uk |  Faran Zafar |CMS Version 1.1.1.0");
            Transport.send(message);
            return true;
        }
    public static boolean storingCredentials(String username,String password,String filename) throws IOException {

        Map<String,String> loadCredentials = new HashMap<String,String>();
        String URegexPattern = "[a-zA-Z1-9]*";

        if (patternMatches(username,URegexPattern)){
            Properties properties1 = new Properties();
            System.out.println("Working 1");

            properties1.load(new FileInputStream(filename));
            for (String key : properties1.stringPropertyNames()) {
                loadCredentials.put(key, properties1.get(key).toString());
            }
            loadCredentials.put(username,password);
            properties1.putAll(loadCredentials);
            properties1.store(new FileOutputStream(filename), null);
            System.out.println(loadCredentials);
        }
        else {
            System.out.println("Not Working");
        }

        return false;
    }

        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource() == homeButton) {
                new MainMenu();
                frame4.dispose();
            }
            if (e.getSource() == studentDataButton) {
                new StudentDataWindow();
                frame4.dispose();
            }
            if (e.getSource() == staffbutton) {
                new StaffManagementWindow();
                frame4.dispose();
            }
            if (e.getSource() == studentsButton) {
                new StudentAdditionWindow();
                frame4.dispose();
            }
            if (e.getSource() == addButton) {
                try {
                    StudentDataStorage studentDataStorage = new StudentDataStorage(
                            username.getText(),
                            title.getText(),
                            forname.getText(),
                            surname.getText(),
                            prefferedname.getText(),
                            dateOB.getText(),
                            personalEmail.getText(),
                            mobileNumber.getText(),
                            emegergencyContact.getText(),
                            emergContactNo.getText(),
                            campusEmail2.getText());

                    storingCredentials(username.getText(),String.valueOf(PasswordGenerator()),"data.properties");


                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
            if (e.getSource()==SendButton){
                try {
                    SendEmail(personalEmail.getText(),campusEmail2.getText(),String.valueOf(PasswordGenerator()),username.getText());
                } catch (MessagingException ex) {
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

class StudentAddTextField extends JTextField {
    private Shape shape;

    public StudentAddTextField(int size) {
        setBorder(new EmptyBorder(1, 1, 1, 1));
        setBackground(new Color(24, 35, 47, 199));
        setOpaque(true);
        setForeground(Color.white);
        setCaretColor(Color.white);

//        setEditable(false);
    }
}
class StudentDataStorage {
    public static boolean storingStudentData(String username, String studentData, String filename) throws IOException {
        Map<String, String> studentdata = new HashMap<String, String>();
        Properties properties1 = new Properties();
        System.out.println("Working 1");
        properties1.load(new FileInputStream(filename));
        for (String key : properties1.stringPropertyNames()) {
            studentdata.put(key, properties1.get(key).toString());
        }
        studentdata.put(username, studentData);
        properties1.putAll(studentdata);
        properties1.store(new FileOutputStream(filename), null);
        System.out.println(studentData);

        return true;
    }

    StudentDataStorage(String username, String title, String forname, String surname, String preferredName, String dateOB, String personalEmail, String mobileNumber, String emergencyContact, String emergencycontactNo, String campusEmail) throws IOException {
        this.username = username;
        this.title = title;
        this.forname = forname;
        this.surname = surname;
        this.preferredName = preferredName;
        this.dateOB = dateOB;
        this.personalEmail = personalEmail;
        this.mobileNumber = mobileNumber;
        this.emergencyContact = emergencyContact;
        this.emergencycontactNo = emergencycontactNo;
        this.campusEmail = campusEmail;
        String studentdata = title + "," + forname + "," + surname + "," + preferredName + "," + dateOB + "," + personalEmail + "," + mobileNumber + "," + emergencyContact + "," + emergencycontactNo + "," + campusEmail;
        storingStudentData(username, studentdata, "Student.properties");


    }

    String title;
    String forname;
    String surname;
    String preferredName;
    String dateOB;
    String personalEmail;
    String mobileNumber;
    String emergencyContact;
    String emergencycontactNo;
    String campusEmail;
    String username;

}
