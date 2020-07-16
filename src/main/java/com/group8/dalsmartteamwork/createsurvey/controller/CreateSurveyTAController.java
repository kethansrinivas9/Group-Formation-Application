package com.group8.dalsmartteamwork.createsurvey.controller;

import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.createsurvey.dao.*;
import com.group8.dalsmartteamwork.createsurvey.model.*;
import com.group8.dalsmartteamwork.questions.Question;
import com.group8.dalsmartteamwork.questions.QuestionsFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateSurveyTAController {
    public Integer courseID;
    public List<Question> questions = new ArrayList<Question>();

    @GetMapping("/createSurveyPageTA")
    public String listCourses(Principal principal, Model model) {
        CreateSurvey createSurvey = CreateSurveyModelFactory.instance().createSurvey();
        List<Course> courses = createSurvey.displayListOfCourses(principal.getName());
        model.addAttribute("list", courses);
        model.addAttribute(new Course());
        return "createSurveyPageTA";
    }

    @RequestMapping(value = "/createSurveyPageTA", method = RequestMethod.POST)
    public String deleteQuestion(@ModelAttribute("course") Course course, Principal principal, Model model,
            RedirectAttributes redirectAttributes) {
        CreateSurvey createSurvey = CreateSurveyModelFactory.instance().createSurvey();
        courseID = course.getCourseID();
        Boolean status = createSurvey.checkIfSurveyCreated(course.getCourseID());
        if (status != true) {
            redirectAttributes.addFlashAttribute("message", "Survey already exists");
            return "redirect:/TApage";
        }
        return "redirect:/surveyPageTA";
    }

    @GetMapping("/surveyPageTA")
    public String displaySurveyPageTA(Principal principal, Model model) {
        CreateSurveyTA createSurveyTa = CreateSurveyModelFactory.instance().createSurveyTA();
        Question question = QuestionsFactory.instance().question();
        questions = createSurveyTa.displayQuestionsTA(principal.getName(), courseID);
        model.addAttribute("list", questions);
        model.addAttribute("question", question);
        return "surveyPageTA";
    }

    @RequestMapping(value = "/surveyPageTA", method = RequestMethod.POST)
    public String saveQuestions(@RequestParam("question") List<Integer> values, Principal principal, Model model,
            RedirectAttributes redirectAttributes) {
        CreateSurveyDao createSurveyDaoImpl = CreateSurveyDaoFactory.instance().createSurveyDao();
        Boolean status = createSurveyDaoImpl.saveQuestions(courseID,values);
        if (status != true) {
            redirectAttributes.addFlashAttribute("message", "Questions couldn't be added");
            return "redirect:/TApage";
        }
        redirectAttributes.addFlashAttribute("message", "Questions saved");
        return "redirect:/TApage";
    }

}