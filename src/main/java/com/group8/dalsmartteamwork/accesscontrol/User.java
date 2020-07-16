package com.group8.dalsmartteamwork.accesscontrol;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User implements IUser {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    @NotNull
    @Size(min = 8, max = 30)
    private String password;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public User(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String id, String firstName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    public User(String id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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