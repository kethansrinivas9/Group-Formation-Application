package com.group8.dalsmartteamwork.login;

import com.group8.dalsmartteamwork.accesscontrol.User;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoleAuthorizationTest {

    private final User user = new User("123", "Test", "Test_last", "test124@gmail.com", "test@123");
    public boolean role;

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