package com.group8.dalsmartteamwork.admin.service;

import com.group8.dalsmartteamwork.admin.dao.AdminDao;
import com.group8.dalsmartteamwork.course.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AdminServiceImplTest {
    private AdminService adminService = null;
    private final AdminDao adminDao = mock(AdminDao.class);
    private final List<Course> courses = new ArrayList<>();
    private final List<String> nonAdminUsers = Arrays.asList("SAMPLE_STRING_ONE", "SAMPLE_STRING_TWO");
    private final Course courseOne = new Course(123, "SAMPLE_COURSE_NAME");
    private final Course courseTwo = new Course(123, "SAMPLE_COURSE_NAME");
    private final String instructorID = "B00123456";

    @BeforeEach
    public void setup() {
        adminService = new AdminServiceImpl(adminDao);
        courses.add(courseOne);
        courses.add(courseTwo);
    }

    @Test
    public void getAllCoursesTest() {
        when(adminDao.getAllCourses()).thenReturn(courses);
        assertEquals(adminService.getAllCourses(), courses);
    }

    @Test
    public void getListOfNonAdminUsersTest() {
        when(adminDao.getListOfNonAdminUsers()).thenReturn(nonAdminUsers);
        assertEquals(adminService.getListOfNonAdminUsers(), nonAdminUsers);
    }

    @Test
    public void createNewCourseTest() {
        when(adminDao.createNewCourse(courseOne)).thenReturn(true);
        assertTrue(adminService.createNewCourse(courseOne));
    }

    @Test
    public void updateCourseTest() {
        when(adminDao.updateCourse(courseTwo.getCourseName(), courseTwo.getCourseID(), instructorID, courseOne.getCourseID())).thenReturn(true);
        assertTrue(adminService.updateCourse(courseTwo.getCourseName(), courseTwo.getCourseID(), instructorID, courseOne.getCourseID()));
    }

    @Test
    public void getCourseInstructorTest() {
        when(adminDao.getCourseInstructor(String.valueOf(courseOne.getCourseID()))).thenReturn(instructorID);
        assertEquals(adminService.getCourseInstructor(String.valueOf(courseOne.getCourseID())), instructorID);
    }

    @Test
    public void deleteCourseTest() {
        when(adminDao.deleteCourse(String.valueOf(courseOne.getCourseID()))).thenReturn(true);
        assertTrue(adminService.deleteCourse(String.valueOf(courseOne.getCourseID())));
    }
}
