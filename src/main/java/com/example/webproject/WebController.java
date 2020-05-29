package com.example.webproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
  

@Controller  
public class WebController {

/*
    @RequestMapping("/")  
    @ResponseBody  
    public String index() {  
        return "Success!";  
    }  

    @RequestMapping(value="/redirect", method = RequestMethod.GET)
    public String redirect()
    {
        return "redirect:frontpage";
    }
    //front page 
    @RequestMapping("/frontpage")
    public String frontPage()
    {
        return "frontpage";
    }

    //login form
    @RequestMapping("/login.html")
    public String login()
    {
        return "login.html";
    
    }

    //sign up form

    @RequestMapping("/signup")
    public String signup()
    {
        return "signup.html";
    }

    //login with error 
    @RequestMapping("/login-error.html")
    public String loginError(Model model)
    {
        model.addAttribute("loginError",true);
        return "login.html";
    }
    
    */

    @GetMapping(value="/login")
    public String login(Model model)
    {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping(value = "/login")
    public String logindetails(@ModelAttribute User user)
    {
        //user.setId(123456);
        LoginImplementation login_i = new LoginImplementation();
        Boolean status = login_i.getUserDetails(user.getId(), user.getName(), user.getEmail(), user.getPassword());
        if(status)
        {
            return "dummy";
        }
        return "frontpage";
    }

}

