package com.group8.dalsmartteamwork.login;

import com.group8.dalsmartteamwork.login.model.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoleTest {

    public static final String ROLE_ID = "1";
    public static final String ROLE_NAME_1 = "STUDENT";
    public static final String ROLE_ID_1 = "2";
    public static final String ROLE_NAME = "ADMIN";

    @Test
    public void defaultConstructorRoleTest() {
        Role role = new Role();
        assertNull(role.getRoleId());
    }

    @Test
    public void constructorRoleTest() {
        Role role = new Role(ROLE_ID, ROLE_NAME);
        assertTrue(role.getRoleName().equals(ROLE_NAME));
    }

    @Test
    public void getRoleIdTest() {
        Role role = new Role(ROLE_ID, ROLE_NAME);
        assertTrue(role.getRoleId() == ROLE_ID);
    }

    @Test
    public void setRoleIdTest() {
        Role role = new Role();
        role.setRoleId(ROLE_ID);
        assertTrue(role.getRoleId() == ROLE_ID);
    }

    @Test
    public void getRoleNameTest() {
        Role role = new Role(ROLE_ID_1, ROLE_NAME_1);
        assertTrue(role.getRoleName() == ROLE_NAME_1);
    }

    @Test
    public void setRoleNameTest() {
        Role role = new Role();
        role.setRoleName(ROLE_NAME);
        assertTrue(role.getRoleName().equals(ROLE_NAME));
    }
}