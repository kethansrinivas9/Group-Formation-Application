package com.group8.dalsmartteamwork.resetpassword.models;

import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDao;
import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoImpl;
import com.group8.dalsmartteamwork.utils.Mail;

import java.sql.SQLException;

public class ResetPasswordManagerImpl implements IResetPasswordManager {

    public Boolean sendPasswordResetMail(String bannerID, String token) throws SQLException {
        String DEV_INT_DOMAIN = "https://catme-app-test-server.herokuapp.com";
        String PRODUCTION_DOMAIN = "https://catme-app-production-server.herokuapp.com";
        String LOCALHOST_DOMAIN = "localhost:8080";

        Mail mail = new Mail();
        ResetPasswordDao resetPasswordDao = new ResetPasswordDaoImpl();

        String environment = System.getenv("db.environment");
        String domain;
        String email = resetPasswordDao.getUserEmail(bannerID);

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
}
