package com.group8.dalsmartteamwork.register.dao;

import com.group8.dalsmartteamwork.utils.User;

public interface RegistrationDao{
    public Boolean isUserInDb(String id);
    public Boolean addUserToDb(User user);
}