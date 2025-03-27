package utils;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailReportSender {
	// this utility class is for sending the extent report as an email attachment to the team when the test execution is completed.
	
	// needs some workaround as gmail does not accept my password .
	   public static void sendEmailReport() {
	        String to = "hussainrezai333@gmail.com"; // receiver email
	        String from = "hussainrezai333@gmail.com"; // sender email
	        String password = "GityLove$333"; // sender email password
	        String smtpHost = "smtp.gmail.com"; // 🔹 Use SMTP server of your email provider
	        String reportPath = ".\\reports/ExtentReport.html"; // 🔹 Set the correct path

	        // SMTP Configuration
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", smtpHost);
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");

	        // Authenticate
	        Session session = Session.getInstance(properties, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(from, password);
	            }
	        });

	        try {
	            // Create Email Message
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(from));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	            message.setSubject("Test Execution Report - Extent Report");

	            // Email Body
	            BodyPart messageBodyPart = new MimeBodyPart();
	            messageBodyPart.setText("Hello Team,\n\nPlease find the attached Extent Report for the latest test run.\n\nBest Regards,\nQA Team");

	            // Attach the Report
	            MimeBodyPart attachmentPart = new MimeBodyPart();
	            attachmentPart.attachFile(new File(reportPath));

	            // Combine Both Parts
	            Multipart multipart = new MimeMultipart();
	            multipart.addBodyPart(messageBodyPart);
	            multipart.addBodyPart(attachmentPart);
	            message.setContent(multipart);

	            // Send Email
	            Transport.send(message);
	            System.out.println("Test Report Sent Successfully!");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        sendEmailReport();
	    }

}
