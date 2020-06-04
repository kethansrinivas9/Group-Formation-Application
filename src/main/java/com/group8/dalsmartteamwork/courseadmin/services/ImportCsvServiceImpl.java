package com.group8.dalsmartteamwork.courseadmin.services;

import com.group8.dalsmartteamwork.register.dao.RegistrationDao;
import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.utils.Encryption;
import com.group8.dalsmartteamwork.utils.Mail;
import com.group8.dalsmartteamwork.utils.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImportCsvServiceImpl implements ImportCsvService{
    private RegistrationDao dao;
    private Mail mail;
    private int courseId;

    public ImportCsvServiceImpl(int courseId) {
        this.courseId = courseId;
    }

    public ImportCsvServiceImpl(int courseId, RegistrationDao dao, Mail mail){
        this.courseId = courseId;
        this.dao = dao;
        this.mail = mail;
    }

    @Override
    public List<Boolean> verifyRegistration(List<User> users) {
        List<Boolean> status = new ArrayList<>();
        try {
            Encryption encryption = new Encryption();
            if (this.dao == null) this.dao = new RegistrationDaoImpl();
            if(this.mail == null) this.mail = new Mail();
            if (users.size() == 0) {
                return status;
            }
            for (User user : users) {
                String password = generatePassword();
                String encrypted_password = encryption.encrypt(password);
                user.setPassword(encrypted_password);
                Boolean userDbStatus = this.dao.isUserInDb(user.getId());
                if(userDbStatus){
                    status.add(false);
                    this.dao.assignCourseToUser(user.getId(), courseId);
                }
                else {
                    this.dao.addUserToDb(user);
                    this.dao.assignCourseToUser(user.getId(), courseId);
                    final String INVITE_TEXT_FORMAT = "You have been registered to CatME and registered for the course %d. You can login with your email and password: %s";
                    final String INVITE_SUBJECT = "CatME Registration";
                    status.add(true);
                    String message = String.format(INVITE_TEXT_FORMAT, courseId, password);
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mail.sendEmail(user.getEmail(), INVITE_SUBJECT, message);
                        }
                    });
                    t.start();
                }
            }
        } catch (Exception e) {
            // TODO: Add to Log
            e.printStackTrace();
        }
        return status;
    }

    public String generatePassword() {
        final int PASSWORD_LENGTH = 15;
        String ALLOWED_CHARS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM0987654321";
        int len = ALLOWED_CHARS.length();
        StringBuilder stringBuilder = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            stringBuilder.append(ALLOWED_CHARS.charAt(rand.nextInt(len)));
        }
        return stringBuilder.toString();
    }
}