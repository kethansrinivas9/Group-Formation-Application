package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void defaultConstructorTest() {
        User user = new User();
        assertNull(user.getName());
    }

    @Test
    public void setIdTest() {
        User user = new User();
        user.setId(1234);
        assertTrue(user.getId() == (1234));
    }

    @Test
    public void getIdTest() {
        User user = new User();
        user.setId(1234);
        assertTrue(user.getId() == 1234);
    }

    @Test
    public void setNameTest() {
        User user = new User();
        user.setName("Avinash");
        assertTrue(user.getName().equals("Avinash"));
    }

    @Test
    public void getNameTest() {
        User user = new User();
        user.setName("Avinash");
        assertTrue(user.getName().equals(("Avinash")));
    }

    @Test
    public void setEmailTest() {
        User user = new User();
        user.setEmail("avinash@gmail.com");
        assertTrue(user.getEmail().equals("avinash@gmail.com"));
    }

    @Test
    public void getEmailTest() {
        User user = new User();
        user.setEmail("Avinash@gmail.com");
        assertTrue(user.getEmail().equals(("Avinash@gmail.com")));
    }

    @Test
    public void setPasswordTest() {
        User user = new User();
        user.setPassword("Avinash123");
        assertTrue(user.getPassword().equals("Avinash123"));
    }

    @Test
    public void getPasswordTest() {
        User user = new User();
        user.setPassword("password");
        assertTrue(user.getPassword().equals(("password")));
    }

}