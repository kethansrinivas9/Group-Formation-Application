package com.group8.dalsmartteamwork.questions.controllers;

import com.group8.dalsmartteamwork.questions.Option;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateQuestionController {
    List<Option> options = new ArrayList<>();

    @GetMapping("/create-question")
    public ModelAndView getQuestionPage(){
        ModelAndView modelAndView = new ModelAndView("create-question");
        modelAndView.addObject("component", 0);
        return modelAndView;
    }

    @PostMapping("/create-question-2")
    public String getAnswerPage(@RequestParam("title") String title, @RequestParam("question") String question,
                                @RequestParam("type") String type, Model model){
        System.out.println("in Controller"+title+question+type);
        System.out.println(options.size());
        switch (type){
            case "numeric":
                model.addAttribute("component", 1);
                break;
            case "mc-one":
                options.add(new Option("", 1));
                model.addAttribute("options", options);
                model.addAttribute("component", 2);
                break;
            case "mc-multiple":
                model.addAttribute("component", 3);
                break;
            default:
                model.addAttribute("component", 4);
        }
        model.addAttribute("question", question);
        return "create-question";
    }



}
