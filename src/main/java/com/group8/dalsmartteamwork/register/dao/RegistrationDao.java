package com.group8.dalsmartteamwork.register.dao;

import com.group8.dalsmartteamwork.utils.User;

public interface RegistrationDao {
    Boolean isUserInDb(String id);

    Boolean addUserToDb(User user);

    Boolean addGuestRoleToUser(String id);
}