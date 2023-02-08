package SchoolMangement;

import java.awt.image.ImageProducer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DatabaseManagement {

    public static Map<String,String> loadCredentials = new HashMap<String,String>();

    public static String [] loadStudentData(String username,String filename) throws IOException {
        Properties properties1 = new Properties();
        properties1.load(new FileInputStream(filename));

        for (String key : properties1.stringPropertyNames()) {
            loadCredentials.put(key, properties1.get(key).toString());
        }
        if (loadCredentials.containsKey(username)) {
            System.out.println(loadCredentials.values());
            String [] data = loadCredentials.values().toString().trim().replace("[","").replace("]","").split(",");
            System.out.println(data.length);
            for (String element  : data){
                System.out.println(element);

            }
            return data;
        } else {
            return null;
        }

    }

    public static void main(String[] args) throws IOException {
//        String [] Studentdata = loadStudentData("Faran","Student.properties");
//        System.out.println(Studentdata.length);
//        System.out.println("This is the Title of the student: "+Studentdata[0]);
//        System.out.println("This is the Forename of the student: "+Studentdata[1]);
//        System.out.println("This is the Surname of the  student: "+Studentdata[2]);
//        System.out.println("This is the Preferred Name of the  student: "+Studentdata[3]);
//        System.out.println("This is the Date of birth of the  student: "+Studentdata[4]);
//        System.out.println("This is the Personal Email of the  student: "+Studentdata[5]);
//        System.out.println("This is the Mobile Number of the  studentL: "+Studentdata[6]);
//        System.out.println("This is the Emergency Contact of the  student: "+Studentdata[7]);
//        System.out.println("This is the Emergency Contact Number of the  student: "+Studentdata[8]);
//        System.out.println("This is  the Email/Id of the  student: "+Studentdata[9]);
//        StudentDataStorage studentDataStorage = new StudentDataStorage("Test","1","2","3","4","5","6","7","8","9","10");

    }
}


