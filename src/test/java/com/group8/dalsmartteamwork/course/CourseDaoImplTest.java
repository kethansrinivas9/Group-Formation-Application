package com.group8.dalsmartteamwork.course;

import com.group8.dalsmartteamwork.course.model.dao.CourseDaoImpl;
import com.group8.dalsmartteamwork.utils.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class CourseDaoImplTest {
    public static final int TEMP_COURSEID = 9999;
    public static final String TEMP_BANNERID = "B00000000";
    CourseDaoImpl courseDao = mock(CourseDaoImpl.class);

    @Test
    public void courseExistsTest() {
        when(courseDao.courseExists(TEMP_COURSEID)).thenReturn(true);
        assertTrue(courseDao.courseExists(TEMP_COURSEID), "courseExists function failed");
        verify(courseDao).courseExists(TEMP_COURSEID);
    }

    @Test
    public void getStudentsForTATest() {
        List<User> users = new ArrayList<>();
        User user1 = new User("B00000001", "fname1", "lname1", "email1", "p1");
        User user2 = new User("B00000002", "fname2", "lname2", "email2", "p2");
        User user3 = new User("B00000003", "fname3", "lname3", "email3", "p3");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        when(courseDao.getStudentsForTA(TEMP_COURSEID)).thenReturn(users);
        assertEquals(courseDao.getStudentsForTA(TEMP_COURSEID), users, "Failed to get Eligible Students for assigning TA");
        verify(courseDao).getStudentsForTA(TEMP_COURSEID);
    }


    @Test
    public void addTAtoCourse() {
        when(courseDao.addTAtoCourse(TEMP_BANNERID, TEMP_COURSEID)).thenReturn(true);
        assertTrue(courseDao.addTAtoCourse(TEMP_BANNERID, TEMP_COURSEID), "Failed to add TA to the courseRole Table in the database");
        verify(courseDao).addTAtoCourse(TEMP_BANNERID, TEMP_COURSEID);
    }
}
