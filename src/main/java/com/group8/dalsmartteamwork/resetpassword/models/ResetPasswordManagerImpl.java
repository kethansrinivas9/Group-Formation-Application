package com.group8.dalsmartteamwork.resetpassword.models;

import com.group8.dalsmartteamwork.login.model.Encryption;
import com.group8.dalsmartteamwork.login.model.IEncryption;
import com.group8.dalsmartteamwork.resetpassword.dao.IResetPasswordDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class ResetPasswordManagerImpl implements IResetPasswordManager {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final IResetPasswordDao resetPasswordDao;

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
            } else {
                LOGGER.warn(String.format("Password reset mail cannot be sent because user with Banner ID: %s does not exist", bannerID));
            }
        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while sending password reset email to user with BannerID: " + bannerID, exception);
            return false;
        }
        LOGGER.warn("Failed to send password reset email to user with BannerID: " + bannerID);
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
            LOGGER.error("Exception occurred while trying to get email of user with BannerID: " + bannerID, exception);
        }

        if (environment.equals("DEV_INT")) {
            domain = DEV_INT_DOMAIN;
        } else if (environment.equals("PRODUCTION")) {
            domain = PRODUCTION_DOMAIN;
        } else {
            domain = LOCALHOST_DOMAIN;
        }
        String mailContent = domain + "/resetpassword?bannerid=" + bannerID + "&token=" + token;
        Boolean mailSent = mail.sendEmail(email, "Password Reset Request", mailContent);
        if (mailSent) {
            LOGGER.info("Password Reset email sent to user with BannerID: " + bannerID);
        } else {
            LOGGER.warn("Failed to send password reset email to user with BannerID: " + bannerID);
        }
        return mailSent;
    }

    @Override
    public Boolean isRequestValid(String bannerID, String token) {
        try {
            IPasswordResetToken passwordResetToken = resetPasswordDao.getPasswordResetRequest(bannerID, token);
            if (passwordResetToken.getStatus().equals("valid")) {
                return true;
            }
        } catch (SQLException exception) {
            LOGGER.error("Failed to fetch password reset request of user with BannerID: " + bannerID, exception);
            return false;
        }
        return false;
    }

    @Override
    public Boolean updatePassword(String bannerID, String password) {
        IEncryption encryption = new Encryption();

        String encrypted_password = encryption.encrypt(password);
        if (null == encrypted_password) {
            LOGGER.warn("Password encryption failed for BannerID: " + bannerID);
        }
        try {
            if (resetPasswordDao.updatePassword(bannerID, encrypted_password)) {
                return true;
            }
        } catch (SQLException exception) {
            LOGGER.error("Failed to update password of user with BannerID: " + bannerID, exception);
        }
        return false;
    }
}
