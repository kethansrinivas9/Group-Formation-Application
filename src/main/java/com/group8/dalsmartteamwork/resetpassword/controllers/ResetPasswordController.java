package com.group8.dalsmartteamwork.resetpassword.controllers;

import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDao;
import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoImpl;
import com.group8.dalsmartteamwork.resetpassword.models.NewPassword;
import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;
import com.group8.dalsmartteamwork.resetpassword.models.ResetPasswordRequest;
import com.group8.dalsmartteamwork.utils.Encryption;
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
        return "resetPasswordRequest";
    }


    @PostMapping("/forgotpassword")
    public String requestPasswordReset(@ModelAttribute ResetPasswordRequest resetPasswordRequest, Model model) {
        ResetPasswordDao resetPasswordDaoImpl = new ResetPasswordDaoImpl();
        model.addAttribute("resetPasswordRequest", resetPasswordRequest);
        try {
            Boolean updateStatus = resetPasswordDaoImpl.addToken(resetPasswordRequest.getBannerID());
            if (!updateStatus) {
                return "resetPasswordUserNotFound";
            } else {
                //TODO: Send Email with token and BannerID ("/resetpassword?bannerid=B00000000&token=a0a1a2a3a4a5a6a7a8a9")
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return "resetPasswordMessage";
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
            return "resetPassword";
        } else if (passwordResetToken.getStatus().equals("expired")) {
            return "tokenexpired";
        }
        return "badrequest";
    }

    @PostMapping("/resetpassword")
    public String requestPasswordReset(@ModelAttribute NewPassword newPassword, Model model) {
        ResetPasswordDao resetPasswordDaoImpl = new ResetPasswordDaoImpl();
        Encryption encryption = new Encryption();
        String encrypted_password = encryption.encrypt(newPassword.getPassword());
        try {
            Boolean updateStatus = resetPasswordDaoImpl.updatePassword(newPassword.getBannerID(), encrypted_password);
            if (!updateStatus) {
                return "resetPasswordUserNotFound";
            } else {
                //TODO: (Optional) Send Email stating that the password was changed.
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return "resetPasswordMessage";
    }
}
