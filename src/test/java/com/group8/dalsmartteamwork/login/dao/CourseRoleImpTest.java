package com.group8.dalsmartteamwork.login.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class CourseRoleImpTest {

    CourseRoleImp courseRoleImp = mock(CourseRoleImp.class);
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
        when(courseRoleImp.getCourseRoles()).thenReturn(roleList);
        assertEquals(courseRoleImp.getCourseRoles(), roleList, "Failed");
        verify(courseRoleImp).getCourseRoles();
    }
    
}