package fr.afpa.mail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MyEmail {
   

    public static void main(String args[]) throws AddressException, MessagingException, IOException {
        Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("elastikman1421@gmail.com", "luna1004");
            }
        });

        Message message = new MimeMessage(session);
        Address addressTo = new InternetAddress("elastikman1421@gmail.com");
		message.setRecipient(Message.RecipientType.TO, addressTo);
        message.setSubject("HotelCDA - Chambre réservée");

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("Bonjour,\n\n"
        		+ "Veuillez retrouver votre résumé de votre chambre réservée chez nous.\n\n"
        		+ "Cordialement");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        MimeBodyPart attachmentPart = new MimeBodyPart();

        attachmentPart.attachFile(new File("C:\\Users\\dnych\\Desktop\\Capture.PNG"));

        multipart.addBodyPart(attachmentPart);

        message.setContent(multipart);

        Transport.send(message);
    }


}