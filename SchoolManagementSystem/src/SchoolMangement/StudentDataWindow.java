package SchoolMangement;

import javax.mail.MessagingException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import static SchoolMangement.MainMenu.myColor;
import static SchoolMangement.MainMenu.myFont;
import static SchoolMangement.StudentAdditionWindow.PasswordGenerator;
import static SchoolMangement.StudentAdditionWindow.SendEmail;


class StudentTextField extends JTextField{
    private Shape shape;
    public StudentTextField(int size){
        setBorder(new EmptyBorder(1,1,1,1));
        setBackground(new Color(24, 35, 47, 199));
        setOpaque(true);
        setForeground(Color.white);
        setCaretColor(Color.white);

        setEditable(false);
    }
    
}
 class StudentDataLabel extends JLabel{
    
    public StudentDataLabel(String text){
        super(text);
        setForeground(Color.white);
        setFont(myFont);
    }
     
 }



public class StudentDataWindow implements MouseListener {
    public static JPanel AdminMenuPanel = new JPanel();
    public  static JPanel AdminMenuPanel2 = new JPanel();

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
        RoundJTextField studentUsername;
        StudentTextField username,title,forname,surname,prefferedname,dateOB,personalEmail,mobileNumber,emegergencyContact,emergContactNo,campusEmail2,campusEmail;
        JFrame frame = new JFrame();

        StudentDataLabel usernamelabel,titlelabel,fornamelabel,surnamelabel,prefferednamelabel,dateOBlabel,personalEmaillabel,mobileNumberlabel,emegergencyContactlabel,emergContactNolabel,campusEmail2label,campusEmaillabel,studentUsernameLabel;
        HoverButton SearchButton = new HoverButton("");
        HoverButton SendEmail = new HoverButton("");
        HoverLabel heading = new HoverLabel("Student Database");




    public  StudentDataWindow(){
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
        frame.add(profileButton);
        frame.add(studentsButton);
        frame.add(studentDataButton);
        frame.add(staffbutton);
        frame.add(homeButton);



        AdminMenuPanel.setVisible(true);

        frame.add(AdminMenuPanel);
        AdminMenuPanel2.setBounds(100,1000,0,600);
//        AdminMenuPanel2.setBackground(Color.white.darker());
        AdminMenuPanel2.setVisible(false);
        frame.add(AdminMenuPanel2);
        
        
        
        
//        -----------------------------------------------------
        heading.setBounds(370,10,250,40);
        heading.setFont(new Font("Nirmala UI",Font.BOLD,20));
        heading.setForeground(Color.white);

        SearchButton.setBounds(560,555,100,90);
        SearchButton.setIcon(new ImageIcon("SearchButton.png"));
        SearchButton.addMouseListener(this);

        SendEmail.setBounds(650,555,100,90);
        SendEmail.setIcon(new ImageIcon("SendMailButton.png"));
        SendEmail.addMouseListener(this);



        studentUsernameLabel = new StudentDataLabel("Enter Username:");
        studentUsernameLabel.setBounds(380,550,250,40);

        studentUsername = new RoundJTextField(50);
        studentUsername.setBounds(310,580,250,40);
        studentUsername.setBackground(Color.white);
        studentUsername.setForeground(Color.black);
        studentUsername.setCaretColor(Color.black);
        studentUsername.setFont(myFont);

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

        username = new StudentTextField(10);
        title = new StudentTextField(10);
        forname = new StudentTextField(10);
        surname = new StudentTextField(10);
        prefferedname = new StudentTextField(10);
        dateOB = new StudentTextField(10);
        personalEmail = new StudentTextField(10);
        mobileNumber = new StudentTextField(10);
        emegergencyContact = new StudentTextField(10);
        emergContactNo = new StudentTextField(10);
        campusEmail2 = new StudentTextField(10);
        campusEmail = new StudentTextField(10);


        usernamelabel.setBounds(240,70,200,30);
        titlelabel.setBounds(480,70,200,30);
        fornamelabel.setBounds(240,150,200,30);
        surnamelabel.setBounds(480,150,200,30);
        prefferednamelabel.setBounds(240,230,200,30);
        dateOBlabel.setBounds(480,230,200,30);
        personalEmaillabel.setBounds(240,310,200,30);
        mobileNumberlabel.setBounds(480,310,200,30);
        emegergencyContactlabel.setBounds(240,390,200,30);
        emergContactNolabel.setBounds(480,390,200,30);
        campusEmail2label.setBounds(360,470,200,30);
//        campusEmaillabel.setBounds(330,480,200,30);


        
        username.setBounds(240,100,200,30);
        title.setBounds(480,100,200,30);
        forname.setBounds(240,180,200,30);
        surname.setBounds(480,180,200,30);
        prefferedname.setBounds(240,260,200,30);
        dateOB.setBounds(480,260,200,30);
        personalEmail.setBounds(240,340,200,30);
        mobileNumber.setBounds(480,340,200,30);
        emegergencyContact.setBounds(240,420,200,30);
        emergContactNo.setBounds(480,420,200,30);
        campusEmail2.setBounds(360,500,200,30);
        campusEmail.setBounds(330,500,200,30);

        frame.add(SendEmail);
        frame.add(heading);
        frame.add(SearchButton);
        frame.add(studentUsernameLabel);
        frame.add(studentUsername);
        frame.add(usernamelabel);
        frame.add(titlelabel);
        frame.add(fornamelabel);
        frame.add(surnamelabel);
        frame.add(prefferednamelabel);
        frame.add(dateOBlabel);
        frame.add(personalEmaillabel);
        frame.add(mobileNumberlabel);
        frame.add(emegergencyContactlabel);
        frame.add(emergContactNolabel);
        frame.add(campusEmail2label);
        frame.add(campusEmaillabel);

        frame.add(username);
        frame.add(title);
        frame.add(forname);
        frame.add(surname);
        frame.add(prefferedname);
        frame.add(dateOB);
        frame.add(personalEmail);
        frame.add(mobileNumber);
        frame.add(emegergencyContact);
        frame.add(emergContactNo);
        frame.add(campusEmail2);
        frame.add(campusEmail);

        
        


        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(myColor);
        frame.setVisible(true);
        frame.setSize(800, 700);
        frame.addMouseListener(this);
        frame.setLayout(null);
        frame.setResizable(true);
    }

