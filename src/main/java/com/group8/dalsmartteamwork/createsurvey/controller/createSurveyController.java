package com.group8.dalsmartteamwork.createsurvey.controller;

import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyDao;
import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyDaoImpl;
import com.group8.dalsmartteamwork.createsurvey.model.CreateSurvey;
import com.group8.dalsmartteamwork.createsurvey.model.CreateSurveyImpl;
import com.group8.dalsmartteamwork.questions.Question;
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
public class CreateSurveyController {
    public Integer courseID;
    public List<Question> questions = new ArrayList<Question>();

    @GetMapping("/createSurveyPage")
    public String listCourses(Principal principal, Model model) {
        CreateSurveyDao createSurveyDao = new CreateSurveyDaoImpl();
        CreateSurvey createSurvey = new CreateSurveyImpl(createSurveyDao);
        model.addAttribute(new Course());
        List<Course> courses = createSurvey.displayListOfCourses(principal.getName());
        model.addAttribute("list", courses);
        return "createSurveyPage";
    }

    @RequestMapping(value = "/createSurveyPage", method = RequestMethod.POST)
    public String deleteQuestion(@ModelAttribute("course") Course course, Principal principal, Model model,
            RedirectAttributes redirectAttributes) {
        CreateSurveyDao createSurveyDao = new CreateSurveyDaoImpl();
        CreateSurvey createSurvey = new CreateSurveyImpl(createSurveyDao);
        courseID = course.getCourseID();
        Boolean status = createSurvey.checkIfSurveyCreated(course.getCourseID());
        if (status != true) {
            redirectAttributes.addFlashAttribute("message", "Survey already exists");
            return "redirect:/questionManager";
        }
        return "redirect:/surveyPage";
    }

    @GetMapping("/surveyPage")
    public String displaySurveyPage(Principal principal, Model model) {
        CreateSurveyDao createSurveyDao = new CreateSurveyDaoImpl();
        CreateSurvey createSurvey = new CreateSurveyImpl(createSurveyDao);
        Question question = new Question();
        questions = createSurvey.displayQuestions(principal.getName(), courseID);
        model.addAttribute("list", questions);
        model.addAttribute("question", question);
        return "surveyPage";
    }

    @RequestMapping(value = "/surveyPage", method = RequestMethod.POST)
    public String publishSurvey(@RequestParam("question") List<Integer> values, Principal principal, Model model,
            RedirectAttributes redirectAttributes) {
        CreateSurveyDao createSurveyDao = new CreateSurveyDaoImpl();
        CreateSurvey createSurvey = new CreateSurveyImpl(createSurveyDao);
        Boolean status = createSurvey.addQuestionToSurvey(courseID, values);
        if (status != true) {
            redirectAttributes.addFlashAttribute("message", "Survey couldn't be added");
            return "redirect:/questionManager";
        }
        redirectAttributes.addFlashAttribute("message", "Survey published");
        return "redirect:/questionManager";
    }

}