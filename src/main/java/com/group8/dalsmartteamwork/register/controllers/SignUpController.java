package com.group8.dalsmartteamwork.register.controllers;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.register.models.IRegistrationFactory;
import com.group8.dalsmartteamwork.register.models.IRegistrationModel;
import com.group8.dalsmartteamwork.register.models.RegistrationFactoryImpl;
import com.group8.dalsmartteamwork.register.models.RegistrationModelImpl;
import com.group8.dalsmartteamwork.resetpassword.models.IPasswordPolicy;
import com.group8.dalsmartteamwork.resetpassword.models.PasswordPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/register")
    public String viewRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/register")
    public String submitDetails(User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            LOGGER.warn("Binding result has errors (Registration details). Redirecting to registration page.");
            return "register";
        }

        IPasswordPolicy passwordPolicy = new PasswordPolicy();
        if (passwordPolicy.isValid(user.getPassword())) {
            LOGGER.info("Entered password for registration is valid for user with BannerID: " + user.getId());
        } else {
            LOGGER.warn("The entered password violates the password policy.");
            model.addAttribute("errorMessages", passwordPolicy.generateErrorMessage());
            model.addAttribute("user", new User());
            return "register";
        }

        IRegistrationFactory iRegistrationFactory = new RegistrationFactoryImpl();
        IRegistrationModel service = new RegistrationModelImpl(iRegistrationFactory);
        Boolean status = service.registerUser(user);
        if (status) {
            LOGGER.info("Registration successful. BannerID: " + user.getId());
            return "login";
        }
        model.addAttribute("message", "Registration failed. User already exists");
        LOGGER.warn("Registration failed. Reason: User already exists. BannerID: " + user.getId());
        return "register";
    }

}