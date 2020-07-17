package com.group8.dalsmartteamwork.course;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.course.dao.CourseDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ICourseDaoImplTest {
    public static final int TEMP_COURSEID = 9999;
    public static final String TEMP_BANNERID = "B00000000";
    public static final String TEMP_COURSENAME = "Course1";
    CourseDaoImpl courseDao = mock(CourseDaoImpl.class);

    @Test
    public void courseExistsTest() {
        when(courseDao.courseExists(TEMP_COURSEID)).thenReturn(true);
        assertTrue(courseDao.courseExists(TEMP_COURSEID));
        verify(courseDao).courseExists(TEMP_COURSEID);
    }

    @Test
    public void getUsersForTATest() {
        List<User> users = new ArrayList<>();
        User user1 = new User("B00000001", "fname1", "lname1", "email1", "p1");
        User user2 = new User("B00000002", "fname2", "lname2", "email2", "p2");
        User user3 = new User("B00000003", "fname3", "lname3", "email3", "p3");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        when(courseDao.getUsersForTA(TEMP_COURSEID)).thenReturn(users);
        assertEquals(courseDao.getUsersForTA(TEMP_COURSEID), users);
        verify(courseDao).getUsersForTA(TEMP_COURSEID);
    }

    @Test
    public void getCurrentTAsTest() {
        List<User> taList = new ArrayList<>();
        User user1 = new User("B00000001", "fname1", "lname1", "email1", "p1");
        User user2 = new User("B00000002", "fname2", "lname2", "email2", "p2");
        User user3 = new User("B00000003", "fname3", "lname3", "email3", "p3");
        taList.add(user1);
        taList.add(user2);
        taList.add(user3);
        when(courseDao.getCurrentTAs(TEMP_COURSEID)).thenReturn(taList);
        assertEquals(courseDao.getCurrentTAs(TEMP_COURSEID), taList);
        verify(courseDao).getCurrentTAs(TEMP_COURSEID);
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
        when(courseDao.getCurrentStudents(TEMP_COURSEID)).thenReturn(studentList);
        assertEquals(courseDao.getCurrentStudents(TEMP_COURSEID), studentList);
        verify(courseDao).getCurrentStudents(TEMP_COURSEID);
    }

    @Test
    public void getStudentsForTATest() {
        List<User> studentList = new ArrayList<>();
        User user1 = new User("B00000001", "fname1", "lname1", "email1", "p1");
        User user2 = new User("B00000002", "fname2", "lname2", "email2", "p2");
        User user3 = new User("B00000003", "fname3", "lname3", "email3", "p3");
        studentList.add(user1);
        studentList.add(user2);
        studentList.add(user3);
        when(courseDao.getUsersForTA(TEMP_COURSEID)).thenReturn(studentList);
        assertEquals(courseDao.getUsersForTA(TEMP_COURSEID), studentList);
        verify(courseDao).getUsersForTA(TEMP_COURSEID);
    }

    @Test
    public void getCourseNameTest() {
        when(courseDao.getCourseName(TEMP_COURSEID)).thenReturn(TEMP_COURSENAME);
        assertEquals(courseDao.getCourseName(TEMP_COURSEID), TEMP_COURSENAME);
        verify(courseDao).getCourseName(TEMP_COURSEID);
    }

    @Test
    public void addTAtoCourseTest() {
        when(courseDao.addTAtoCourse(TEMP_BANNERID, TEMP_COURSEID)).thenReturn(true);
        assertTrue(courseDao.addTAtoCourse(TEMP_BANNERID, TEMP_COURSEID));
        verify(courseDao).addTAtoCourse(TEMP_BANNERID, TEMP_COURSEID);
    }
}
