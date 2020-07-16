package com.group8.dalsmartteamwork.course.controllers;

import com.group8.dalsmartteamwork.course.dao.CourseDaoImpl;
import com.group8.dalsmartteamwork.course.dao.ICourseDao;
import com.group8.dalsmartteamwork.course.models.CourseInstructorManagerImpl;
import com.group8.dalsmartteamwork.course.models.ICourseInstructorManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InstructorController {
    @GetMapping("/instructor")
    public String getInstructor() {
        return "instructor";
    }

    @GetMapping("/TApage")
    public String getTA() {
        return "TApage";
    }

    @GetMapping("/viewcourse/{courseid}")
    public String view(@PathVariable int courseid, Model model) {
        ICourseDao courseDao = new CourseDaoImpl();
        ICourseInstructorManager courseInstructorManager = new CourseInstructorManagerImpl(courseDao);
        if (courseInstructorManager.courseExists(courseid)) {
            model.addAttribute("course", courseid);
            model.addAttribute("currentTAList", courseInstructorManager.getCurrentTAs(courseid));
            model.addAttribute("currentStudentList", courseInstructorManager.getCurrentStudents(courseid));
            return "instructorCourseHome";
        }
        return "badrequest";
    }

    @PostMapping("/add-ta")
    public String addTA(@RequestParam(name = "courseid") int courseid, Model model) {
        ICourseDao courseDao = new CourseDaoImpl();
        ICourseInstructorManager courseInstructorManager = new CourseInstructorManagerImpl(courseDao);
        model.addAttribute("users", courseInstructorManager.getEligibleTAs(courseid));
        model.addAttribute("courseid", courseid);
        return "addTA";
    }

    @GetMapping("/confirm-add-ta")
    public String confirmAddTA(@RequestParam(name = "courseid") int courseID,
                               @RequestParam(name = "bannerid") String bannerID, Model model) {
        ICourseDao courseDao = new CourseDaoImpl();
        ICourseInstructorManager courseInstructorManager = new CourseInstructorManagerImpl(courseDao);
        if (courseInstructorManager.addTAtoCourse(bannerID, courseID)) {
            model.addAttribute("courseid", courseID);
            return "successAddTA";
        }
        return "badrequest";
    }
}
