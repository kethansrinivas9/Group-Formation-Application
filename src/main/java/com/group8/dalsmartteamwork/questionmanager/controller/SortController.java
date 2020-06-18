package com.group8.dalsmartteamwork.questionmanager.controller;

import java.security.Principal;
import java.util.List;
import com.group8.dalsmartteamwork.questionmanager.dao.SortDaoImp;
import com.group8.dalsmartteamwork.questions.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SortController {

    SortDaoImp sortDaoImp = new SortDaoImp();

    @GetMapping("/questionManager")
    public String getInstructor() {
        return "/questionManager";
    }

    @GetMapping("/sortQuestion")
    public String sortQuestions(Principal principal, Model model) {
        List<Question> sortedQuestionList = sortDaoImp.getAllQuestion(principal.getName());
        model.addAttribute("list", sortedQuestionList);
        if (!model.containsAttribute("list")) {
            return "/questionManager";
        }
        return "/sortQuestion";
    }

    @GetMapping("/sortQuestionByTitle")
    public String sortQuestionsBasedOnTitle(Principal principal, Model model) {
        List<Question> sortedList = sortDaoImp.sortQuestionsByTitle(principal.getName());
        model.addAttribute("list", sortedList);
        return "/sortQuestionByTitle";
    }

    @GetMapping("/sortQuestionByDate")
    public String sortQuestionsBasedOnDate(Principal principal, Model model) {
        List<Question> sortedList = sortDaoImp.sortAllQuestionByDate(principal.getName());
        model.addAttribute("list", sortedList);
        return "/sortQuestionByDate";
    }
}