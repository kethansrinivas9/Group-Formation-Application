package com.group8.dalsmartteamwork.login.model;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import com.group8.dalsmartteamwork.login.dao.CourseRoleDaoImp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class CourseRoleImpTest {

    CourseRoleDaoImp courseRoleDaoImp = mock(CourseRoleDaoImp.class);
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
        when(courseRoleDaoImp.getCourseRoles()).thenReturn(roleList);
        assertEquals(courseRoleDaoImp.getCourseRoles(), roleList, "Failed");
        verify(courseRoleDaoImp).getCourseRoles();
    }

}