package com.group8.dalsmartteamwork.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private BufferedReader bufferedReader;

    public CsvReader() {
    }

    public CsvReader(InputStream inputStream) {
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public CsvReader(File file) {
        try {
            InputStream inputStream = new FileInputStream(file);
            this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        } catch (Exception e) {
            // TODO: Add to Log
            this.bufferedReader = null;
        }

    }

    public BufferedReader getBufferedReader() {
        return this.bufferedReader;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] attributes = line.split(",|\\s");
                User user = this.createUser(attributes);
                users.add(user);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return users;
    }

    private User createUser(String[] attributes) {
        return new User(attributes[0], attributes[1], attributes[2], attributes[3], "temp");
    }

}