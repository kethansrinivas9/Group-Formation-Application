package com.group8.dalsmartteamwork.courseadmin.services;

import com.group8.dalsmartteamwork.utils.ICsvReader;
import com.group8.dalsmartteamwork.utils.User;

import java.util.List;

public class ParseCsvServiceImpl implements ParseCsvService {
    private ICsvReader reader;

    public ParseCsvServiceImpl(ICsvReader reader) {
        this.reader = reader;
    }

    @Override
    public List<User> getUsers() {
        return reader.getUsers();
    }
}
