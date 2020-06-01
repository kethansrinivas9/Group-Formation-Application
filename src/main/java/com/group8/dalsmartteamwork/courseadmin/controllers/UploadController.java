package com.group8.dalsmartteamwork.courseadmin.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.group8.dalsmartteamwork.courseadmin.dao.VerifyRegistrationImpl;
import com.group8.dalsmartteamwork.courseadmin.models.Pair;
import com.group8.dalsmartteamwork.utils.CsvReader;
import com.group8.dalsmartteamwork.utils.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {

    @GetMapping(value = "/courseadmin")
    public String getCourseAdminPage() {
        return "courseadmin";
    }

    @PostMapping(value = "/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes, Model model) {
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/courseadmin";
        }

        String fileName = file.getOriginalFilename();

        try {
            CsvReader csvReader = new CsvReader(file.getInputStream());
            List<User> users = csvReader.getUsers();
            VerifyRegistrationImpl vri = new VerifyRegistrationImpl();
            List<Boolean> status = vri.verifyRegistration(users);
            List<Pair<User, Boolean>> details = new ArrayList<Pair<User, Boolean>>();
            for (int i = 0; i < users.size(); i++) {
                Pair<User, Boolean> temp = new Pair<User, Boolean>(users.get(i), status.get(i));
                details.add(temp);
            }
            model.addAttribute("details", details);
            // model.addAttribute("users", users);
            model.addAttribute("message", String.format("Num Users: %d", users.size()));
            return "courseadmin";

        } catch (IOException e) {
            e.printStackTrace();
        }

        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        return "redirect:/courseadmin";

    }

}