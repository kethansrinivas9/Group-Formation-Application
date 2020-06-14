package com.group8.dalsmartteamwork.resetpassword.services;

import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDao;
import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoImpl;
import com.group8.dalsmartteamwork.utils.Mail;

public class ResetPasswordServiceImpl implements ResetPasswordService {

    @Override
    public Boolean sendPasswordResetMail(String bannerID, String token) {
        try {
            ResetPasswordDao resetPasswordDao = new ResetPasswordDaoImpl();
            Mail mail = new Mail();
            String email = resetPasswordDao.getUserEmail(bannerID);
//                String content="<a href=\"localhost:8080/resetpassword?bannerid="+resetPasswordRequest.getBannerID()+"&token="+token+"\">Click here</a> to reset your password.";
//                String content="<html><body><a href=\"localhost:8080/resetpassword?bannerid="+resetPasswordRequest.getBannerID()+"&token="+token+"\">Click here</a> to reset your password. </body></html>";
            String content = "localhost:8080/resetpassword?bannerid=" + bannerID + "&token=" + token;
            mail.sendEmail(email, "Password Reset Request", content);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
