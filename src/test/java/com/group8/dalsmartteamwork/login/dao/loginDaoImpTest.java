package com.group8.dalsmartteamwork.login.dao;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.group8.dalsmartteamwork.login.model.User;
import org.junit.jupiter.api.Test;

public class loginDaoImpTest {

    private LoginImplementation loginImplementation = mock(LoginImplementation.class);
    private static final User EXISTING_USER = new User("B000081", "hello", "kitty", "hello1@gmail.com", "hellokitty123");

    @Test
    void loginUserSuccessTest() {
        when(loginImplementation.getUserDetails(EXISTING_USER.getId(), EXISTING_USER.getFirstName(),
        EXISTING_USER.getEmail(), EXISTING_USER.getPassword())).thenReturn(true);
        assertTrue(loginImplementation.getUserDetails(EXISTING_USER.getId(), EXISTING_USER.getFirstName(),
        EXISTING_USER.getEmail(), EXISTING_USER.getPassword()));
    }

}