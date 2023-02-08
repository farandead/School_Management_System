package SchoolMangement;



import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import static SchoolMangement.AdminMenu.adminUsername;
import static SchoolMangement.AdminMenu.loadAdminData;
import static SchoolMangement.MainMenu.myColor;
import static SchoolMangement.MainMenu.myFont;


public class AdminProfile implements MouseListener {
    static String [] adminData;

    static {
        try {
            adminData = loadAdminData(adminUsername.getText(),"adminData.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    JFrame frame = new JFrame();
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

    HoverLabel picture = new HoverLabel("");



//    AdminDataLabel Name,picture,course,course,yearOfRecruitment,yearlyPay,personalEmail,personalNumber,emergencyContact,emergencyContactNo,campusEmail,password;
//    AdminTextField   NameField,pictureField,courseField,courseField,yearOfRecruitmentField,yearlyPayField,personalEmailField,personalNumberField,emergencyContactField,emergencyContactNoField,campusEmailField,passwordField;

    AdminDataLabel titlelabel, courseLabel, fornamelabel, surnamelabel, prefferednamelabel, dateOBlabel, personalEmaillabel, mobileNumberlabel, emegergencyContactlabel, emergContactNolabel, campusEmail2label, campusEmaillabel,yearofRecruitmmentlabel,yearlypaylabel,passwordlabel;

    AdminTextField title = new AdminTextField(String.valueOf(adminData[1]));
     AdminTextField course = new AdminTextField(String.valueOf(adminData[2]));
     AdminTextField forname = new AdminTextField(String.valueOf(adminData[3]));
    AdminTextField surname = new AdminTextField(adminData[4]);
     AdminTextField prefferedname = new AdminTextField(adminData[5]);
     AdminTextField dateOB = new AdminTextField(adminData[6]);
     AdminTextField personalEmail = new AdminTextField(adminData[7]);
     AdminTextField mobileNumber = new AdminTextField(adminData[8]);
     AdminTextField emegergencyContact = new AdminTextField(adminData[9]);
    AdminTextField  emergContactNo = new AdminTextField(adminData[10]);
    AdminTextField campusEmail2 = new AdminTextField(adminData[3]);
    AdminTextField campusEmail = new AdminTextField(adminData[11]);
    AdminTextField yearofRecruitmment = new AdminTextField(adminData[12]);
    AdminTextField yearofRecruitmment1 = new AdminTextField(adminData[3]);
    AdminTextField yearlyPay = new AdminTextField(adminData[13]);
     AdminTextField password = new AdminTextField(adminData[14]);
    JCheckBox passwordCheckbox = new JCheckBox();
    

    public AdminProfile() throws IOException {
        System.out.println(adminUsername.getText());
        title.setText(adminData[1]);
        course.setText((adminData[2]));
        forname.setText(adminData[3]);
        surname.setText(adminData[4]);
        prefferedname.setText((adminData[5]));
        dateOB.setText(adminData[6]);
        personalEmail.setText(adminData[7]);
        mobileNumber.setText((adminData[8]));
        emegergencyContact.setText(adminData[9]);
        emergContactNo.setText(adminData[10]);
        campusEmail2.setText(adminData[11]);
        yearofRecruitmment.setText((adminData[12]));
        yearlyPay.setText(adminData[13]+" £");
        password.setText(adminData[14]);
        StringBuilder hiddenPass = new StringBuilder();
        for (int i=0;i<adminData[14].strip().length();i++){
            hiddenPass.append("●");
        }
        password.setText(String.valueOf(hiddenPass));

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
//        -----------------------------------------------------------------------------------

        picture.setBorder(new LineBorder(Color.white));
        picture.setBounds(600,60,150,150);
        picture.setIcon(new ImageIcon("faran.png"));

        titlelabel = new AdminDataLabel("Title");
        courseLabel = new AdminDataLabel("Course");
        fornamelabel = new AdminDataLabel("Forename");
        surnamelabel = new AdminDataLabel("Surname");
        prefferednamelabel = new AdminDataLabel("Preferred Name");
        dateOBlabel = new AdminDataLabel("Date of Birth");
        personalEmaillabel = new AdminDataLabel("Personal Email");
        mobileNumberlabel = new AdminDataLabel("Mobile Number");
        emegergencyContactlabel = new AdminDataLabel("Emergency Contact");
        emergContactNolabel = new AdminDataLabel("Emergency Contact No");
        campusEmail2label = new AdminDataLabel("Campus Email");
        campusEmaillabel = new AdminDataLabel("Campus Email");
        yearofRecruitmmentlabel = new AdminDataLabel("Year of Recruitment");
        yearlypaylabel = new AdminDataLabel("Yearly Pay");
        passwordlabel = new AdminDataLabel("Password");




        titlelabel.setBounds(260, 70, 150, 30);
        courseLabel.setBounds(430, 70, 150, 30);
        fornamelabel.setBounds(260, 150, 150, 30);
        surnamelabel.setBounds(430, 150, 150, 30);
        prefferednamelabel.setBounds(260, 230, 150, 30);
        dateOBlabel.setBounds(430, 230, 150, 30);
        personalEmaillabel.setBounds(260, 310, 150, 30);
        mobileNumberlabel.setBounds(430, 310, 150, 30);
        emegergencyContactlabel.setBounds(260, 390, 150, 30);
        emergContactNolabel.setBounds(430, 390, 150, 30);
        campusEmail2label.setBounds(260, 470, 150, 30);
        yearofRecruitmmentlabel.setBounds(430, 470, 150, 30);
        yearlypaylabel.setBounds(260, 550, 150, 30);
        passwordlabel.setBounds(430, 550, 150, 30);
        passwordCheckbox.setBounds(550,580,130,30);
        passwordCheckbox.setBackground(myColor);
        passwordCheckbox.setForeground(Color.white);
        passwordCheckbox.setFocusPainted(false);
        passwordCheckbox.setText("Reveal Password");
        passwordCheckbox.setFont(new Font("Calibri light",Font.ITALIC,12));
        passwordCheckbox.addMouseListener(this);
        passwordCheckbox.setVerticalTextPosition(JCheckBox.CENTER);

//        campusEmaillabel.setBounds(330,430,150,30);


        title.setBounds(260, 100, 150, 30);
        course.setBounds(430, 100, 150, 30);
        forname.setBounds(260, 180, 150, 30);
        surname.setBounds(430, 180, 150, 30);
        prefferedname.setBounds(260, 260, 150, 30);
        dateOB.setBounds(430, 260, 150, 30);
        personalEmail.setBounds(260, 340, 150, 30);
        mobileNumber.setBounds(430, 340, 150, 30);
        emegergencyContact.setBounds(260, 420, 150, 30);
        emergContactNo.setBounds(430, 420, 150, 30);
        campusEmail2.setBounds(260, 500, 150, 30);
        yearofRecruitmment.setBounds(430, 499, 150, 30);
        yearofRecruitmment1.setBounds(430, 499, 150, 30);
        yearlyPay.setBounds(260, 580, 150, 30);
        password.setBounds(430, 580, 150, 30);
//        campusEmail.setBounds(330, 430, 150, 30);

        frame.add(titlelabel);
        frame.add(courseLabel);
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
        frame.add(yearofRecruitmmentlabel);
        frame.add(yearlypaylabel);
        frame.add(passwordlabel);

        frame.add(passwordCheckbox);
        frame.add(picture);
        frame.add(password);
        frame.add(yearofRecruitmment);
        frame.add(yearlyPay);
        frame.add(title);
        frame.add(course);
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
        frame.add(yearofRecruitmment);
        frame.add(yearofRecruitmment1);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(myColor);
        frame.setVisible(true);
        frame.setSize(800, 700);
        frame.addMouseListener(this);
        frame.setLayout(new BorderLayout());
        frame.setResizable(true);
    }

    public static void main(String[] args) throws IOException {
        new AdminProfile();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (passwordCheckbox.isSelected()){
            password.setText(String.valueOf(adminData[14]));
        }
        else{
            StringBuilder hiddenPass = new StringBuilder();
            for (int i=0;i<adminData[14].strip().length();i++){
                hiddenPass.append("●");
            }
            password.setText(String.valueOf(hiddenPass));
        }
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
class AdminDataLabel extends JLabel{

    public AdminDataLabel(String text){
        super(text);
        setForeground(Color.white);
        setFont(myFont);

    }

}

class AdminTextField extends JTextField{
    private Shape shape;
    public AdminTextField(String adminDatum){
        setBorder(new EmptyBorder(1,1,1,1));
        setBackground(new Color(24, 35, 47, 98));
        setOpaque(false);
        setForeground(Color.white);
        setCaretColor(Color.white);

        setEditable(true);
    }

}