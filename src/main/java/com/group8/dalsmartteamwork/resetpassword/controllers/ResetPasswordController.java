package com.group8.dalsmartteamwork.resetpassword.controllers;

import com.group8.dalsmartteamwork.login.dao.LoginImplementation;
import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDao;
import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoImpl;
import com.group8.dalsmartteamwork.resetpassword.models.NewPassword;
import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;
import com.group8.dalsmartteamwork.resetpassword.models.ResetPasswordRequest;
import com.group8.dalsmartteamwork.utils.Encryption;
import com.group8.dalsmartteamwork.utils.Mail;
import com.group8.dalsmartteamwork.utils.ResetToken;
import com.group8.dalsmartteamwork.utils.User;
import jdk.nashorn.internal.parser.Token;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class ResetPasswordController {

    @GetMapping("/forgotpassword")
    public String viewResetPasswordForm(Model model) {
        model.addAttribute("resetpasswordrequest", new ResetPasswordRequest());
        return "resetPasswordRequestForm";
    }

    @PostMapping("/forgotpassword")
    public String requestPasswordReset(@ModelAttribute ResetPasswordRequest resetPasswordRequest, Model model) {
        ResetPasswordDao resetPasswordDaoImpl = new ResetPasswordDaoImpl();
        model.addAttribute("resetPasswordRequest", resetPasswordRequest);
        try {
            ResetToken resetToken = new ResetToken();
            String token = resetToken.createToken();
            Boolean updateStatus = resetPasswordDaoImpl.addToken(resetPasswordRequest.getBannerID(), token);
            if (!updateStatus) {
                return "resetPasswordUserNotFound";
            } else {
                //TODO: Send Email with token and BannerID ("/resetpassword?bannerid=B00000000&token=a0a1a2a3a4a5a6a7a8a9")
                Mail mail = new Mail();
                String email = resetPasswordDaoImpl.getUserEmail(resetPasswordRequest.getBannerID());
//                String content="<a href=\"localhost:8080/resetpassword?bannerid="+resetPasswordRequest.getBannerID()+"&token="+token+"\">Click here</a> to reset your password.";
//                String content="<html><body><a href=\"localhost:8080/resetpassword?bannerid="+resetPasswordRequest.getBannerID()+"&token="+token+"\">Click here</a> to reset your password. </body></html>";
                String content = "localhost:8080/resetpassword?bannerid="+resetPasswordRequest.getBannerID()+"&token="+token;
                mail.sendEmail(email, "Password Reset Request", content);
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return "resetPasswordEmailMessage";
    }

    @GetMapping("/resetpassword")
    public String resetPassword(@RequestParam(name = "bannerid") String bannerID,
                                @RequestParam(name = "token") String token,
                                Model model) {
        ResetPasswordDaoImpl resetPasswordDaoImpl = new ResetPasswordDaoImpl();
        PasswordResetToken passwordResetToken = resetPasswordDaoImpl.getRequestByToken(bannerID, token);
        if (passwordResetToken.getStatus().equals("valid")) {
            NewPassword newPassword = new NewPassword();
            newPassword.setBannerID(bannerID);
            model.addAttribute("newpassword", newPassword);
            return "resetPasswordForm";
        } else if (passwordResetToken.getStatus().equals("expired")) {
            return "tokenexpired";
        } else {
            return "badrequest";
        }
    }

    @PostMapping("/resetpassword")
    public String requestPasswordReset(@ModelAttribute NewPassword newPassword, Model model) {
        ResetPasswordDao resetPasswordDaoImpl = new ResetPasswordDaoImpl();
        Encryption encryption = new Encryption();
//        String encrypted_password = encryption.encrypt(newPassword.getPassword());
        String encrypted_password = newPassword.getPassword();
        try {
            Boolean updateStatus = resetPasswordDaoImpl.updatePassword(newPassword.getBannerID(), encrypted_password);
            if (!updateStatus) {
                return "resetPasswordUserNotFound";
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return "passwordResetSuccess";
    }
}
