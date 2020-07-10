package com.group8.dalsmartteamwork.courseadmin.controllers;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.courseadmin.Pair;
import com.group8.dalsmartteamwork.courseadmin.dao.IStudentEnrollmentDao;
import com.group8.dalsmartteamwork.courseadmin.dao.StudentEnrollmentDaoImpl;
import com.group8.dalsmartteamwork.courseadmin.models.*;
import com.group8.dalsmartteamwork.register.dao.RegistrationDao;
import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.resetpassword.models.Mail;
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
        if (file.isEmpty()) {
            model.addAttribute("courseId", courseId);
            model.addAttribute("message", "Please select a file to upload.");
            return "import-students";
        }
        try {
            String fileName = file.getOriginalFilename();
            ICsvReader csvReader = new CsvReader(file);
            Mail mail = new Mail();
            RegistrationDao registrationDao = new RegistrationDaoImpl();
            IStudentEnrollmentDao studentEnrollmentDao = new StudentEnrollmentDaoImpl();
            IStudentImportManager service = new StudentImportManagerImpl(courseId, registrationDao, studentEnrollmentDao, mail);
            ICsvParser iCsvParser = new CsvParserImpl(csvReader);
            MakePairService makePairService = new MakePairServiceImpl();
            List<User> users = iCsvParser.getUsers();
            List<Boolean> status = service.verifyRegistration(users);

            List<Pair<User, Boolean>> details = makePairService.getUserDetails(users, status);

            model.addAttribute("courseId", courseId);
            model.addAttribute("details", details);
            model.addAttribute("message", String.format("Successfully uploaded file: %s", fileName));
            return "import-students";

        } catch (Exception e) {
            e.printStackTrace();
            return "courseadmin";
        }
    }

}