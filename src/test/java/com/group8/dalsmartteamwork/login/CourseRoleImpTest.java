package com.group8.dalsmartteamwork.login;

import com.group8.dalsmartteamwork.login.dao.CourseRoleDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CourseRoleImpTest {

    CourseRoleDaoImpl courseRoleDaoImpl = mock(CourseRoleDaoImpl.class);
    Set<String> roleList = new HashSet<String>();

    @Test
    public void addCourseRoleTest() {
        roleList.add("Student");
        roleList.add("TA");
        assertNotNull(roleList.size());
    }

    @Test
    public void getCourseRolesTest() {
        roleList.add("Student");
        roleList.add("TA");
        when(courseRoleDaoImpl.getCourseRoles()).thenReturn(roleList);
        assertEquals(courseRoleDaoImpl.getCourseRoles(), roleList, "Failed");
        verify(courseRoleDaoImpl).getCourseRoles();
    }

}