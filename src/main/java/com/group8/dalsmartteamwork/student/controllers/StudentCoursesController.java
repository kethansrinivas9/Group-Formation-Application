package com.group8.dalsmartteamwork.student.controllers;

import com.group8.dalsmartteamwork.accesscontrol.CurrentUser;
import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.student.Answer;
import com.group8.dalsmartteamwork.student.IQuestionDetails;
import com.group8.dalsmartteamwork.student.IStudent;
import com.group8.dalsmartteamwork.student.Student;
import com.group8.dalsmartteamwork.student.dao.*;
import com.group8.dalsmartteamwork.student.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class StudentCoursesController {

    @GetMapping(value = "/student")
    public String getStudentEnrolledCoursesPage(Model model) {
        IStudentDao coursePage = StudentDaoFactory.instance().studentDao();
        ArrayList<IStudent> courseList = coursePage.displayCourses();
        model.addAttribute("courses", courseList);
        return "student";
    }

    @GetMapping(value = "/student-course")
    public String getCoursePage(@RequestParam(name = "courseId") int courseId, Model model) {
        ISurveyManagerDao iSurveyManagerDao = StudentDaoFactory.instance().surveyManagerDao();
        ISurveyHandler iSurveyHandler = StudentModelsFactory.instance().surveyHandler();
        Map<IQuestionDetails, List<IOption>> questions = iSurveyHandler.getQuestions(courseId);
        Boolean status = iSurveyHandler.getSurveyPublishStatus(courseId);
        Answer answer = Answer.getInstance();
        answer.setQuestions(questions);
        answer.setCourseId(courseId);
        model.addAttribute("status", status);
        model.addAttribute("answer", answer);
        model.addAttribute("questions", questions);
        model.addAttribute("courseId", courseId);
        model.addAttribute("bannerId", CurrentUser.getInstance().getBannerId());
        return "student-course";
    }

    @PostMapping(value = "/submit-survey")
    public String saveSurveyResponses(HttpServletRequest request, Model model) {
        IResponseFactory iResponseFactory = StudentModelsFactory.instance().responseFactory();
        IResponseHandler iResponseHandler = StudentModelsFactory.instance().responseHandler();
        Answer answer = Answer.getInstance();
        iResponseHandler.getResponses(request, answer.getQuestions());
        Map<Integer, List<String>> answers = answer.getAnswers();
        ISurveyManagerDao iSurveyManagerDao = StudentDaoFactory.instance().surveyManagerDao();
        ISurveyHandler iSurveyHandler = StudentModelsFactory.instance().surveyHandler();
        String bannerId = CurrentUser.getInstance().getBannerId();
        int courseId = answer.getCourseId();
        Boolean surveyStatus = iSurveyHandler.saveResponses(answers, bannerId, courseId);
        model.addAttribute("surveyStatus", surveyStatus);

        IStudentDao iStudentDao = new StudentDaoImpl();
        ArrayList<IStudent> courseList = iStudentDao.displayCourses();
        model.addAttribute("courses", courseList);
        return "student";
    }
}