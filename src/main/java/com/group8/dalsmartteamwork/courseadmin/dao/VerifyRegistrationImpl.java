package com.group8.dalsmartteamwork.courseadmin.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.group8.dalsmartteamwork.utils.User;
import com.group8.dalsmartteamwork.utils.DbConnection;
import com.group8.dalsmartteamwork.utils.Encryption;
import com.group8.dalsmartteamwork.utils.Mail;

public class VerifyRegistrationImpl implements VerifyRegistrationDao {
    private final String ALLOWED_CHARS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM0987654321";
    private final String INVITE_SUBJECT = "CatME Registration";
    private final String INVITE_TEXT_FORMAT = "You have been registered to CatME. You can login with your email and password: %s";

    @Override
    public List<Boolean> verifyRegistration(List<User> users) {
        List<Boolean> status = new ArrayList<>();
        try {
            DbConnection dbConnection = new DbConnection();
            Encryption encryption = new Encryption();
            Mail mail = new Mail();
            if (users.size() == 0) {
                return status;
            }
            for (User user : users) {
                String password = generatePassword(15);
                String encrypted_password = encryption.encrypt(password);
                String selectQuery = String.format("SELECT * FROM Users where BannerId='%s'", user.getId());
                ResultSet resultSet = dbConnection.getRecords(selectQuery);
                int rsCount = 0;
                while (resultSet.next()) {
                    rsCount = rsCount + 1;
                }
                if (rsCount > 0) {
                    status.add(false);
                    continue;
                }
                String insertQuery = String.format("INSERT INTO Users VALUES('%s', '%s', '%s', '%s', '%s')",
                        user.getId(), user.getLastName(), user.getFirstName(), user.getEmail(), encrypted_password);
                dbConnection.updateRecords(insertQuery);
                String message = String.format(this.INVITE_TEXT_FORMAT, password);
                mail.sendEmail(user.getEmail(), this.INVITE_SUBJECT, message);
                status.add(true);
            }
            dbConnection.close();
        } catch (Exception e) {
            // TODO: Add to Log
            e.printStackTrace();
        }

        return status;
    }

    public String generatePassword(int length) {
        int len = this.ALLOWED_CHARS.length();
        StringBuilder stringBuilder = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(this.ALLOWED_CHARS.charAt(rand.nextInt(len)));
        }

        return stringBuilder.toString();
    }

}