package com.group8.dalsmartteamwork.guest;

import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.guest.Dao.GuestDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GuestDaoImplTest {
    GuestDaoImpl courseDao = mock(GuestDaoImpl.class);

    @Test
    public void getCoursesTest() {
        List<Course> courses = new ArrayList<>();
        Course course1 = new Course(1111, "Course1");
        Course course2 = new Course(2222, "Course2");
        Course course3 = new Course(3333, "Course3");
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        when(courseDao.getCourses()).thenReturn(courses);
        assertEquals(courseDao.getCourses(), courses, "Failed to retrieve courses from the database");
        verify(courseDao).getCourses();
    }
}