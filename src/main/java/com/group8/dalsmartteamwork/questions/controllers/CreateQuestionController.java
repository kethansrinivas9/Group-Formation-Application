package com.group8.dalsmartteamwork.questions.controllers;

import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.questions.Question;
import com.group8.dalsmartteamwork.questions.dao.IQuestionDao;
import com.group8.dalsmartteamwork.questions.dao.QuestionDao;
import com.group8.dalsmartteamwork.questions.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CreateQuestionController {

    @GetMapping("/create-question")
    public ModelAndView getQuestionPage() {
        ModelAndView modelAndView = new ModelAndView("create-question");
        modelAndView.addObject("component", 0);
        return modelAndView;
    }

    @RequestMapping(value = "/question-details", method = RequestMethod.POST)
    public String getAnswerPage(@RequestParam("title") String title, @RequestParam("question") String text,
                                @RequestParam("type") String type, Model model) {
        Question question = Question.getInstance();
        IQuestionHandler handleQuestion = new QuestionHandler(question);
        handleQuestion.createQuestion(title, text, type);
        switch (type) {
            case "numeric":
                model.addAttribute("component", 1);
                break;
            case "mc-one":
                model.addAttribute("component", 2);
                break;
            case "mc-multiple":
                model.addAttribute("component", 3);
                break;
            default:
                model.addAttribute("component", 4);
        }
        model.addAttribute("question", text);
        return "create-question";
    }


    @RequestMapping(value = "/validate-question", method = RequestMethod.POST, params = "action=save")
    public String saveDetails(HttpServletRequest request, Model model) {
        List<Option> options;
        Question question = Question.getInstance();
        IQuestionOptionManager saveQuestionOptions;
        IOptionRetrieveManager parseRequest = new OptionRetrieveManager();
        IQuestionDao questionDao = new QuestionDao();
        int questionId;

        options = parseRequest.getOptions(request);
        saveQuestionOptions = new QuestionOptionManager(questionDao);
        questionId = saveQuestionOptions.saveQuestion(question);
        saveQuestionOptions.saveOptions(options, questionId);
        question.reset();
        model.addAttribute("component", 0);
        return "create-question";
    }

    @RequestMapping(value = "/validate-question", method = RequestMethod.POST, params = "action=cancel")
    public String cancelDetails(HttpServletRequest request, Model model) {
        Question question = Question.getInstance();
        IQuestionHandler handleQuestion = new QuestionHandler(question);
        handleQuestion.resetQuestion();
        model.addAttribute("component", 0);
        return "create-question";
    }

}
