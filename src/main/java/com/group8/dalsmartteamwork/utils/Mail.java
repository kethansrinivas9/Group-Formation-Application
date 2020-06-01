package com.group8.dalsmartteamwork.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
    private Session session;

    public Mail() {
        try {
            Props props = new Props();
            Properties properties = props.getProperties();
            final String username = props.getValue("mail.smtp.username");
            final String password = props.getValue("mail.smtp.password");

            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            };

            this.session = Session.getInstance(properties, auth);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public Session getSession() {
        return this.session;
    }

    public Boolean sendEmail(String toEmail, String subject, String text) {
        try {
            MimeMessage msg = new MimeMessage(this.session);
            msg.setSubject(subject, "UTF-8");
            msg.setText(text, "UTF-8");
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
}
