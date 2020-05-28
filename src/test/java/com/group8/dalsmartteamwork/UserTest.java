package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.group8.dalsmartteamwork.register.models.User;
import org.junit.jupiter.api.Test;

public class UserTest {

    public static final long TEMP_ID = 23591;
    public static final String TEMP_NAME = "temp_name";
    public static final String TEMP_EMAIL = "temp@email.com";
    public static final String TEMP_PASSWORD = "temp_password";

    @Test
    public void defaultConstructorTest() {
        User user = new User(TEMP_ID);
        assertNull(user.getName());
    }

    @Test
    public void constructorThreeArgumentsTest() {
        User user = new User(TEMP_ID, TEMP_EMAIL, TEMP_PASSWORD);
        assertNull(user.getName());
    }

    @Test
    public void constructorFourArgumentsTest() {
        User user = new User(TEMP_ID, TEMP_NAME, TEMP_EMAIL, TEMP_PASSWORD);
        assertTrue(user.getName().equals(TEMP_NAME));
    }

    @Test
    public void setIdTest() {
        User user = new User(TEMP_ID);
        assertTrue(user.getId() == TEMP_ID);
    }

    @Test
    public void getIdTest() {
        User user = new User(TEMP_ID, TEMP_NAME, TEMP_EMAIL, TEMP_PASSWORD);
        assertTrue(user.getId() == TEMP_ID);
    }

    @Test
    public void setNameTest() {
        User user = new User(TEMP_ID);
        user.setName(TEMP_NAME);
        assertTrue(user.getName().equals(TEMP_NAME));
    }

    @Test
    public void getNameTest() {
        User user = new User(TEMP_ID, TEMP_NAME, TEMP_EMAIL, TEMP_PASSWORD);
        assertTrue(user.getName().equals((TEMP_NAME)));
    }

    @Test
    public void setEmailTest() {
        User user = new User(TEMP_ID);
        user.setEmail(TEMP_EMAIL);
        assertTrue(user.getEmail().equals(TEMP_EMAIL));
    }

    @Test
    public void getEmailTest() {
        User user = new User(TEMP_ID, TEMP_NAME, TEMP_EMAIL, TEMP_PASSWORD);
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
        User user = new User(TEMP_ID, TEMP_NAME, TEMP_EMAIL, TEMP_PASSWORD);
        assertTrue(user.getPassword().equals(TEMP_PASSWORD));
    }

}