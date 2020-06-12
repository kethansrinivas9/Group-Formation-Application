package com.group8.dalsmartteamwork.login.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginUserTest {

    public static final String [] roles = {"role1","role2","role3"};

    public User mockUser() {
        User user = new User();
        user.setId("B00884439");
        user.setFirstName("temp_name");
        user.setLastName("temp_lastname");
        user.setEmail("temp@gmail.com");
        user.setPassword("temp_password");

        return user;
    }

    @Test
    public void defaultConstructorTest() {
        User user1 = new User();
        assertNull(user1.getId());
    }

    @Test
    public void constructorThreeArgumentsTest() {
        User user = mockUser();
        assertTrue(user.getEmail().equals("temp@gmail.com"));
    }

    @Test
    public void constructorFourArgumentsTest() {
        User user = mockUser();
        assertTrue(user.getFirstName().equals("temp_name"));
    }

    @Test
    public void getIdTest() {
        User user = mockUser();
        assertTrue(user.getId() == "B00884439");
    }

    @Test
    public void setIdTest() {
        User user = mockUser();
        user.setId("B00884439");
        assertTrue(user.getId() == "B00884439");
    }

    @Test
    public void setFirstNameTest() {
        User user = mockUser();
        user.setFirstName("temp_name");
        assertTrue(user.getFirstName().equals("temp_name"));
    }

    @Test
    public void getFirstNameTest() {
        User user = mockUser();
        assertTrue(user.getFirstName().equals(("temp_name")));
    }

    @Test
    public void setLastNameTest() {
        User user = mockUser();
        user.setLastName("temp_lastname");
        assertTrue(user.getLastName().equals("temp_lastname"));
    }

    @Test
    public void getLastNameTest() {
        User user = mockUser();
        assertTrue(user.getLastName().equals(("temp_lastname")));
    }

    @Test
    public void setEmailTest() {
        User user = mockUser();
        user.setEmail("temp@gmail.com");
        assertTrue(user.getEmail().equals("temp@gmail.com"));
    }

    @Test
    public void getEmailTest() {
        User user = mockUser();
        assertTrue(user.getEmail().equals(("temp@gmail.com")));
    }

    @Test
    public void setPasswordTest() {
        User user = mockUser();
        user.setPassword("temp_passowrd");
        assertTrue(user.getPassword().equals("temp_passowrd"));
    }

    @Test
    public void getPasswordTest() {
        User user = mockUser();
        assertTrue(user.getPassword().equals("temp_password"));
    }

}
