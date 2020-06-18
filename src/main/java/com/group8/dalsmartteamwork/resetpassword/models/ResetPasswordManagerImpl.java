package com.group8.dalsmartteamwork.resetpassword.models;

import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDao;
import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoImpl;
import com.group8.dalsmartteamwork.utils.Mail;

import java.sql.SQLException;
import java.util.Random;

public class ResetPasswordManagerImpl implements IResetPasswordManager {

    public static char getRandomChar() {
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        return characterSet.charAt(random.nextInt(62));
    }

    @Override
    public Boolean addResetRequest(String bannerID) {
        ResetPasswordDao resetPasswordDao = new ResetPasswordDaoImpl();
        try {
            if (resetPasswordDao.userExists(bannerID)) {
                String token = createToken();
                if (resetPasswordDao.addToken(bannerID, token)) {
                    sendPasswordResetMail(bannerID, token);
                    return true;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public Boolean sendPasswordResetMail(String bannerID, String token) {
        String DEV_INT_DOMAIN = "https://catme-app-test-server.herokuapp.com";
        String PRODUCTION_DOMAIN = "https://catme-app-production-server.herokuapp.com";
        String LOCALHOST_DOMAIN = "localhost:8080";

        Mail mail = new Mail();
        ResetPasswordDao resetPasswordDao = new ResetPasswordDaoImpl();

        String environment = System.getenv("db.environment");
        String domain;
        String email = null;
        try {
            email = resetPasswordDao.getUserEmail(bannerID);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        if (environment.equals("DEV_INT")) {
            domain = DEV_INT_DOMAIN;
        } else if (environment.equals("PRODUCTION")) {
            domain = PRODUCTION_DOMAIN;
        } else {
            domain = LOCALHOST_DOMAIN;
        }
        String mailContent = domain + "/resetpassword?bannerid=" + bannerID + "&token=" + token;
        return mail.sendEmail(email, "Password Reset Request", mailContent);
    }

    public String createToken() {
        String tokenResult = "";
        try {
            for (int i = 0; i < 20; i++) {
                tokenResult += getRandomChar();
            }
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        }
        return tokenResult;
    }
}
