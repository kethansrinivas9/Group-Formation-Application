package com.group8.dalsmartteamwork.login.loginsecurity;

import com.group8.dalsmartteamwork.login.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoleAuthorizationTest {

    public boolean role;
    private final User user = new User("123", "Test", "Test_last", "test124@gmail.com", "test@123");

    @Test
    public void getAuthroitiesTest() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        role = authorities.add(new SimpleGrantedAuthority("admin"));
        assertTrue(role);
    }

    @Test
    public void getPasswordTest() {
        assertNotNull(user.getPassword());
    }

    @Test
    public void getUsernameTest() {
        assertNotNull(user.getId());
    }

}