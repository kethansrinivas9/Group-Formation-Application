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

    @Override
    public List<Boolean> verifyRegistration(List<User> users) {
        List<Boolean> status = new ArrayList<>();
        try {
            DbConnection dbConnection = new DbConnection();
            Mail mail = new Mail();
            if (users.size() == 0) {
                return status;
            }
            for (User user : users) {
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
                String password = generatePassword(15);
                Encryption encryption = new Encryption();
                String encrypted_password = encryption.encrypt(password);
                String insertQuery = String.format("INSERT INTO Users VALUES('%s', '%s', '%s', '%s', '%s')",
                        user.getId(), user.getLastName(), user.getFirstName(), user.getEmail(), encrypted_password);
                dbConnection.updateRecords(insertQuery);
                String message = String.format(
                        "You have been registered to CatME. You can login with your email and password: %s", password);
                String subject = "CatME Registration";
                mail.sendEmail(user.getEmail(), subject, message);
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
        String allowedChars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM0987654321";
        int len = allowedChars.length();
        StringBuilder stringBuilder = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(allowedChars.charAt(rand.nextInt(len)));
        }

        return stringBuilder.toString();
    }

}