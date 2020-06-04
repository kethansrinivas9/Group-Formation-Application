package com.group8.dalsmartteamwork.course.controller;

import java.util.ArrayList;

import com.group8.dalsmartteamwork.student.dao.StudentDaoImp;
import com.group8.dalsmartteamwork.student.model.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

    StudentDaoImp coursePage = new StudentDaoImp();

    @GetMapping(value = "/student")
    public String getStudentCourse(Model model) {
        ArrayList<Student> courseList = coursePage.displayCourses();
        model.addAttribute("courses", courseList);
        return "student";
    }
}