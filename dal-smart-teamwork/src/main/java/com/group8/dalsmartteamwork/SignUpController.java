package com.group8.dalsmartteamwork;

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
        user.setId(123456);
        RegisterDaoImpl register = new RegisterDaoImpl();
        Boolean status = register.setUserDetails(user.getId(), user.getName(), user.getEmail(), user.getPassword());
        if (status) {
            return "success";
        }
        return null;
    }

}