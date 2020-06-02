package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.group8.dalsmartteamwork.login.model.Role;

import org.junit.jupiter.api.Test;

public class RoleTest {

    public static final String ROLE_ID = "1";
    public static final String ROLE_NAME_1 = "STUDENT";
    public static final String ROLE_ID_1 = "2";
    public static final String ROLE_NAME = "ADMIN";
    public static final String COURSE_NAME = "Web";

    @Test
    public void defaultConstructorRoleTest() {
        Role role = new Role();
        assertNull(role.getRoleId());
    }

    @Test
    public void constructorRoleTest() {
        Role role = new Role(ROLE_ID,ROLE_NAME,COURSE_NAME);
        assertTrue(role.getRoleName().equals(ROLE_NAME));
    }

    @Test
    public void getRoleIdTest() {
        Role role = new Role(ROLE_ID,ROLE_NAME,COURSE_NAME);
        assertTrue(role.getRoleId()==ROLE_ID);
    }
    
    @Test
    public void setRoleIdTest() {
        Role role = new Role();
        role.setRoleId(ROLE_ID);
        assertTrue(role.getRoleId()==ROLE_ID);
    }
    
    @Test
    public void getRoleNameTest() {
        Role role = new Role(ROLE_ID_1,ROLE_NAME_1,COURSE_NAME);
        assertTrue(role.getRoleName()==ROLE_NAME_1);
    }

    @Test
    public void setRoleNameTest() {
        Role role = new Role();
        role.setRoleName(ROLE_NAME);
        assertTrue(role.getRoleName().equals(ROLE_NAME));
    }
    
    @Test
    public void getCourseNameTest() {
        Role role = new Role(ROLE_ID,ROLE_NAME,COURSE_NAME);
        assertTrue(role.getCourseName()==COURSE_NAME);
    }

    @Test
    public void setCourseNameTest() {
        Role role = new Role();
        role.setCourseName(COURSE_NAME);
        assertTrue(role.getCourseName()==COURSE_NAME);
    }
    
    
    
}