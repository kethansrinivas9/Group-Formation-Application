package com.group8.dalsmartteamwork.admin.controllers;

import com.group8.dalsmartteamwork.admin.dao.CourseManagerDaoImpl;
import com.group8.dalsmartteamwork.admin.dao.ICourseManagerDao;
import com.group8.dalsmartteamwork.admin.dao.IUserManagerDao;
import com.group8.dalsmartteamwork.admin.dao.UserManagerDaoImpl;
import com.group8.dalsmartteamwork.admin.models.*;
import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.course.CourseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourseController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/create-course")
    public String viewCourseCreationPage(Model model) {
        IUserManager iUserManager = AdminModelsFactory.instance().userManager();

        model.addAttribute(CourseFactory.instance().course());
        List<String> listOfGuestsOrInstructors = iUserManager.getUsersWhoAreGuestsOrInstructors("");
        model.addAttribute("listOfInstructors", listOfGuestsOrInstructors);
        return "add-course";
    }

    @PostMapping(value = "/create-course")
    public String createCourse(@ModelAttribute Course course, Model model) {
        ICourseManager iCourseManager = AdminModelsFactory.instance().courseManager();

        if (iCourseManager.createNewCourse(course)) {
            model.addAttribute("courses", iCourseManager.getAllCourses());
            return "redirect:/admin";
        } else {
            LOGGER.warn("Failed to add course. Redirected to add course page");
            return "add-course";
        }
    }

    @PostMapping(value = "/edit-course")
    public String viewEditCoursePage(String courseName, String originalCourseID, Model model) {
        IUserManager iUserManager = AdminModelsFactory.instance().userManager();
        String instructorID = iUserManager.getCourseInstructor(originalCourseID);

        model.addAttribute("course", new Course(Integer.parseInt(originalCourseID), courseName, instructorID));
        List<String> listOfGuestsOrInstructors = iUserManager.getUsersWhoAreGuestsOrInstructors(originalCourseID);
        model.addAttribute("listOfInstructors", listOfGuestsOrInstructors);
        return "edit-course";
    }

    @PostMapping(value = "/update-course")
    public String editCourse(String courseName, String courseID, String instructorID, String originalCourseID, Model model) {
        ICourseManagerDao iCourseManagerDao = new CourseManagerDaoImpl();
        ICourseManager iCourseManager = AdminModelsFactory.instance().courseManager();

        iCourseManager.updateCourse(courseName, Integer.parseInt(courseID), instructorID, Integer.parseInt(originalCourseID));
        model.addAttribute("courses", iCourseManager.getAllCourses());
        return "redirect:/admin";
    }

    @PostMapping(value = "/delete-course")
    public String deleteCourse(String courseID, Model model) {
        ICourseManager iCourseManager = AdminModelsFactory.instance().courseManager();

        iCourseManager.deleteCourse(courseID);
        model.addAttribute("courses", iCourseManager.getAllCourses());
        return "redirect:/admin";
    }
}
