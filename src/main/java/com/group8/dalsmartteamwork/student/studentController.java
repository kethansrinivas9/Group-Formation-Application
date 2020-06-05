package com.group8.dalsmartteamwork.student;

import com.group8.dalsmartteamwork.course.dao.CourseDaoImpl;
import com.group8.dalsmartteamwork.course.model.Course;
import com.group8.dalsmartteamwork.guest.Dao.GuestDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class studentController {
    @GetMapping("/viewstudentcourse/{courseid}")
    public String view(@PathVariable int courseid, Model model) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        if (courseDao.courseExists(courseid)) {
            String courseName = courseDao.getCourseName(courseid);
            model.addAttribute("coursename", courseName);
            return "studentCourseHome";
        }
        return "badrequest";
    }

    @GetMapping("/viewstudentcourses")
    public String viewAllCourszes(Model model) {
        List<Course> courses = new ArrayList<>();
        GuestDaoImpl guestDao = new GuestDaoImpl();
        int courseID = 0;
        courses = guestDao.getCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("courseID", courseID);
        return "viewStudentCourses";
    }
}
