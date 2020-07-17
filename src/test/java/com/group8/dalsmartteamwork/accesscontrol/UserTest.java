package com.group8.dalsmartteamwork.accesscontrol;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    public static final String TEMP_ID = "B99999999";
    public static final String TEMP_FIRST_NAME = "TEST_FIRST_NAME";
    public static final String TEMP_LAST_NAME = "TEST_LAST_NAME";
    public static final String TEMP_EMAIL = "TEST_EMAIL@EMAIL.COM";
    public static final String TEMP_PASSWORD = "TEST_PASSWORD";
    public static final String TEMP_ROLE = "Admin";
    public static final String NEW_ID = "B99999998";
    public static final String NEW_FIRST_NAME = "NEW_FIRST_NAME";
    public static final String NEW_LAST_NAME = "NEW_LAST_NAME";
    public static final String NEW_EMAIL = "NEW_EMAIL@EMAIL.COM";
    public static final String NEW_PASSWORD = "NEW_PASSWORD";
    public static final String NEW_ROLE = "Admin";

    @Test
    public void defaultConstructorTest() {
        UserDetailsMock userDetailsMock = new UserDetailsMock();
        assertTrue(userDetailsMock.getId() == TEMP_ID);
    }

    @Test
    public void setIdTest() {
        UserDetailsMock userDetailsMock = new UserDetailsMock();
        userDetailsMock.setId(NEW_ID);
        assertTrue(userDetailsMock.getId().equals(NEW_ID));
    }

    @Test
    public void getIdTest() {
        UserDetailsMock userDetailsMock = new UserDetailsMock();
        assertTrue(userDetailsMock.getId().equals(TEMP_ID));
    }

    @Test
    public void setFirstNameTest() {
        UserDetailsMock userDetailsMock = new UserDetailsMock();
        userDetailsMock.setFirstName(NEW_FIRST_NAME);
        assertTrue(userDetailsMock.getFirstName().equals(NEW_FIRST_NAME));
    }

    @Test
    public void getFirstNameTest() {
        UserDetailsMock userDetailsMock = new UserDetailsMock();
        assertTrue(userDetailsMock.getFirstName().equals(TEMP_FIRST_NAME));
    }

    @Test
    public void setLastNameTest() {
        UserDetailsMock userDetailsMock = new UserDetailsMock();
        userDetailsMock.setLastName(NEW_LAST_NAME);
        assertTrue(userDetailsMock.getLastName().equals(NEW_LAST_NAME));
    }

    @Test
    public void getLastNameTest() {
        UserDetailsMock userDetailsMock = new UserDetailsMock();
        assertTrue(userDetailsMock.getLastName().equals(TEMP_LAST_NAME));
    }

    @Test
    public void setEmailTest() {
        UserDetailsMock userDetailsMock = new UserDetailsMock();
        userDetailsMock.setEmail(NEW_EMAIL);
        assertTrue(userDetailsMock.getEmail().equals(NEW_EMAIL));
    }

    @Test
    public void getEmailTest() {
        UserDetailsMock userDetailsMock = new UserDetailsMock();
        assertTrue(userDetailsMock.getEmail().equals(TEMP_EMAIL));
    }

    @Test
    public void setPasswordTest() {
        UserDetailsMock userDetailsMock = new UserDetailsMock();
        userDetailsMock.setPassword(NEW_PASSWORD);
        assertTrue(userDetailsMock.getPassword().equals(NEW_PASSWORD));
    }

    @Test
    public void getPasswordTest() {
        UserDetailsMock userDetailsMock = new UserDetailsMock();
        assertTrue(userDetailsMock.getPassword().equals(TEMP_PASSWORD));
    }

    @Test
    public void setRoleTest() {
        UserDetailsMock userDetailsMock = new UserDetailsMock();
        userDetailsMock.setRole(NEW_ROLE);
        assertTrue(userDetailsMock.getRole().equals(NEW_ROLE));
    }
}