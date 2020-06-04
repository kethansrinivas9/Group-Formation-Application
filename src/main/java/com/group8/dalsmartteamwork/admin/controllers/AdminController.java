package com.group8.dalsmartteamwork.admin.controllers;

import com.group8.dalsmartteamwork.admin.service.AdminService;
import com.group8.dalsmartteamwork.admin.service.AdminServiceImpl;
import com.group8.dalsmartteamwork.course.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {
    private static final AdminService adminService = new AdminServiceImpl();

    @GetMapping(value = "/admin")
    public String viewAdminPage(Model model) {
        model.addAttribute("courses", adminService.getAllCourses());
        return "admin";
    }

    @GetMapping(value = "/create-course")
    public String viewCourseCreationPage(Model model) {
        model.addAttribute(new Course());
        return "add-course";
    }

    @PostMapping(value = "/create-course")
    public String createCourse(@ModelAttribute Course course, Model model) {
        if (adminService.createNewCourse(course)) {
            model.addAttribute("courses", adminService.getAllCourses());
            return "redirect:/admin";
        } else {
            return "/add-course";
        }
    }

    @PostMapping(value = "/edit-course")
    public String viewEditCoursePage(String courseName, String originalCourseID, Model model) {
        List<String> nonAdminUsers = adminService.getListOfNonAdminUsers();
        model.addAttribute("course", new Course(Integer.parseInt(originalCourseID), courseName));
        model.addAttribute("users", nonAdminUsers);
        return "/edit-course";
    }

    @PostMapping(value = "/update-course")
    public String editCourse(String courseName, String courseID, String originalCourseID, Model model) {
        adminService.updateCourse(courseName, Integer.parseInt(courseID), Integer.parseInt(originalCourseID));
        model.addAttribute("courses", adminService.getAllCourses());
        return "redirect:/admin";
    }

    @PostMapping(value = "/delete-course")
    public String deleteCourse(String courseID, Model model) {
        adminService.deleteCourse(courseID);
        model.addAttribute("courses", adminService.getAllCourses());
        return "redirect:/admin";
    }
}
