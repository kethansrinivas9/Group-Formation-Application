package com.group8.dalsmartteamwork.courseadmin.controllers;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.courseadmin.Pair;
import com.group8.dalsmartteamwork.courseadmin.models.*;
import com.group8.dalsmartteamwork.register.models.IRegistrationBuilder;
import com.group8.dalsmartteamwork.register.models.RegistrationBuilderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UploadController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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
            LOGGER.warn("Empty CSV file imported");
            return "import-students";
        }
        try {
            String fileName = file.getOriginalFilename();
            ICsvReader csvReader = new CsvReader(file);
            IRegistrationBuilder iRegistrationBuilder = new RegistrationBuilderImpl();
            IStudentEnrollmentBuilder iStudentEnrollmentBuilder = new StudentEnrollmentBuilderImpl();
            IStudentImportManager iStudentImportManager = new StudentImportManagerImpl(courseId, iRegistrationBuilder, iStudentEnrollmentBuilder);

            ICsvParser iCsvParser = new CsvParserImpl(csvReader);
            List<User> users = iCsvParser.getUsers();

            IMakePairService iMakePairService = new MakePairServiceImpl();
            List<Boolean> status = iStudentImportManager.verifyRegistration(users);

            List<Pair<User, Boolean>> details = iMakePairService.getUserDetails(users, status);

            model.addAttribute("courseId", courseId);
            model.addAttribute("details", details);
            model.addAttribute("message", String.format("Successfully uploaded file: %s", fileName));
            return "import-students";

        } catch (Exception e) {
            LOGGER.error("Exception occurred while uploading CSV file for student import.", e);
            return "courseadmin";
        }
    }

}