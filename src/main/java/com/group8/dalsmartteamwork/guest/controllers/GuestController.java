package com.group8.dalsmartteamwork.guest.controllers;

import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.guest.Dao.GuestDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GuestController {

    @GetMapping("/viewallcourses")
    public String viewAllCourses(Model model) {
        List<Course> courses;
        GuestDaoImpl guestDao = new GuestDaoImpl();
        int courseID = 0;
        courses = guestDao.getCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("courseID", courseID);
        return "viewCourses";
    }
}
