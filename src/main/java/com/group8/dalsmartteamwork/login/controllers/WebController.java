package com.group8.dalsmartteamwork.login.controllers;

import com.group8.dalsmartteamwork.utils.User;
import com.group8.dalsmartteamwork.utils.Encryption;

import org.springframework.stereotype.Controller;
import com.group8.dalsmartteamwork.login.dao.LoginImplementation;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller  
public class WebController {

    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping(value = "/login")
    public String logindetails(@ModelAttribute User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "login";
        }
        
        LoginImplementation loginImplementation = new LoginImplementation();
        Encryption encryption = new Encryption();
        String encryptedPassword = encryption.encrypt(user.getPassword());
        Boolean status = loginImplementation.getUserDetails(user.getId(), user.getName(), user.getEmail(),encryptedPassword);
        if(status) {
            return "login_success";
        }
        return "frontpage";
    }

}

