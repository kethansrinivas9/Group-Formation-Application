package com.group8.dalsmartteamwork.questionmanager.controller;

import java.security.Principal;
import java.util.List;

import com.group8.dalsmartteamwork.questionmanager.dao.DeleteDao;
import com.group8.dalsmartteamwork.questionmanager.dao.DeleteDaoImp;
import com.group8.dalsmartteamwork.questions.Question;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeleteController {

    @GetMapping("/listDeleteQuestions")
    public String listDeleteQuestion(Principal principal, Model model) {
        DeleteDao deleteDaoImp = new DeleteDaoImp();
        Question question = new Question();
        List<Question> sList = deleteDaoImp.displayListOfQuestions(principal.getName());
        model.addAttribute("list", sList);
        model.addAttribute("question", question);
        return "listDeleteQuestions";
    }

    @RequestMapping(value = "/listDeleteQuestions", method = RequestMethod.POST)
    public String deleteQuestion(@ModelAttribute("question") Question question, Principal principal, Model model,
            RedirectAttributes redirectAttributes) {
        DeleteDao deleteDaoImp = new DeleteDaoImp();
        Boolean status = deleteDaoImp.deleteQuestion(question.getQuestionID());
        if (status != true) {
            redirectAttributes.addFlashAttribute("message", "Failed to delete the question");
            return "redirect:/questionManager";
        }
        redirectAttributes.addFlashAttribute("message", "Successfully deleted the question!");
        return "redirect:/questionManager";

    }
}