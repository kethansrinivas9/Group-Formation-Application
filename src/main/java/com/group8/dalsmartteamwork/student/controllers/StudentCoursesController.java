package com.group8.dalsmartteamwork.student.controllers;

import com.group8.dalsmartteamwork.accesscontrol.CurrentUser;
import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.student.Answer;
import com.group8.dalsmartteamwork.student.IQuestionDetails;
import com.group8.dalsmartteamwork.student.dao.IStudentDao;
import com.group8.dalsmartteamwork.student.dao.ISurveyManagerDao;
import com.group8.dalsmartteamwork.student.dao.StudentDaoImpl;
import com.group8.dalsmartteamwork.student.Student;
import com.group8.dalsmartteamwork.student.dao.SurveyManagerDaoImpl;
import com.group8.dalsmartteamwork.student.models.IResponseHandler;
import com.group8.dalsmartteamwork.student.models.ISurveyHandler;
import com.group8.dalsmartteamwork.student.models.ResponseHandler;
import com.group8.dalsmartteamwork.student.models.SurveyHandlerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentCoursesController {

    @GetMapping(value = "/student")
    public String getStudentEnrolledCoursesPage(Model model) {
        IStudentDao coursePage = new StudentDaoImpl();
        ArrayList<Student> courseList = coursePage.displayCourses();
        model.addAttribute("courses", courseList);
        return "student";
    }

    @GetMapping(value = "/student-course")
    public String getCoursePage(@RequestParam(name = "courseId") int courseId, Model model){
        ISurveyManagerDao iSurveyManagerDao = new SurveyManagerDaoImpl();
        ISurveyHandler iSurveyHandler = new SurveyHandlerImpl(iSurveyManagerDao);
        Map<IQuestionDetails, List<IOption>> questions = iSurveyHandler.getQuestions(courseId);
        Answer answer = Answer.getInstance();
        answer.setQuestions(questions);
        model.addAttribute("answer", answer);
        model.addAttribute("questions", questions);
        model.addAttribute("courseId", courseId);
        model.addAttribute("bannerId", CurrentUser.getInstance().getBannerId());
        return "student-course";
    }

    @PostMapping(value = "/submit-survey")
    public String saveSurveyResponses(HttpServletRequest request, Model model){
        IResponseHandler iResponseHandler = new ResponseHandler();
        Answer answer = Answer.getInstance();
        iResponseHandler.getResponses(request, answer.getQuestions());
        Map<Integer, String> answers = answer.getAnswers();
        ISurveyManagerDao iSurveyManagerDao = new SurveyManagerDaoImpl();
        ISurveyHandler iSurveyHandler = new SurveyHandlerImpl(iSurveyManagerDao);
        String bannerId = CurrentUser.getInstance().getBannerId();
        iSurveyHandler.saveResponses(answers, bannerId);

        IStudentDao iStudentDao = new StudentDaoImpl();
        ArrayList<Student> courseList = iStudentDao.displayCourses();
        model.addAttribute("courses", courseList);
        return "student";
    }
}