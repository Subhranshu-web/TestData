package in.nit.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailService {
	public static void main(String[] args) {
		try {

			String to="s.pradhan3022@gmail.com";
			String sub="Hello Bulu!!";
			String text="HI Subu";

			Properties p=new Properties();
			p.put("mail.smtp.host","smtp.gmail.com");
			p.put("mail.smtp.port",587);
			p.put("mail.smtp.auth",true);
			p.put("mail.smtp.starttls.enable",true);


			final String user="paramesh.nit.12@gmail.com";
			final String pwd="boot123456";

			Session ses=Session.getInstance(p, new Authenticator() { 
				protected PasswordAuthentication getPasswordAuthentication()   {   
					return new PasswordAuthentication(user,pwd);

				}
			});


			MimeMessage m=new MimeMessage(ses); 
			m.setRecipient(RecipientType.TO, new InternetAddress(to));
			m.setSubject(sub); 
			m.setText(text);

			Transport.send(m);    
			System.out.println("done"); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
