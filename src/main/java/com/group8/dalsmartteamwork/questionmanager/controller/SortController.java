package com.group8.dalsmartteamwork.questionmanager.controller;

import com.group8.dalsmartteamwork.questionmanager.dao.SortDao;
import com.group8.dalsmartteamwork.questionmanager.dao.SortDaoImpl;
import com.group8.dalsmartteamwork.questionmanager.model.Sort;
import com.group8.dalsmartteamwork.questionmanager.model.SortImpl;
import com.group8.dalsmartteamwork.questions.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class SortController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/questionManager")
    public String getInstructor() {
        return "questionManager";
    }

    @GetMapping("/sortQuestion")
    public String sortQuestions(Principal principal, Model model) {
        SortDao sortDao = new SortDaoImpl();
        Sort sort = new SortImpl(sortDao);
        List<Question> sortedQuestionList = sort.getAllQuestion(principal.getName());
        model.addAttribute("list", sortedQuestionList);
        if (model.containsAttribute("list")) {
            return "sortQuestion";
        } else {
            LOGGER.warn("Failed to sort questions.");
            return "questionManager";
        }
    }

    @GetMapping("/sortQuestionByTitle")
    public String sortQuestionsBasedOnTitle(Principal principal, Model model) {
        SortDao sortDao = new SortDaoImpl();
        Sort sort = new SortImpl(sortDao);
        List<Question> sortedList = sort.sortQuestionsByTitle(principal.getName());
        model.addAttribute("list", sortedList);
        return "sortQuestionByTitle";
    }

    @GetMapping("/sortQuestionByDate")
    public String sortQuestionsBasedOnDate(Principal principal, Model model) {
        SortDao sortDao = new SortDaoImpl();
        Sort sort = new SortImpl(sortDao);
        List<Question> sortedList = sort.sortAllQuestionByDate(principal.getName());
        model.addAttribute("list", sortedList);
        return "sortQuestionByDate";
    }
}