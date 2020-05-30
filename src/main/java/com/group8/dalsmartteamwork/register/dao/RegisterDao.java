package com.group8.dalsmartteamwork.register.dao;

public interface RegisterDao {
    public Boolean setUserDetails(String id, String firstName, String lastName, String email, String password);
}