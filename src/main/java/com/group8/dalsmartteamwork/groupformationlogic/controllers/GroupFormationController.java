package com.group8.dalsmartteamwork.groupformationlogic.controllers;

import com.group8.dalsmartteamwork.groupformationlogic.dao.GroupFormationHandlerDaoImpl;
import com.group8.dalsmartteamwork.groupformationlogic.dao.IGroupFormationHandlerDao;
import com.group8.dalsmartteamwork.groupformationlogic.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GroupFormationController {

    @GetMapping(value = "/groupformationpage")
    public String viewGroupFormationPage(Model model) {
        return "groupformationpage";
    }

    @PostMapping(value = "/savegroupformationrules")
    public String saveGroupFormationRules(HttpServletRequest request) {
        IGroupFormationHandlerDao iGroupFormationHandlerDao = new GroupFormationHandlerDaoImpl();
        IGroupFormationHandler iGroupFormationHandler = new GroupFormationHandler(iGroupFormationHandlerDao);

        iGroupFormationHandler.saveRules(request);

        return "redirect:/instructor";
    }

    @GetMapping(value = "/groupresponses")
    public String viewStudentsResponses() {
        IGroupFormationAlgorithm iGroupFormationAlgorithm = new GroupFormationAlgorithm();
        iGroupFormationAlgorithm.createGroups();

        return "redirect:/groupformationpage";
    }

}
