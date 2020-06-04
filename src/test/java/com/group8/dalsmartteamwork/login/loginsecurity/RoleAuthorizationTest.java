package com.group8.dalsmartteamwork.login.loginsecurity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import com.group8.dalsmartteamwork.login.model.User;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class RoleAuthorizationTest {

    public boolean role;
    User user = new User("123", "Ramya", "Ramathas", "ramya21@gmail.com", "test@123");

    // @Test
    // public void constructorRoleAuthorizationTest() {
    // assertNull(user);
    // }

    @Test
    public void getAuthroitiesTest() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        role = authorities.add(new SimpleGrantedAuthority("Student"));
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

    @Test
    public void isAccountNonExpiredTest() {
        
    }

}