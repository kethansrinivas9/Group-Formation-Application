package com.group8.dalsmartteamwork.student.controllers;

import com.group8.dalsmartteamwork.accesscontrol.CurrentUser;
import com.group8.dalsmartteamwork.student.dao.IStudentDao;
import com.group8.dalsmartteamwork.student.dao.StudentDaoImpl;
import com.group8.dalsmartteamwork.student.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class StudentCoursesController {

    @GetMapping(value = "/student")
    public String getEnrolledCoursesPage(Model model) {
        IStudentDao coursePage = new StudentDaoImpl();
        ArrayList<Student> courseList = coursePage.displayCourses();
        model.addAttribute("courses", courseList);
        return "student";
    }

    @GetMapping(value = "/student-course")
    public String getCoursePage(@RequestParam(name = "courseId") int courseId, Model model){
        model.addAttribute("courseId", courseId);
        model.addAttribute("bannerId", CurrentUser.getInstance().getBannerId());
        return "student-course";
    }
}