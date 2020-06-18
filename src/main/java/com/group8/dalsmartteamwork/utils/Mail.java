package com.group8.dalsmartteamwork.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {
    private Session session;

    public Mail() {
        try {
            final String username = System.getenv("mail.smtp.username");
            final String password = System.getenv("mail.smtp.password");

            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", System.getenv("mail.smtp.host"));
            properties.setProperty("mail.smtp.host", System.getenv("mail.smtp.host"));
            properties.setProperty("mail.smtp.port", System.getenv("mail.smtp.port"));
            properties.setProperty("mail.smtp.auth", System.getenv("mail.smtp.auth"));

            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            };

            session = Session.getInstance(properties, auth);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public Boolean sendEmail(String toEmail, String subject, String text) throws MessagingException {
        MimeMessage msg = new MimeMessage(session);
        msg.setSubject(subject, "UTF-8");
        msg.setText(text, "UTF-8");
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        Transport.send(msg);
        return true;
    }
}
