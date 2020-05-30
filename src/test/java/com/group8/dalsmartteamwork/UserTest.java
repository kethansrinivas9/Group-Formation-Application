package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.group8.dalsmartteamwork.register.models.User;
import org.junit.jupiter.api.Test;

public class UserTest {
    public static final String TEMP_ID = "B00833467";
    public static final String TEMP_FIRST_NAME = "temp_name";
    public static final String TEMP_LAST_NAME = "temp_name";
    public static final String TEMP_EMAIL = "temp@email.com";
    public static final String TEMP_PASSWORD = "temp_password";

    @Test
    public void defaultConstructorTest() {
        User user = new User();
        assertNull(user.getId());
    }

    @Test
    public void constructorThreeArgumentsTest() {
        User user = new User(TEMP_ID, TEMP_EMAIL, TEMP_PASSWORD);
        assertTrue(user.getId() == TEMP_ID);
    }

    @Test
    public void constructorFourArgumentsTest() {
        User user = new User(TEMP_ID, TEMP_FIRST_NAME, TEMP_LAST_NAME, TEMP_EMAIL, TEMP_PASSWORD);
        assertTrue(user.getFirstName().equals(TEMP_FIRST_NAME));
    }

    @Test
    public void setIdTest() {
        User user = new User(TEMP_ID);
        assertTrue(user.getId() == TEMP_ID);
    }

    @Test
    public void getIdTest() {
        User user = new User(TEMP_ID, TEMP_FIRST_NAME, TEMP_LAST_NAME, TEMP_EMAIL, TEMP_PASSWORD);
        assertTrue(user.getId() == TEMP_ID);
    }

    @Test
    public void setFirstNameTest() {
        User user = new User(TEMP_ID);
        user.setFirstName(TEMP_FIRST_NAME);
        assertTrue(user.getFirstName().equals(TEMP_FIRST_NAME));
    }

    @Test
    public void getFirstNameTest() {
        User user = new User(TEMP_ID, TEMP_FIRST_NAME, TEMP_LAST_NAME, TEMP_EMAIL, TEMP_PASSWORD);
        assertTrue(user.getFirstName().equals((TEMP_FIRST_NAME)));
    }

    @Test
    public void setLastNameTest() {
        User user = new User(TEMP_ID);
        user.setLastName(TEMP_LAST_NAME);
        assertTrue(user.getLastName().equals(TEMP_LAST_NAME));
    }

    @Test
    public void getLastNameTest() {
        User user = new User(TEMP_ID, TEMP_FIRST_NAME, TEMP_LAST_NAME, TEMP_EMAIL, TEMP_PASSWORD);
        assertTrue(user.getLastName().equals((TEMP_LAST_NAME)));
    }

    @Test
    public void setEmailTest() {
        User user = new User(TEMP_ID);
        user.setEmail(TEMP_EMAIL);
        assertTrue(user.getEmail().equals(TEMP_EMAIL));
    }

    @Test
    public void getEmailTest() {
        User user = new User(TEMP_ID, TEMP_FIRST_NAME, TEMP_LAST_NAME, TEMP_EMAIL, TEMP_PASSWORD);
        assertTrue(user.getEmail().equals((TEMP_EMAIL)));
    }

    @Test
    public void setPasswordTest() {
        User user = new User(TEMP_ID);
        user.setPassword(TEMP_PASSWORD);
        assertTrue(user.getPassword().equals(TEMP_PASSWORD));
    }

    @Test
    public void getPasswordTest() {
        User user = new User(TEMP_ID, TEMP_FIRST_NAME, TEMP_LAST_NAME, TEMP_EMAIL, TEMP_PASSWORD);
        assertTrue(user.getPassword().equals(TEMP_PASSWORD));
    }

}