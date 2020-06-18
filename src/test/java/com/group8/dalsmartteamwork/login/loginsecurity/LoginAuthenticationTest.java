package com.group8.dalsmartteamwork.login.loginsecurity;

import com.group8.dalsmartteamwork.login.login_security.LoginAuthentication;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertNull;


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