package com.group8.dalsmartteamwork.register.controllers;

import javax.validation.Valid;

import com.group8.dalsmartteamwork.register.dao.RegisterDaoImpl;
import com.group8.dalsmartteamwork.register.models.User;
import com.group8.dalsmartteamwork.utils.Encryption;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @GetMapping(value = "/register")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/register")
    public String submitDetails(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        RegisterDaoImpl register = new RegisterDaoImpl();
        Encryption encryption = new Encryption();
        String encrypted_password = encryption.encrypt(user.getPassword());
        Boolean status = register.setUserDetails(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                encrypted_password);
        if (status) {
            return "success";
        }
        System.out.println("Signup Failed");
        return null;
    }

}