package com.group8.dalsmartteamwork.register.dao;

public interface RegisterDao {
    public Boolean setUserDetails(long id, String name, String email, String password);
}