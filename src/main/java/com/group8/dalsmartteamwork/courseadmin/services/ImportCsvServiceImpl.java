package com.group8.dalsmartteamwork.courseadmin.services;

import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.utils.Encryption;
import com.group8.dalsmartteamwork.utils.Mail;
import com.group8.dalsmartteamwork.utils.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImportCsvServiceImpl implements ImportCsvService{

    @Override
    public List<Boolean> verifyRegistration(List<User> users) {
        List<Boolean> status = new ArrayList<>();
        try {
            RegistrationDaoImpl dao = new RegistrationDaoImpl();
            Encryption encryption = new Encryption();
            Mail mail = new Mail();
            if (users.size() == 0) {
                return status;
            }
            for (User user : users) {
                String password = generatePassword();
                String encrypted_password = encryption.encrypt(password);
                user.setPassword(encrypted_password);
                Boolean userDbStatus = dao.isUserInDb(user.getId());
                if(userDbStatus){
                    status.add(false);
                }
                else {
                    dao.addUserToDb(user);
                    final String INVITE_TEXT_FORMAT = "You have been registered to CatME. You can login with your email and password: %s";
                    final String INVITE_SUBJECT = "CatME Registration";
                    String message = String.format(INVITE_TEXT_FORMAT, password);
                    mail.sendEmail(user.getEmail(), INVITE_SUBJECT, message);
                    status.add(true);
                }
            }
        } catch (Exception e) {
            // TODO: Add to Log
            e.printStackTrace();
        }

        return status;
    }

    private String generatePassword() {
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