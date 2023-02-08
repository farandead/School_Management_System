package SchoolMangement;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    public static boolean SendEmail(String recepient, String email, String Password, String username) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String myAccountEmail = "farandeadz@gmail.com";
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
        message.setText("Hi there "+username+" !"+"\n"+"Here are your Login Details for Accessing the company EMS:\nEmail: "+email+"\nPassword: "+Password+"\n\nDon't Share Your Login Details with ANYONE !\n\n\n\n\n®All Rights Reserved | Faran Zafar |EMS Version 1.1.1.0");
        Transport.send(message);
        return true;
    }

}
