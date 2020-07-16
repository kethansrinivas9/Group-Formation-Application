package com.group8.dalsmartteamwork.groups.controllers;

import com.group8.dalsmartteamwork.accesscontrol.CurrentUser;
import com.group8.dalsmartteamwork.groups.IGroup;
import com.group8.dalsmartteamwork.groups.dao.GroupRetrieverDaoImpl;
import com.group8.dalsmartteamwork.groups.dao.GroupsDaoFactory;
import com.group8.dalsmartteamwork.groups.dao.IGroupRetrieverDao;
import com.group8.dalsmartteamwork.groups.models.GroupDisplayManagerImpl;
import com.group8.dalsmartteamwork.groups.models.GroupsModelsFactory;
import com.group8.dalsmartteamwork.groups.models.IGroupDisplayManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GroupDisplayController {

    @GetMapping(value = "/instructor-courses")
    public String getInstructorCourses(Model model){
        IGroupDisplayManager iGroupDisplayManager = GroupsModelsFactory.instance().groupDisplayManager();
        String bannerId = CurrentUser.getInstance().getBannerId();
        List<Integer> courses = iGroupDisplayManager.getInstructorCourses(bannerId);
        model.addAttribute("courses", courses);
        return "course-groups";
    }

    @PostMapping(value = "/course-groups")
    public String getCourseGroups(HttpServletRequest request, Model model){
        IGroupDisplayManager iGroupDisplayManager = GroupsModelsFactory.instance().groupDisplayManager();
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String bannerId = CurrentUser.getInstance().getBannerId();
        List<IGroup> groups = iGroupDisplayManager.getGroups(courseId);
        List<Integer> courses = iGroupDisplayManager.getInstructorCourses(bannerId);
        model.addAttribute("courses", courses);
        model.addAttribute("groups", groups);
        return "course-groups";
    }
}
