package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.group8.dalsmartteamwork.login.models.User;

public class  UserTest {


    public static final String ID= "123";
    public static final String NAME = "Dalhousie";
    public static final String EMAIL= "Dal12@gmail.com";
    public static final String PASSWORD = "temdal@1234p";

    @Test
    public void defaultconstructorTest()
    {
        User user = new User();
        assertNull(user.getId());
    }

    @Test
    public void constructorTest()
    {
        User user =new User(ID,NAME,EMAIL, PASSWORD);
        assertTrue(user.getId().equals(ID));
        assertTrue(user.getName().equals(NAME));
        assertTrue(user.getEmail().equals(EMAIL));
        assertTrue(user.getPassword().equals(PASSWORD));
    }

    @Test
    public void getIDTest()
    {
        User user = new User(ID,NAME,EMAIL, PASSWORD);
        assertTrue(user.getId().equals(ID));
    }

    @Test
    public void setIDTest()
    {
        User user = new User(ID,NAME,EMAIL, PASSWORD);
        user.setId(ID);
        assertTrue(user.getId()==ID);
    }

    @Test
    public void getNameTest()
    {
        User user = new User(ID,NAME,EMAIL, PASSWORD);
        assertTrue(user.getName().equals(NAME));
    }

    @Test
    public void setNameTest()
    {
        User user = new User(ID,NAME,EMAIL, PASSWORD);
        user.setId(NAME);
        assertTrue(user.getName()==NAME);
    }

    @Test
    public void getEmailTest()
    {
        User user = new User(ID,NAME,EMAIL, PASSWORD);
        assertTrue(user.getEmail().equals(EMAIL));
    }

    @Test
    public void setEmailTest()
    {
        User user = new User(ID,NAME,EMAIL, PASSWORD);
        user.setId(EMAIL);
        assertTrue(user.getEmail()==EMAIL);
    }

    @Test
    public void getPasswordTest()
    {
        User user = new User(ID,NAME,EMAIL, PASSWORD);
        assertTrue(user.getPassword().equals(PASSWORD));
    }

    @Test
    public void setPasswordTest()
    {
        User user = new User(ID,NAME,EMAIL, PASSWORD);
        user.setId(PASSWORD);
        assertTrue(user.getPassword()==PASSWORD);
    }
    
}