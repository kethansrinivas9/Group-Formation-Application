package com.group8.dalsmartteamwork.login.controllers;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.student.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class WebController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public String username;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String displayLoginResult(@ModelAttribute("user") User user1) {
        LOGGER.info("User Logged in. BannerID: " + user1.getId());
        return "login_success";
    }

    @GetMapping("/loginError")
    public String displayErrorPage() {
        return "loginError";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void displayLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        Answer.getInstance().destroy();
        response.sendRedirect("/");
    }

    @GetMapping("guest")
    public String getGuestPage(HttpServletRequest request, Model model) {
        username = (String) request.getSession().getAttribute("username");
        model.addAttribute("user", username);
        return "guestPage";
    }
}