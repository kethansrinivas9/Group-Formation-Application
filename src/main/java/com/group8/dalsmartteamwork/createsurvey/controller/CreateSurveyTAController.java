package com.group8.dalsmartteamwork.createsurvey.controller;

import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyDao;
import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyDaoImpl;
import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyTADao;
import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyTADaoImpl;
import com.group8.dalsmartteamwork.createsurvey.model.CreateSurvey;
import com.group8.dalsmartteamwork.createsurvey.model.CreateSurveyImpl;
import com.group8.dalsmartteamwork.createsurvey.model.CreateSurveyTA;
import com.group8.dalsmartteamwork.createsurvey.model.CreateSurveyTAImpl;
import com.group8.dalsmartteamwork.questions.Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        CreateSurveyDao createSurveyDao = new CreateSurveyDaoImpl();
        CreateSurvey createSurvey = new CreateSurveyImpl(createSurveyDao);
        List<Course> courses = createSurvey.displayListOfCourses(principal.getName());
        model.addAttribute("list", courses);
        model.addAttribute(new Course());
        return "createSurveyPageTA";
    }

    @RequestMapping(value = "/createSurveyPageTA", method = RequestMethod.POST)
    public String deleteQuestion(@ModelAttribute("course") Course course, Principal principal, Model model,
                                 RedirectAttributes redirectAttributes) {
        CreateSurveyDao createSurveyDao = new CreateSurveyDaoImpl();
        CreateSurvey createSurvey = new CreateSurveyImpl(createSurveyDao);
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
        CreateSurveyTADao createSurveyTaDao = new CreateSurveyTADaoImpl();
        CreateSurveyTA createSurveyTa = new CreateSurveyTAImpl(createSurveyTaDao);
        Question question = new Question();
        questions = createSurveyTa.displayQuestionsTA(principal.getName(), courseID);
        model.addAttribute("list", questions);
        model.addAttribute("question", question);
        return "surveyPageTA";
    }

    @RequestMapping(value = "/surveyPageTA", method = RequestMethod.POST)
    public String saveQuestions(@RequestParam("question") List<Integer> values, Principal principal, Model model,
                                RedirectAttributes redirectAttributes) {
        CreateSurveyDaoImpl createSurveyDaoImpl = new CreateSurveyDaoImpl();
        Boolean status = createSurveyDaoImpl.saveQuestions(courseID, values);
        if (status != true) {
            redirectAttributes.addFlashAttribute("message", "Questions couldn't be added");
            return "redirect:/TApage";
        }
        redirectAttributes.addFlashAttribute("message", "Questions saved");
        return "redirect:/TApage";
    }

}