    public static String [] loadStudentData(String username,String filename) throws IOException {
        Map<String,String> loadCredentials = new HashMap<String,String>();
        Properties properties1 = new Properties();
        properties1.load(new FileInputStream(filename));

        for (String key : properties1.stringPropertyNames()) {
            loadCredentials.put(key, properties1.get(key).toString());
        }
        if (loadCredentials.containsKey(username)) {
            System.out.println(loadCredentials);
            String [] data = loadCredentials.get(username).toString().trim().replace("[","").replace("]","").split(",");
            System.out.println(data.length);
            for (String element  : data){
                System.out.println(element);

            }
            return data;
        } else {
            return null;
        }

    }

    public static void main(String[] args) {
        new StudentDataWindow();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource()==homeButton){
            new MainMenu();
            frame.dispose();
        }
        if (e.getSource()== studentDataButton){
            new StudentDataWindow();
            frame.dispose();
        }
        if(e.getSource()==staffbutton){
            new StaffManagementWindow();
            frame.dispose();
        }
        if (e.getSource()==studentsButton){
            new StudentAdditionWindow();
            frame.dispose();
        }
        if (e.getSource()==SendEmail){
            try {
                SendEmail(personalEmail.getText(),campusEmail2.getText(),String.valueOf(PasswordGenerator()),username.getText());
                System.out.println("Success");
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource()==SearchButton){
            try {
                String [] Studentdata = loadStudentData(studentUsername.getText(),"Student.properties");
                        System.out.println(Studentdata.length);
                username.setText(String.valueOf(studentUsername.getText()));
                title.setText(String.valueOf(Studentdata[0]));
                forname.setText(String.valueOf(Studentdata[1]));
                surname.setText(String.valueOf(Studentdata[2]));
                prefferedname.setText(String.valueOf(Studentdata[3]));
                dateOB.setText(String.valueOf(Studentdata[4]));
                personalEmail.setText(String.valueOf(Studentdata[5]));
                mobileNumber.setText(String.valueOf(Studentdata[6]));
                emegergencyContact.setText(String.valueOf(Studentdata[7]));
                emergContactNo.setText(String.valueOf(Studentdata[8]));
                campusEmail2.setText(String.valueOf(Studentdata[9]));
//                campusEmail.setText(String.valueOf());

                System.out.println("This is the Title of the student: "+Studentdata[0]);
                System.out.println("This is the Forename of the student: "+Studentdata[1]);
                System.out.println("This is the Surname of the  student: "+Studentdata[2]);
                System.out.println("This is the Preferred Name of the  student: "+Studentdata[3]);
                System.out.println("This is the Date of birth of the  student: "+Studentdata[4]);
                System.out.println("This is the Personal Email of the  student: "+Studentdata[5]);
                System.out.println("This is the Mobile Number of the  studentL: "+Studentdata[6]);
                System.out.println("This is the Emergency Contact of the  student: "+Studentdata[7]);
                System.out.println("This is the Emergency Contact Number of the  student: "+Studentdata[8]);
                System.out.println("This is  the Email/Id of the  student: "+Studentdata[9]);


            } catch (IOException ex) {
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
