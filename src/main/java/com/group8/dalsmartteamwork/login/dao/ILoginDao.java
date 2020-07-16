package com.group8.dalsmartteamwork.login.dao;

public interface ILoginDao {

    Boolean getUserDetails(String id, String firstName, String email, String password);

    String getRole();

    void setRole(String role);

    String getBannerID();

    void setBannerID(String bannerID);
}