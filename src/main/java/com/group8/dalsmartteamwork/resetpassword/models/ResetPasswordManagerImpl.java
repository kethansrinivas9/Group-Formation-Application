package com.group8.dalsmartteamwork.resetpassword.models;

import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDao;
import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoImpl;
import com.group8.dalsmartteamwork.utils.Encryption;
import com.group8.dalsmartteamwork.utils.Mail;
import com.group8.dalsmartteamwork.utils.ResetToken;

import javax.mail.MessagingException;
import java.sql.SQLException;

public class ResetPasswordManagerImpl implements IResetPasswordManager {

    @Override
    public Boolean addResetRequest(String bannerID) {
        ResetPasswordDao resetPasswordDao = new ResetPasswordDaoImpl();
        try {
            if (resetPasswordDao.userExists(bannerID)) {
                ResetToken resetToken = new ResetToken();
                String token = resetToken.createToken();
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
        if(mail.sendEmail(email, "Password Reset Request", mailContent)){
            return true;
        }
        return false;
    }

    @Override
    public Boolean isRequestValid(String bannerID, String token) {
        try {
            ResetPasswordDao resetPasswordDao = new ResetPasswordDaoImpl();
            PasswordResetToken passwordResetToken = resetPasswordDao.getPasswordResetRequest(bannerID, token);
            if (passwordResetToken.getStatus().equals("valid")) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public Boolean updatePassword(String bannerID, String password) {

        ResetPasswordDao resetPasswordDao = new ResetPasswordDaoImpl();
        Encryption encryption = new Encryption();

        String encrypted_password = encryption.encrypt(password);

        try {
            if (resetPasswordDao.updatePassword(bannerID, encrypted_password)) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }


}
