package com.group8.dalsmartteamwork.course.controller;

import com.group8.dalsmartteamwork.student.Student;
import com.group8.dalsmartteamwork.student.dao.IStudentDao;
import com.group8.dalsmartteamwork.student.dao.StudentDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class StudentCoursesController {

    @GetMapping(value = "/student")
    public String getStudentCourse(Model model) {
        IStudentDao coursePage = new StudentDaoImpl();
        ArrayList<Student> courseList = coursePage.displayCourses();
        model.addAttribute("courses", courseList);
        return "student";
    }
}