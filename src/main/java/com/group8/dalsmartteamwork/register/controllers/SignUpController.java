package com.group8.dalsmartteamwork.register.controllers;

import com.group8.dalsmartteamwork.register.dao.RegisterDaoImpl;
import com.group8.dalsmartteamwork.register.models.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String submitDetails(@ModelAttribute User user) {
        RegisterDaoImpl register = new RegisterDaoImpl();
        Boolean status = register.setUserDetails(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getPassword());
        if (status) {
            return "success";
        }
        System.out.println("Signup Failed");
        return null;
    }

}