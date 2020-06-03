package com.group8.dalsmartteamwork.register.controllers;

import javax.validation.Valid;

import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.register.services.RegistrationServiceImpl;
import com.group8.dalsmartteamwork.utils.Encryption;
import com.group8.dalsmartteamwork.utils.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @GetMapping(value = "/register")
    public String viewRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/register")
    public String submitDetails(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        RegistrationServiceImpl service = new RegistrationServiceImpl();
        Boolean status = service.registerUser(user);
        if (status) {
            return "success";
        }
        System.out.println("Registration Failed");
        return "register";
    }

}