package com.group8.dalsmartteamwork.questionmanager.controller;

import java.security.Principal;
import java.util.List;
import com.group8.dalsmartteamwork.questionmanager.dao.QuestionManagerImp;
import com.group8.dalsmartteamwork.questionmanager.model.Question;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class QuestionManagerController {

    QuestionManagerImp questionManager = new QuestionManagerImp();
    String username;

    @GetMapping("/questionManager")
    public String getInstructor() {
        return "/questionManager";
    }

    @GetMapping("/sortQuestion")
    public String sortQuestions(Principal principal, Model model) {

        List<Question> sortedQuestionList = questionManager.getAllQuestion(principal.getName());
        model.addAttribute("list", sortedQuestionList);
        if (!model.containsAttribute("list")) {
            return "/questionManager";
        }

        return "/sortQuestion";
    }

    @GetMapping("/sortQuestionByTitle")
    public String sortQuestionsBasedOnTitle(Principal principal, Model model) {
        List<Question> sortedList = questionManager.sortQuestionsByTitle(principal.getName());
        model.addAttribute("list", sortedList);
        return "/sortQuestionByTitle";
    }

    @GetMapping("/sortQuestionByDate")
    public String sortQuestionsBasedOnDate(Principal principal, Model model) {
        List<Question> sortedList = questionManager.sortAllQuestionByDate(principal.getName());
        model.addAttribute("list", sortedList);
        return "/sortQuestionByDate";
    }

    @GetMapping("/listDeleteQuestions")
    public String listDeleteQuestion(Principal principal, Model model) {
        Question question = new Question();
        List<Question> sList = questionManager.displayListOfQuestions(principal.getName());
        model.addAttribute("list", sList);
        model.addAttribute("question", question);
        return "/listDeleteQuestions";
    }

    @RequestMapping(value = "/listDeleteQuestions", method = RequestMethod.POST)
    public String deleteQuestion(@ModelAttribute("question") Question question, Principal principal, Model model,
            RedirectAttributes redirectAttributes) {
        Boolean status = questionManager.deleteQuestion(principal.getName(), question.getQuestionID());
        if (status != true) {
            redirectAttributes.addFlashAttribute("message", "Failed to delete the question");
            return "redirect:/questionManager";
        }

        redirectAttributes.addFlashAttribute("message", "Successfully deleted the question!");
        return "redirect:/questionManager";

    }
}