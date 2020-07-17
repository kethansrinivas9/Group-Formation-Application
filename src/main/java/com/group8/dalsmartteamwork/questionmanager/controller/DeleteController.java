package com.group8.dalsmartteamwork.questionmanager.controller;

import com.group8.dalsmartteamwork.questionmanager.dao.DeleteDao;
import com.group8.dalsmartteamwork.questionmanager.dao.DeleteDaoImpl;
import com.group8.dalsmartteamwork.questionmanager.model.Delete;
import com.group8.dalsmartteamwork.questionmanager.model.DeleteImpl;
import com.group8.dalsmartteamwork.questions.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class DeleteController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/listDeleteQuestions")
    public String listDeleteQuestion(Principal principal, Model model) {
        DeleteDao deleteDao = new DeleteDaoImpl();
        Delete delete = new DeleteImpl(deleteDao);
        List<Question> sList = delete.displayListOfQuestions(principal.getName());
        model.addAttribute("list", sList);
        model.addAttribute(new Question());
        return "listDeleteQuestions";
    }

    @RequestMapping(value = "/listDeleteQuestions", method = RequestMethod.POST)
    public String deleteQuestion(@ModelAttribute("question") Question question, Principal principal, Model model,
                                 RedirectAttributes redirectAttributes) {
        DeleteDao deleteDao = new DeleteDaoImpl();
        Delete delete = new DeleteImpl(deleteDao);
        Boolean status = delete.deleteQuestion(question.getQuestionID());
        if (status) {
            LOGGER.info("Deleted the question with QuestionID: " + question.getQuestionID());
            redirectAttributes.addFlashAttribute("message", "Successfully deleted the question!");
        } else {
            LOGGER.info("Failed to delete the question with QuestionID: " + question.getQuestionID());
            redirectAttributes.addFlashAttribute("message", "Failed to delete the question");
        }
        return "redirect:/questionManager";
    }
}