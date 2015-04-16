/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Epost;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author Matus
 */
public class Epost {
    
   public Epost() {
       
   }
   
   public void skickaEpostChef(String chefMail,String ärende) {
       final String username = "hamshovits123@gmail.com";
		final String password = "vitslosen";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("hamshovits123@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(chefMail));
			message.setSubject("Nytt ärende!");
			message.setText("Hej på dig chefen,"
				+ "\n du har ett nytt " + ärende + " att bekräfta!");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
       
   }
}
