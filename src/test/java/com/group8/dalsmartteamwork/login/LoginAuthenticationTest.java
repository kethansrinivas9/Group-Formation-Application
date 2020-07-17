package com.group8.dalsmartteamwork.login;

import com.group8.dalsmartteamwork.login.model.LoginAuthentication;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;


public class LoginAuthenticationTest {

    Authentication authenticate;
    LoginAuthentication loginAuthentication = mock(LoginAuthentication.class);

    @Test
    public void authenticateUserTest() {
        when(loginAuthentication.authenticate(authenticate)).thenReturn(null);
        assertNull(loginAuthentication.authenticate(authenticate));
        verify(loginAuthentication).authenticate(authenticate);
    }
}