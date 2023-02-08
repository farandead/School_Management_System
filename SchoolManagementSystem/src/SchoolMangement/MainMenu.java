package SchoolMangement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

public class MainMenu extends JFrame implements MouseListener {
    public static Map<String,String> loadCredentials = new HashMap<String,String>();

    public  static  Color myColor = new Color(	54, 69, 79);
    public static  Font myFont = new Font("Calibri",Font.BOLD,14);

    HoverButton adminButton = new HoverButton("Admin/Staff Login");
    HoverButton studentButton = new HoverButton("Guest/Student Login");
    HoverButton studentButton2 = new HoverButton("Guest/Student Login");
    HoverButton stButton = new HoverButton("Guest/Student Login");
    JPanel panel = new JPanel();
    HoverLabel label1 = new HoverLabel("SCHOOL ");
    HoverLabel label2 = new HoverLabel("MANAGEMENT ");
    HoverLabel label3 = new HoverLabel("SYSTEM");

    public MainMenu(){

        label1.setFont(new Font("Nirmala UI",Font.BOLD,30));
        label1.setForeground(Color.white);
        label1.setBounds(185,100,300,50);

        add(label1);
        label2.setFont(new Font("Nirmala UI",Font.BOLD,30));
        label2.setForeground(Color.white);
        label2.setBounds(145,130,300,50);

        add(label2);
        label3.setFont(new Font("Nirmala UI",Font.BOLD,30));
        label3.setForeground(Color.white);
        label3.setBounds(180,160,300,50);

        add(label3);
        adminButton.setBounds(140,300,200,52);
        adminButton.setForeground(Color.white);
        adminButton.setFont(myFont);
        adminButton.setLayout(null);
        adminButton.addMouseListener(this);

        studentButton2.setBounds(140,350,200,52);
        studentButton2.setLayout(null);
        studentButton2.addMouseListener(this);

        stButton.setBounds(140,360,200,52);
        stButton.setFont(myFont);
        stButton.setForeground(Color.white);
        stButton.addMouseListener(this);
        add(stButton);
        add(adminButton);
        add(studentButton2);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(myColor);
        setVisible(true);
        setSize(500,600);
        addMouseListener(this);
        setLayout(new BorderLayout());
        setResizable(true);
    }

    public static boolean loadCredentialsCheck(String username, String password,String filename) throws IOException {
        Properties properties1 = new Properties();
        properties1.load(new FileInputStream(filename));

        for (String key : properties1.stringPropertyNames()) {
            loadCredentials.put(key, properties1.get(key).toString());
        }
        if (loadCredentials.containsKey(username)) {
            if (loadCredentials.get(username).equals(password)) {
                return true;
            }
        } else {
            return false;
        }

        return false;
    }

    public static boolean patternMatches(String input,String regexPattern) {


        return Pattern.compile(regexPattern)
                .matcher(input)
                .matches();
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

    public static void loadingScreen(){

    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()== adminButton){
            new AdminMenu();
            dispose();
        }
        if (e.getSource()== stButton){
            new StudentMenu();
            dispose();
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
