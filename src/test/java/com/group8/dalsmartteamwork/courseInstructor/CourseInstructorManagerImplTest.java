package com.group8.dalsmartteamwork.courseInstructor;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.course.models.CourseInstructorManagerImpl;
import com.group8.dalsmartteamwork.course.models.ICourseInstructorManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CourseInstructorManagerImplTest {
    public static final String TEMP_BANNERID = "B00000000";
    public static final int TEMP_COURSEID = 9999;
    ICourseInstructorManager courseInstructorManager = mock(CourseInstructorManagerImpl.class);

    @Test
    public void getCurrentTAsTest() {
        List<User> taList = new ArrayList<>();
        User user1 = new User("B00000001", "fname1", "lname1", "email1", "p1");
        User user2 = new User("B00000002", "fname2", "lname2", "email2", "p2");
        User user3 = new User("B00000003", "fname3", "lname3", "email3", "p3");
        taList.add(user1);
        taList.add(user2);
        taList.add(user3);
        when(courseInstructorManager.getCurrentTAs(TEMP_COURSEID)).thenReturn(taList);
        assertEquals(courseInstructorManager.getCurrentTAs(TEMP_COURSEID), taList);
        verify(courseInstructorManager).getCurrentTAs(TEMP_COURSEID);
    }

    @Test
    public void getCurrentStudentsTest() {
        List<User> studentList = new ArrayList<>();
        User user1 = new User("B00000001", "fname1", "lname1", "email1", "p1");
        User user2 = new User("B00000002", "fname2", "lname2", "email2", "p2");
        User user3 = new User("B00000003", "fname3", "lname3", "email3", "p3");
        studentList.add(user1);
        studentList.add(user2);
        studentList.add(user3);
        when(courseInstructorManager.getCurrentStudents(TEMP_COURSEID)).thenReturn(studentList);
        assertEquals(courseInstructorManager.getCurrentStudents(TEMP_COURSEID), studentList);
        verify(courseInstructorManager).getCurrentStudents(TEMP_COURSEID);
    }

    @Test
    public void courseExistsTest() {
        when(courseInstructorManager.courseExists(TEMP_COURSEID)).thenReturn(true);
        assertTrue(courseInstructorManager.courseExists(TEMP_COURSEID));
        verify(courseInstructorManager).courseExists(TEMP_COURSEID);
    }

    @Test
    public void getEligibleTAsTest() {
        List<User> users = new ArrayList<>();
        User user1 = new User("B00000001", "fname1", "lname1", "email1", "p1");
        User user2 = new User("B00000002", "fname2", "lname2", "email2", "p2");
        User user3 = new User("B00000003", "fname3", "lname3", "email3", "p3");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        when(courseInstructorManager.getEligibleTAs(TEMP_COURSEID)).thenReturn(users);
        assertEquals(courseInstructorManager.getEligibleTAs(TEMP_COURSEID), users);
        verify(courseInstructorManager).getEligibleTAs(TEMP_COURSEID);
    }

    @Test
    public void addTAtoCourseTest() {
        when(courseInstructorManager.addTAtoCourse(TEMP_BANNERID, TEMP_COURSEID)).thenReturn(true);
        assertTrue(courseInstructorManager.addTAtoCourse(TEMP_BANNERID, TEMP_COURSEID));
        verify(courseInstructorManager).addTAtoCourse(TEMP_BANNERID, TEMP_COURSEID);
    }
}