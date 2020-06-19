package com.group8.dalsmartteamwork.admin;

import com.group8.dalsmartteamwork.admin.dao.CourseManagerDaoImpl;
import com.group8.dalsmartteamwork.admin.dao.ICourseManagerDao;
import com.group8.dalsmartteamwork.admin.models.CourseManagerImpl;
import com.group8.dalsmartteamwork.admin.models.ICourseManager;
import com.group8.dalsmartteamwork.course.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CourseManagerImplTest {
    private final ICourseManagerDao courseManagerDao = mock(CourseManagerDaoImpl.class);
    private final List<Course> courses = new ArrayList<>();
    private final Course courseOne = new Course(123, "SAMPLE_COURSE_NAME", "Instructor123");
    private final Course courseTwo = new Course(123, "SAMPLE_COURSE_NAME", "Instructor123");
    private final String instructorID = "B00123456";
    private ICourseManager iCourseManager = null;

    @BeforeEach
    public void setup() {
        iCourseManager = new CourseManagerImpl(courseManagerDao);
        courses.add(courseOne);
        courses.add(courseTwo);
    }

    @Test
    public void getAllCoursesTest() {
        when(iCourseManager.getAllCourses()).thenReturn(courses);
        assertEquals(iCourseManager.getAllCourses(), courses);
    }

    @Test
    public void createNewCourseTest() {
        when(iCourseManager.createNewCourse(courseOne)).thenReturn(true);
        assertTrue(iCourseManager.createNewCourse(courseOne));
    }

    @Test
    public void updateCourseTest() {
        when(iCourseManager.updateCourse(courseTwo.getCourseName(), courseTwo.getCourseID(), instructorID, courseOne.getCourseID())).thenReturn(true);
        assertTrue(iCourseManager.updateCourse(courseTwo.getCourseName(), courseTwo.getCourseID(), instructorID, courseOne.getCourseID()));
    }

    @Test
    public void deleteCourseTest() {
        when(iCourseManager.deleteCourse(String.valueOf(courseOne.getCourseID()))).thenReturn(true);
        assertTrue(iCourseManager.deleteCourse(String.valueOf(courseOne.getCourseID())));
    }
}
