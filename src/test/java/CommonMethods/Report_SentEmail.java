package CommonMethods;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;

@Test
public class Report_SentEmail {

	public static void Report() 
	{

		// Create object of Property file
		Properties props = new Properties();

		// this will set host of server- you can change based on your requirement 
		props.put("mail.smtp.host", "ind.smtp.accenture.com");

		// set the port of socket factory 
		//props.put("mail.smtp.socketFactory.port", "465");

		// set socket factory
		//props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		//props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		//props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
	Session session = Session.getDefaultInstance(props,	new javax.mail.Authenticator() 
	{

	protected PasswordAuthentication getPasswordAuthentication() 
	{

		return new PasswordAuthentication("arun.anthony.reethal@accenture.com", "*runJS!123");

	}

	});

	try 
	{
			
		Message message = new MimeMessage(session);
			
		message.setFrom(new InternetAddress("arun.anthony.reethal@accenture.com"));
			
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("arun.anthony.reethal@accenture.com"));
			
		message.setSubject("Regression Automation Report");
			
		BodyPart messageBodyPart1 = new MimeBodyPart();
			
		messageBodyPart1.setText("Regression Test Report");
			
		MimeBodyPart messageBodyPart2 = new MimeBodyPart();

		String filename = "C:\\MyCompetency_TestAutomation\\MyCompetency_Regression_Automation\\Extent Reports\\ObjectiveTestLogin_ExtentReportResults.html";
			
		DataSource source = new FileDataSource(filename);
			
		messageBodyPart2.setDataHandler(new DataHandler(source));
			
		messageBodyPart2.setFileName(filename);
			
		Multipart multipart = new MimeMultipart();
			
		multipart.addBodyPart(messageBodyPart2);
			
		multipart.addBodyPart(messageBodyPart1);
			
		message.setContent(multipart);
			
		Transport.send(message);

		System.out.println("=====Email Sent=====");

		} 
		
		catch (MessagingException e) 
		{

			throw new RuntimeException(e);

		}

	}

}