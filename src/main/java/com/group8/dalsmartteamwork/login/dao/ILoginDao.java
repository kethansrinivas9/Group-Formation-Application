package com.group8.dalsmartteamwork.login.dao;

public interface ILoginDao {

    Boolean getUserDetails(String id, String firstName, String email, String password);

}