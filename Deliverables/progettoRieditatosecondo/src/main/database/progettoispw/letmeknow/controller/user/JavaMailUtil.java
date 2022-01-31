package progettoispw.letmeknow.controller.user;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {
    private String text;
    public Boolean sendMail(String recipient){
        try {
        Properties properties=new Properties();
        //configurazione server
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        //configurazione log
        String myAccount="progettoispw2021@gmail.com";
        String password="Password2021";
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
               protected PasswordAuthentication getPasswordAuthentication() {
                   return new PasswordAuthentication(myAccount, password);
                }
            });
        Message message = prepareMessage(session,myAccount,recipient);
        Transport .send(message);
        return true;
        } catch (Exception e ){
            return false;
        }
    }

    public void setText(String input){
        text=input;
    }
    public Message prepareMessage (Session session,String myAccountEmail, String reciver){
        try {
            Message message =new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(reciver));
            message.setSubject("recover password and userid");
            message.setText(text);
            return message;
        } catch (Exception e) {
           return null;
        }

    }
}
