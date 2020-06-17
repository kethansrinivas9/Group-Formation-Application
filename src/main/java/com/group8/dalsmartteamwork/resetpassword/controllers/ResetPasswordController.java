package com.group8.dalsmartteamwork.resetpassword.controllers;

import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDao;
import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoImpl;
import com.group8.dalsmartteamwork.resetpassword.models.*;
import com.group8.dalsmartteamwork.utils.Encryption;
import com.group8.dalsmartteamwork.utils.ResetToken;
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
        return "resetPassword/resetPasswordRequestForm";
    }

    @PostMapping("/forgotpassword")
    public String requestPasswordReset(@ModelAttribute ResetPasswordRequest resetPasswordRequest, Model model) {
        ResetPasswordDao resetPasswordDao = new ResetPasswordDaoImpl();
        model.addAttribute("resetPasswordRequest", resetPasswordRequest);
        try {
            ResetToken resetToken = new ResetToken();
            String token = resetToken.createToken();
            if (resetPasswordDao.userExists(resetPasswordRequest.getBannerID())) {
                Boolean updateStatus = resetPasswordDao.addToken(resetPasswordRequest.getBannerID(), token);
                if (updateStatus) {
                    IResetPasswordManager resetPasswordManager = new ResetPasswordManagerImpl();
                    if (!resetPasswordManager.sendPasswordResetMail(resetPasswordRequest.getBannerID(), token)) {
                        return "resetPassword/failedToSendEmail";
                    }
                }
            } else {
                return "resetPassword/resetPasswordUserNotFound";
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return "resetPassword/resetPasswordEmailMessage";
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
            return "resetPassword/resetPasswordForm";
        } else if (passwordResetToken.getStatus().equals("expired")) {
            return "resetPassword/tokenexpired";
        } else {
            return "badrequest";
        }
    }

    @PostMapping("/resetpassword")
    public String requestPasswordReset(@ModelAttribute NewPassword newPassword, Model model) {
        ResetPasswordDao resetPasswordDaoImpl = new ResetPasswordDaoImpl();
        Encryption encryption = new Encryption();
        String encrypted_password = encryption.encrypt(newPassword.getPassword());
        try {
            Boolean updateStatus = resetPasswordDaoImpl.updatePassword(newPassword.getBannerID(), encrypted_password);
            if (!updateStatus) {
                return "resetPassword/resetPasswordUserNotFound";
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return "resetPassword/passwordResetSuccess";
    }
}
