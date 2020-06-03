package com.group8.dalsmartteamwork.courseadmin.dao;

import java.util.List;

import com.group8.dalsmartteamwork.utils.User;

public interface ImportCsvDao {
    public Boolean isUserInDb(String id);
    public void addUserToDb(User user);
}