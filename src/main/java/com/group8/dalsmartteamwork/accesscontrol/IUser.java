package com.group8.dalsmartteamwork.accesscontrol;

public interface IUser {

    String getId();

    void setId(String id);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getEmail();

    void setEmail(String email);

    String getPassword();

    void setPassword(String password);

    String getRole();

    void setRole(String role);

}