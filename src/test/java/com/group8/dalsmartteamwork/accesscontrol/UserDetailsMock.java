package com.group8.dalsmartteamwork.accesscontrol;

public class UserDetailsMock implements IUser {
    private String id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private String role;

    public UserDetailsMock() {
        setToDefault();
    }

    public void setToDefault() {
        id = "B99999999";
        lastName = "TEST_LAST_NAME";
        firstName = "TEST_FIRST_NAME";
        email = "TEST_EMAIL@EMAIL.COM";
        password = "TEST_PASSWORD";
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }
}