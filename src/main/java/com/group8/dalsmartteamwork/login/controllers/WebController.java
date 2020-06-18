package com.group8.dalsmartteamwork.login.controllers;

import com.group8.dalsmartteamwork.utils.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class WebController {

    public String username;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String displayLoginResult(@ModelAttribute("user") User user1) {
        return "login_success";
    }

    @GetMapping("/loginError")
    public String displayErrorPage() {
        return "loginError";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void dsiplayLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getSession().getAttribute("username"));
        request.getSession().invalidate();
        System.out.println(request.getSession().getAttribute("username"));
        response.sendRedirect("/");
    } 

    @GetMapping("guest")
    public String getGuestPage(HttpServletRequest request, Model model) {
        username = (String) request.getSession().getAttribute("username");
        model.addAttribute("user", username);
        return "guestPage";
    }
}