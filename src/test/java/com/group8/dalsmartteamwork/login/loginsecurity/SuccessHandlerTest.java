package com.group8.dalsmartteamwork.login.loginsecurity;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.group8.dalsmartteamwork.login.login_security.Successhandler;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SuccessHandlerTest {

    @Mock
    Authentication authentication;

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @InjectMocks
    Successhandler successhandler;

    // @Test
    // public void displayAdminPageTest() {
    //     ArrayList<String> roles = new ArrayList<>();
    //     roles.add("Admin");
    //     Set<GrantedAuthority> authorities = new HashSet<>();
    //     authentication.getAuthorities();
            
        
    // }
}