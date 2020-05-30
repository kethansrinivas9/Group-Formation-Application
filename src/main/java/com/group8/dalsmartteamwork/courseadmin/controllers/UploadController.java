package com.group8.dalsmartteamwork.courseadmin.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UploadController {
    private final String DIR = "../uploads/";

    @GetMapping(value = "/courseadmin")
    public String getCourseAdminPage() {
        return "courseadmin";
    }

    @PostMapping(value = "/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/courseadmin";
        }
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            Path currentRelativePath = Paths.get("");
            String s = currentRelativePath.toAbsolutePath().toString();
            System.out.println("Path is " + s);
            File dir = new File(s);
            File uploadDir = new File(dir, "uploads");
            File actualFile = new File(uploadDir, fileName);
            file.transferTo(actualFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        return "redirect:/courseadmin";

    }

}