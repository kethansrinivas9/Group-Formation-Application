package com.group8.dalsmartteamwork.courseadmin.controllers;

import com.group8.dalsmartteamwork.courseadmin.models.Pair;
import com.group8.dalsmartteamwork.courseadmin.services.*;
import com.group8.dalsmartteamwork.register.dao.RegistrationDao;
import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.utils.CsvReader;
import com.group8.dalsmartteamwork.utils.ICsvReader;
import com.group8.dalsmartteamwork.utils.Mail;
import com.group8.dalsmartteamwork.utils.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UploadController {

    @PostMapping(value = "/import")
    public String getCourseAdminPage(@RequestParam(name = "course-id") int courseId, Model model) {
        model.addAttribute("courseId", courseId);
        return "import-students";
    }

    @PostMapping(value = "/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, int courseId, RedirectAttributes attributes, Model model) {
        System.out.println(courseId);
        if (file.isEmpty()) {
            model.addAttribute("courseId", courseId);
            model.addAttribute("message", "Please select a file to upload.");
            return "import-students";
        }
        try {
            String fileName = file.getOriginalFilename();
            ICsvReader csvReader = new CsvReader(file);
            Mail mail = new Mail();
            RegistrationDao dao = new RegistrationDaoImpl();
            ImportCsvService service = new ImportCsvServiceImpl(courseId, dao, mail);
            ParseCsvService parseCsvService = new ParseCsvServiceImpl(csvReader);
            MakePairService makePairService = new MakePairServiceImpl();
            List<User> users = parseCsvService.getUsers();
            List<Boolean> status = service.verifyRegistration(users);

            List<Pair<User, Boolean>> details = makePairService.getUserDetails(users, status);

            model.addAttribute("details", details);
            model.addAttribute("message", String.format("Successfully uploaded file: %s", fileName));
            return "import-students";

        } catch (Exception e) {
            e.printStackTrace();
            return "courseadmin";
        }
    }

}