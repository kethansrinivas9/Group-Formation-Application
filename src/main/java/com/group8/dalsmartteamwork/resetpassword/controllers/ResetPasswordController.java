package com.group8.dalsmartteamwork.resetpassword.controllers;

import com.group8.dalsmartteamwork.resetpassword.dao.*;
import com.group8.dalsmartteamwork.resetpassword.models.*;
import com.group8.dalsmartteamwork.student.models.StudentModelsFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResetPasswordController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/forgotpassword")
    public String viewResetPasswordForm(Model model) {
        model.addAttribute("resetpasswordrequest", new ResetPasswordRequest());
        return "resetPassword/resetPasswordRequestForm";
    }

    @PostMapping("/forgotpassword")
    public String requestPasswordReset(@ModelAttribute ResetPasswordRequest resetPasswordRequest, Model model) {
        IResetPasswordDao resetPasswordDao = ResetPasswordDaoFactory.instance().resetPasswordDao();
        IResetPasswordManager resetPasswordManager = ResetPasswordModelsFactory.instance().resetPasswordManager();
        model.addAttribute("bannerID", resetPasswordRequest.getBannerID());

        if (resetPasswordManager.addResetRequest(resetPasswordRequest.getBannerID())) {
            return "resetPassword/resetPasswordEmailMessage";
        }
        else{
            LOGGER.warn(String.format("User not found (may not be registered). BannerID: %s", resetPasswordRequest.getBannerID()));
            return "resetPassword/resetPasswordUserNotFound";
        }
    }

    @GetMapping("/resetpassword")
    public String resetPassword(@RequestParam(name = "bannerid") String bannerID,
                                @RequestParam(name = "token") String token,
                                Model model) {
        IResetPasswordDao resetPasswordDao = ResetPasswordDaoFactory.instance().resetPasswordDao();
        IResetPasswordManager resetPasswordManager = ResetPasswordModelsFactory.instance().resetPasswordManager();
        if (resetPasswordManager.isRequestValid(bannerID, token)) {
            NewPassword newPassword = new NewPassword();
            newPassword.setBannerID(bannerID);
            model.addAttribute("newPassword", newPassword);
            return "resetPassword/resetPasswordForm";
        } else {
            LOGGER.warn(String.format("Invalid Password Reset Request. BannerID: %s", bannerID));
            return "badrequest";
        }
    }

    @PostMapping("/resetpassword")
    public String requestPasswordReset(@ModelAttribute NewPassword newPassword, Model model) {
        IResetPasswordDao resetPasswordDao = ResetPasswordDaoFactory.instance().resetPasswordDao();
        IResetPasswordManager resetPasswordManager = ResetPasswordModelsFactory.instance().resetPasswordManager();
        IPasswordPolicy passwordPolicy = ResetPasswordModelsFactory.instance().passwordPolicy();

        if (passwordPolicy.isValid(newPassword.getPassword())) {
            if (passwordPolicy.getHistoryConstraint().equals("true")) {
                IPasswordHistoryManager passwordHistoryManager = ResetPasswordDaoFactory.instance().passwordHistoryManager();
                if (passwordHistoryManager.passwordExists(newPassword.getBannerID(), newPassword.getPassword())) {
                    model.addAttribute("error",
                            "New password cannot be same as current or last" +
                                    passwordPolicy.getHistoricalPasswordLimit() +
                                    " old passwords.");
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
        } else {
            LOGGER.warn("The entered password doesn't follow the password policy. Redirecting to password reset form.");
            model.addAttribute("errorMessages", passwordPolicy.generateErrorMessage());
            model.addAttribute("newPassword", newPassword);
            return "resetPassword/resetPasswordForm";
        }
    }
}
