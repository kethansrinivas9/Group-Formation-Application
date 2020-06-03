package com.group8.dalsmartteamwork.utils;

public interface IUser {
    public void setId(String id);

    public void setFirstName(String firstName);

    public void setLastName(String lastName);

    public void setEmail(String email);

    public void setPassword(String password);

    public String getId();

    public String getFirstName();

    public String getLastName();

    public String getEmail();

    public String getPassword();
}