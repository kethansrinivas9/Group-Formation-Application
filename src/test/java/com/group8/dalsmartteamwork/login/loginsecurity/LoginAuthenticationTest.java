package com.group8.dalsmartteamwork.login.loginsecurity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.group8.dalsmartteamwork.login.dao.LoginImplementation;
import com.group8.dalsmartteamwork.login.model.User;
import org.junit.jupiter.api.Test;

public class LoginAuthenticationTest {
    User user = new User();
    private static final String ID = "122";
    private static final String FIRSTNAME = "dal";
    private static final String EMAIL = "dal12@gmail.com";
    private static final String PASSWORD = "Test@123";
    
    LoginImplementation loginImplementation = new LoginImplementation();
    
     @Test
     public void authenticateUserTest() {
         boolean exist = loginImplementation.getUserDetails(ID, FIRSTNAME, EMAIL, PASSWORD);
         assertFalse(exist);
     }
}