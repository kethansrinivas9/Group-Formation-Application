package com.group8.dalsmartteamwork.login.dao;

import java.sql.SQLException;

public interface LoginDao {

    public Boolean getUserDetails(String id, String firstName, String email, String password) throws SQLException;

}