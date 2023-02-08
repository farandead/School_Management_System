package SchoolMangement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

public class LoginSystem {
//
    public static Map<String,String> loadCredentials = new HashMap<String,String>();

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

    public static void loadingScreen(){

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






    public static void main(String[] args) throws IOException {

        storingCredentials("Zafar","Faizan@2020","admin.properties");

        if (loadCredentialsCheck("FaranZafar23","Faizan@2017","data.properties")){
            System.out.println("Working2");
        }else {
            System.out.println("Not working");
        };

//        if (loadCredentialsCheck("Faran","123")){
//            System.out.println("Successful");
//        }
//        else{
//            System.out.println("Not Working");
//        }
//        Properties properties1 = new Properties();
////        credentials.put("Faran","123");
////        credentials.put("Arham","123");
////        credentials.put("Aiman","1223");
////        credentials.put("Zafar","1234");
//
//
//
//
//
//        Properties properties = new Properties();
//
////        properties.putAll(credentials);
////        properties.store(new FileOutputStream("data.properties"), null);
//
//
//        properties1.load(new FileInputStream("data.properties"));
//        for (String key : properties1.stringPropertyNames()) {
//            loadCredentials.put(key, properties1.get(key).toString());
//        }
//        loadCredentials.put("Mushi","12345");
//        properties1.putAll(loadCredentials);
//        properties1.store(new FileOutputStream("data.properties"), null);
//
//        System.out.println(loadCredentials);



    }
}
