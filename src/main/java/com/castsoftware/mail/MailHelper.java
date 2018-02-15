package com.castsoftware.mail;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import com.castsoftware.taskengine.Task;
import com.castsoftware.util.GlobalProperties;
import com.castsoftware.util.GlobalPropertiesManager;

/*
	The following section will need to be present in your application properties file
	
	###Email Configuration###
	smtp.server=smtp.gmail.com
	smtp.port=465
	reply.address=j.godfroid@castsoftware.com
	#only specify login and password if SMTP authentication is required
	smtp.login=cast.integration@gmail.com
	smtp.password=C@stInt3gr@tion
	smtp.useSSL=true
*/

public class MailHelper {
	protected static final Logger logger = Logger.getLogger(Task.class);
	protected static final GlobalProperties globalProperties = GlobalPropertiesManager.getGlobalProperties();
	
	public static boolean sendMail(String recipients, String subject, String text)
	{
		return sendMail(recipients, subject, text, null);
	}
	
	public static boolean sendMail(String recipients, String subject, String text, String attachements)
	{
		if ((recipients == null) || recipients.equals(""))
		{
			logger.error("Can't send email when recipient field is null or empty!");
			return false;
		}
		
		logger.info(String.format("Sending email to '%s' - %s", recipients.toString(), subject));
		logger.debug(String.format("Email Text: %s", text));
		
		try
        {
			Session session;
			String smtpServer = globalProperties.getPropertyValue("smtp.server");
	
	        // Get system properties
	        Properties properties = System.getProperties();
	
	        // Setup mail server
	        properties.setProperty("mail.transport.protocol", "smtp");        
	        properties.setProperty("mail.smtp.host", smtpServer);
	        logger.debug(String.format("%s --> %s", "mail.smtp.host", smtpServer));
	        
	        Integer port = globalProperties.getPropertyValueAsInteger("smtp.port", 25);
	        properties.setProperty("mail.smtp.port", port.toString());
	        logger.debug(String.format("%s --> %d", "mail.smtp.port", port));
	        
	        //SSL?
	        String useSSL = globalProperties.getPropertyValue("smtp.useSSL");
			if ((useSSL != null) && (useSSL.toLowerCase().equals("true")))
			{
				properties.setProperty("mail.smtp.socketFactory.class",	"javax.net.ssl.SSLSocketFactory");
				logger.debug(String.format("%s --> %s", "mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"));
			    properties.setProperty("mail.smtp.socketFactory.port", port.toString());
			    logger.debug(String.format("%s --> %d", "mail.smtp.socketFactory.port", port));
			}
	        
			//SMTP Authentication
	        String smtpLogin = globalProperties.getPropertyValue("smtp.login");
	        String smtpPassword = globalProperties.getPropertyValue("smtp.password");
			if ((smtpLogin != null) && (!smtpLogin.equals("")))
			{
		        properties.setProperty("mail.smtp.auth", "true");
		        logger.debug(String.format("%s --> %s", "mail.smtp.auth", "true"));
		        Authenticator auth = new SMTPAuthenticator(smtpLogin, smtpPassword);
		        logger.debug(String.format("Login: %s", smtpLogin));
		        logger.debug(String.format("Password: %s", smtpPassword));
		        
		        session = Session.getDefaultInstance(properties, auth);
			}
			else
			{
				session = Session.getDefaultInstance(properties);
			}

        	Transport transport = session.getTransport();
        	
        	// Create a default MimeMessage object.
        	MimeMessage message = new MimeMessage(session);

           // Set From: header field of the header.
        	String replyAddress = globalProperties.getPropertyValue("reply.address");
        	logger.debug(String.format("Reply/From Address: %s", replyAddress));
	        message.setFrom(new InternetAddress(replyAddress));
	        message.setReplyTo(InternetAddress.parse(replyAddress));
	        	        
	        for(String recipient : recipients.split(";"))
	        	message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
	
	        // Set Subject: header field
	        message.setSubject(subject);
	        
	        //Multipart container
	        Multipart multipart = new MimeMultipart();
	        
	        // Now set the actual message
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setText(text);
	        multipart.addBodyPart(messageBodyPart);
	        
	        //Attachements
	        if ((attachements != null) && !attachements.equals(""))
	        {
		        for(String attachement : attachements.split(";"))
		        {
		        	MimeBodyPart attachementPart = new MimeBodyPart();
			        DataSource source = new FileDataSource(attachement);
			        attachementPart.setDataHandler(new DataHandler(source));
			        attachementPart.setFileName(attachement);
			        multipart.addBodyPart(attachementPart);		        	
		        }
	        }
	        
	        //Attach multiparts in message
	        message.setContent(multipart);
	        
	        // Send message
	        transport.connect();
	        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
	        transport.close();
	        logger.debug("Sent message successfully....");
        } catch (MessagingException | InterruptedException | IOException e) 
        {
        	logger.error("Error Sending email!");
        	logger.error(e.getMessage());
        	return false;
        } 	
		return true;
	}
}
