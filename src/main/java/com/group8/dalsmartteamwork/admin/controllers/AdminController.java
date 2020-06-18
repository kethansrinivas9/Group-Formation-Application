package com.group8.dalsmartteamwork.admin.controllers;

import com.group8.dalsmartteamwork.admin.dao.CourseManagerDaoImpl;
import com.group8.dalsmartteamwork.admin.dao.ICourseManagerDao;
import com.group8.dalsmartteamwork.admin.models.CourseManagerImpl;
import com.group8.dalsmartteamwork.admin.models.ICourseManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping(value = "/admin")
    public String viewAdminPage(Model model) {
        ICourseManagerDao iCourseManagerDao = new CourseManagerDaoImpl();
        ICourseManager iCourseManager = new CourseManagerImpl(iCourseManagerDao);

        model.addAttribute("courses", iCourseManager.getAllCourses());
        return "admin";
    }
}
