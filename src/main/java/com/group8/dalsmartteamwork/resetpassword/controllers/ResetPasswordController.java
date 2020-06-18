package com.group8.dalsmartteamwork.resetpassword.controllers;

import com.group8.dalsmartteamwork.resetpassword.dao.IPasswordHistoryManager;
import com.group8.dalsmartteamwork.resetpassword.dao.PasswordHistoryManagerImpl;
import com.group8.dalsmartteamwork.resetpassword.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResetPasswordController {

    @GetMapping("/forgotpassword")
    public String viewResetPasswordForm(Model model) {
        model.addAttribute("resetpasswordrequest", new ResetPasswordRequest());
        return "resetPassword/resetPasswordRequestForm";
    }

    @PostMapping("/forgotpassword")
    public String requestPasswordReset(@ModelAttribute ResetPasswordRequest resetPasswordRequest, Model model) {
        IResetPasswordManager resetPasswordManager = new ResetPasswordManagerImpl();
        model.addAttribute("bannerID", resetPasswordRequest.getBannerID());
        if (!resetPasswordManager.addResetRequest(resetPasswordRequest.getBannerID())) {
            return "resetPassword/resetPasswordUserNotFound";
        }
        return "resetPassword/resetPasswordEmailMessage";
    }

    @GetMapping("/resetpassword")
    public String resetPassword(@RequestParam(name = "bannerid") String bannerID,
                                @RequestParam(name = "token") String token,
                                Model model) {
        IResetPasswordManager resetPasswordManager = new ResetPasswordManagerImpl();
        if (resetPasswordManager.isRequestValid(bannerID, token)) {
            NewPassword newPassword = new NewPassword();
            newPassword.setBannerID(bannerID);
            model.addAttribute("newPassword", newPassword);
            return "resetPassword/resetPasswordForm";
        } else {
            return "badrequest";
        }
    }

    @PostMapping("/resetpassword")
    public String requestPasswordReset(@ModelAttribute NewPassword newPassword, Model model) {
        IResetPasswordManager resetPasswordManager = new ResetPasswordManagerImpl();
        PasswordPolicy passwordPolicy = new PasswordPolicy();

        if (!passwordPolicy.isValid(newPassword.getPassword())) {
            model.addAttribute("errorMessages", passwordPolicy.generateErrorMessage());
            model.addAttribute("newPassword", newPassword);
            return "resetPassword/resetPasswordForm";
        } else {

            if (passwordPolicy.getHistoryConstraint().equals("true")) {
                IPasswordHistoryManager passwordHistoryManager = new PasswordHistoryManagerImpl();

                if (passwordHistoryManager.passwordExists(newPassword.getBannerID(), newPassword.getPassword())) {
                    model.addAttribute("error",
                            "New password cannot be same as current or last three old passwords.");
                    model.addAttribute("newPassword", newPassword);
                    return "resetPassword/resetPasswordForm";
                } else {
                    passwordHistoryManager.moveCurrentPassword(newPassword.getBannerID());
                }
            }

            if (resetPasswordManager.updatePassword(newPassword.getBannerID(), newPassword.getPassword())) {
                return "resetPassword/passwordResetSuccess";
            } else {
                return "resetPassword/failedToUpdatePassword";
            }
        }
    }
}
