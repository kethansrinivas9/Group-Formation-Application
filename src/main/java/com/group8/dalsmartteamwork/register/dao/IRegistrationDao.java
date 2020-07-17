package com.group8.dalsmartteamwork.register.dao;

import com.group8.dalsmartteamwork.accesscontrol.User;

public interface IRegistrationDao {
    Boolean isUserInDb(String id);

    Boolean addUserToDb(User user);

    Boolean addGuestRoleToUser(String id);
}