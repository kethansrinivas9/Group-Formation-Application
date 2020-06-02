package com.group8.dalsmartteamwork.login.controllers;

import com.group8.dalsmartteamwork.utils.User;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

    public String username;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginResult(@ModelAttribute("user") User user1) {
        return "login_success";
    }

    @GetMapping("/loginError")
    public String loginErrorPage() {
        return "loginError";
    }

    @GetMapping("student")
    public String getStudentPage(HttpServletRequest request, Model model) {
        String[] courses = (String[]) request.getSession().getAttribute("courses");
        int i = 0;
        try {
            while (courses[i] != null) {
                model.addAttribute("course", courses[i]);
                i++;
            }
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception");
        }
        return "student";
    }

    @GetMapping("admin")
    public String getAdminPage(HttpServletRequest request, Model model) {
        username = (String) request.getSession().getAttribute("username");
        model.addAttribute("user", username);
        return "admin";

    }

    @GetMapping("guest")
    public String getGuestPage(HttpServletRequest request, Model model) {
        username = (String) request.getSession().getAttribute("username");
        model.addAttribute("user", username);
        return "guest";

    }
}