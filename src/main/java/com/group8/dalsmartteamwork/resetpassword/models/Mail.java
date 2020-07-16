package com.group8.dalsmartteamwork.resetpassword.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail implements IMail {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
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
            LOGGER.error("Exception occurred while trying to initialize Mail class. ", e);
        }
    }

    @Override
    public Boolean sendEmail(String toEmail, String subject, String text) {
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setSubject(subject, "UTF-8");
            msg.setText(text, "UTF-8");
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);
            return true;
        } catch (Exception e) {
            LOGGER.error("Exception occurred while trying to send email. ", e);
            return false;
        }
    }
}
