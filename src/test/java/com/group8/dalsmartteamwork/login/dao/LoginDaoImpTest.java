package com.group8.dalsmartteamwork.login.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class LoginDaoImpTest {

    private LoginImplementation loginImplementation = mock(LoginImplementation.class);
    private static final String ID = "123";
    private static final String FIRSTNAME = "name";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email12@gmail.com";

    @Test
    void loginUserSuccessTest() {
        when(loginImplementation.getUserDetails(ID, FIRSTNAME, EMAIL, PASSWORD)).thenReturn(true);
        assertTrue(loginImplementation.getUserDetails(ID, FIRSTNAME, EMAIL, PASSWORD));
        verify(loginImplementation).getUserDetails(ID, FIRSTNAME, EMAIL, PASSWORD);
    }

}