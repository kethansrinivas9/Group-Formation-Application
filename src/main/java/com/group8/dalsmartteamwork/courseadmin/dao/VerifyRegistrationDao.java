package com.group8.dalsmartteamwork.courseadmin.dao;

import java.util.List;

import com.group8.dalsmartteamwork.utils.User;

public interface VerifyRegistrationDao {
    public List<Boolean> verifyRegistration(List<User> users);
}