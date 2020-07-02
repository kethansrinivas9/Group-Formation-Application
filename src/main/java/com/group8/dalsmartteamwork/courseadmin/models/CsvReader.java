package com.group8.dalsmartteamwork.courseadmin.models;

import com.group8.dalsmartteamwork.accesscontrol.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader implements ICsvReader {
    private BufferedReader bufferedReader;

    public CsvReader(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (Exception e) {
            // TODO: Add to Log
            this.bufferedReader = null;
        }
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        final String TEMP_PASSWORD = "temp";
        User user;
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] attributes = line.split(",|\\s");
                user = new User(attributes[0], attributes[1], attributes[2], attributes[3], TEMP_PASSWORD);
                users.add(user);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return users;
    }

}