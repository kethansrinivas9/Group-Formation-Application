package com.group8.dalsmartteamwork.courseadmin.models;

import com.group8.dalsmartteamwork.accesscontrol.User;

import java.util.List;

public class CsvParserImpl implements ICsvParser {
    private final ICsvReader reader;

    public CsvParserImpl(ICsvReader reader) {
        this.reader = reader;
    }

    @Override
    public List<User> getUsers() {
        return reader.getUsers();
    }
}
