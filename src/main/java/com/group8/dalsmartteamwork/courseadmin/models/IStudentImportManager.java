package com.group8.dalsmartteamwork.courseadmin.models;

import com.group8.dalsmartteamwork.accesscontrol.User;

import java.util.List;

public interface IStudentImportManager {
    List<Boolean> verifyRegistration(List<User> users);
}