package com.group8.dalsmartteamwork;

//import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class  UserTest {


    public static final long id= 123;
    public static final String name = "temp";
    public static final String email= "temp";
    public static final String password = "temp";

    @Test
    public void getNameTest()
    {
        User user = new User(id, name, email, password);
        assertTrue(user.getName().equals(name));
    }
}