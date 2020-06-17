package com.group8.dalsmartteamwork.admin.controllers;

import com.group8.dalsmartteamwork.admin.dao.CourseManagerDaoImpl;
import com.group8.dalsmartteamwork.admin.dao.ICourseManagerDao;
import com.group8.dalsmartteamwork.admin.dao.IUserManagerDao;
import com.group8.dalsmartteamwork.admin.dao.UserManagerDaoImpl;
import com.group8.dalsmartteamwork.admin.models.CourseManagerImpl;
import com.group8.dalsmartteamwork.admin.models.ICourseManager;
import com.group8.dalsmartteamwork.admin.models.IUserManager;
import com.group8.dalsmartteamwork.admin.models.UserManagerImpl;
import com.group8.dalsmartteamwork.course.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {
    private static IUserManager iUserManager;
    private static ICourseManager iCourseManager;

    @GetMapping(value = "/admin")
    public String viewAdminPage(Model model) {
        ICourseManagerDao iCourseManagerDao = new CourseManagerDaoImpl();
        iCourseManager = new CourseManagerImpl(iCourseManagerDao);

        model.addAttribute("courses", iCourseManager.getAllCourses());
        return "admin";
    }

    @GetMapping(value = "/create-course")
    public String viewCourseCreationPage(Model model) {
        IUserManagerDao iUserManagerDao = new UserManagerDaoImpl();
        iUserManager = new UserManagerImpl(iUserManagerDao);

        model.addAttribute(new Course());
        List<String> listOfGuestsOrInstructors = iUserManager.getUsersWhoAreGuestsOrInstructors("");
        model.addAttribute("listOfInstructors", listOfGuestsOrInstructors);
        return "add-course";
    }

    @PostMapping(value = "/create-course")
    public String createCourse(@ModelAttribute Course course, Model model) {
        IUserManagerDao iUserManagerDao = new UserManagerDaoImpl();
        iUserManager = new UserManagerImpl(iUserManagerDao);

        if (iCourseManager.createNewCourse(course)) {
            model.addAttribute("courses", iCourseManager.getAllCourses());
            return "redirect:/admin";
        } else {
            return "add-course";
        }
    }

    @PostMapping(value = "/edit-course")
    public String viewEditCoursePage(String courseName, String originalCourseID, Model model) {
        IUserManagerDao iUserManagerDao = new UserManagerDaoImpl();
        iUserManager = new UserManagerImpl(iUserManagerDao);
        String instructorID = iUserManager.getCourseInstructor(originalCourseID);

        model.addAttribute("course", new Course(Integer.parseInt(originalCourseID), courseName, instructorID));
        List<String> listOfGuestsOrInstructors = iUserManager.getUsersWhoAreGuestsOrInstructors(originalCourseID);
        model.addAttribute("listOfInstructors", listOfGuestsOrInstructors);
        return "edit-course";
    }

    @PostMapping(value = "/update-course")
    public String editCourse(String courseName, String courseID, String instructorID, String originalCourseID, Model model) {
        IUserManagerDao iUserManagerDao = new UserManagerDaoImpl();
        iUserManager = new UserManagerImpl(iUserManagerDao);

        iCourseManager.updateCourse(courseName, Integer.parseInt(courseID), instructorID, Integer.parseInt(originalCourseID));
        model.addAttribute("courses", iCourseManager.getAllCourses());
        return "redirect:/admin";
    }

    @PostMapping(value = "/delete-course")
    public String deleteCourse(String courseID, Model model) {
        IUserManagerDao iUserManagerDao = new UserManagerDaoImpl();
        iUserManager = new UserManagerImpl(iUserManagerDao);

        iCourseManager.deleteCourse(courseID);
        model.addAttribute("courses", iCourseManager.getAllCourses());
        return "redirect:/admin";
    }
}
