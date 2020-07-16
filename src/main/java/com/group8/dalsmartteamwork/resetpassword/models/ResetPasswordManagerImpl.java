package com.group8.dalsmartteamwork.resetpassword.models;

import com.group8.dalsmartteamwork.login.model.Encryption;
import com.group8.dalsmartteamwork.login.model.IEncryption;
import com.group8.dalsmartteamwork.resetpassword.dao.IResetPasswordDao;
import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoFactory;

import java.sql.SQLException;

public class ResetPasswordManagerImpl implements IResetPasswordManager {
    private final IResetPasswordDao resetPasswordDao;

    public ResetPasswordManagerImpl(){
        resetPasswordDao = ResetPasswordDaoFactory.instance().resetPasswordDao();
    }
    public ResetPasswordManagerImpl(IResetPasswordDao resetPasswordDao) {
        this.resetPasswordDao = resetPasswordDao;
    }

    @Override
    public Boolean addResetRequest(String bannerID) {
        try {
            if (resetPasswordDao.userExists(bannerID)) {
                IResetToken resetToken = new ResetToken();
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

        IMail mail = new Mail();

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

    @Override
    public Boolean isRequestValid(String bannerID, String token) {
        try {
            IPasswordResetToken passwordResetToken = resetPasswordDao.getPasswordResetRequest(bannerID, token);
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
        IEncryption encryption = new Encryption();

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
