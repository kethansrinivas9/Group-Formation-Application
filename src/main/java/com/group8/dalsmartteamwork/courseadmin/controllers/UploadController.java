package com.group8.dalsmartteamwork.courseadmin.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.group8.dalsmartteamwork.courseadmin.models.Pair;
import com.group8.dalsmartteamwork.courseadmin.services.ImportCsvService;
import com.group8.dalsmartteamwork.courseadmin.services.ImportCsvServiceImpl;
import com.group8.dalsmartteamwork.utils.CsvReader;
import com.group8.dalsmartteamwork.utils.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
            CsvReader csvReader = new CsvReader(file.getInputStream());
            List<User> users = csvReader.getUsers();
            List<Boolean> status;
            ImportCsvService service = new ImportCsvServiceImpl(courseId);
            status = service.verifyRegistration(users);
            List<Pair<User, Boolean>> details = new ArrayList<Pair<User, Boolean>>();
            for (int i = 0; i < users.size(); i++) {
                Pair<User, Boolean> temp = new Pair<User, Boolean>(users.get(i), status.get(i));
                details.add(temp);
            }
            model.addAttribute("details", details);
            model.addAttribute("message", String.format("Successfully uploaded file: %s", fileName));
            return "import-students";

        } catch (IOException e) {
            e.printStackTrace();
            return "courseadmin";
        }
    }

}