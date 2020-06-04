package com.group8.dalsmartteamwork.courseinstructor.controllers;

import com.group8.dalsmartteamwork.course.dao.CourseDaoImpl;
import com.group8.dalsmartteamwork.utils.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InstructorController {

    @GetMapping("/viewcourse/{courseid}")
    public String view(@PathVariable int courseid, Model model) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        if (courseDao.courseExists(courseid)) {
            List<User> currentTAList = courseDao.getCurrentTAs(courseid);
            List<User> currentStudentList = courseDao.getCurrentTAs(courseid);
            model.addAttribute("course", courseid);
            model.addAttribute("currentTAList", currentTAList);
            model.addAttribute("currentStudentList", currentStudentList);
            return "instructorCourseHome";
        }
        return "badrequest";
    }

    //    @PostMapping("/add-ta/{courseid}")
    @PostMapping("/add-ta")
    public String addTA(@RequestParam(name = "courseid") int courseid, Model model) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        List<User> users = new ArrayList<>();
        users = courseDao.getUsersForTA(courseid);
        model.addAttribute("users", users);
        model.addAttribute("courseid", courseid);
        return "addTA";
    }

    @GetMapping("/confirm-add-ta")
    public String confirmAddTA(@RequestParam(name = "courseid") int courseID, @RequestParam(name = "bannerid") String bannerID, Model model) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        if (courseDao.addTAtoCourse(bannerID, courseID)) {
            model.addAttribute("courseid", courseID);
            return "successAddTA";
        }
        return "badrequest";
    }
}
