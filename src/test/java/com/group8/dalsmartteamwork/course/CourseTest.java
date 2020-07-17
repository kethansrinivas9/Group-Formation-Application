package com.group8.dalsmartteamwork.course;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseTest {
    public static final int COURSE_ID = 123;
    public static final String COURSE_NAME = "SAMPLE_COURSE_NAME";
    public static final String INSTRUCTOR_ID = "B00123456";

    @Test
    public void defaultConstructorWithSingleParameterTest() {
        Course course = new Course(COURSE_ID);
        assertEquals(course.getCourseID(), COURSE_ID);
    }

    @Test
    public void defaultConstructorWithTwoParametersTest() {
        Course course = new Course(COURSE_ID, COURSE_NAME);
        assertEquals(course.getCourseID(), COURSE_ID);
        assertEquals(course.getCourseName(), COURSE_NAME);
    }

    @Test
    public void defaultConstructorWithThreeParametersTest() {
        Course course = new Course(COURSE_ID, COURSE_NAME, INSTRUCTOR_ID);
        assertEquals(course.getCourseID(), COURSE_ID);
        assertEquals(course.getCourseName(), COURSE_NAME);
        assertEquals(course.getInstructorID(), INSTRUCTOR_ID);
    }

    @Test
    public void getCourseIdTest() {
        Course course = new Course(COURSE_ID, COURSE_NAME);
        assertEquals(course.getCourseID(), COURSE_ID);
    }

    @Test
    public void setCourseIdTest() {
        Course course = new Course();
        course.setCourseID(COURSE_ID);
        assertEquals(course.getCourseID(), COURSE_ID);
    }

    @Test
    public void getCourseNameTest() {
        Course course = new Course(COURSE_ID, COURSE_NAME);
        assertEquals(course.getCourseName(), COURSE_NAME);
    }

    @Test
    public void setCourseNameTest() {
        Course course = new Course();
        course.setCourseName(COURSE_NAME);
        assertEquals(course.getCourseName(), COURSE_NAME);
    }

    @Test
    public void getInstructorIDTest() {
        Course course = new Course(COURSE_ID, COURSE_NAME, INSTRUCTOR_ID);
        assertEquals(course.getInstructorID(), INSTRUCTOR_ID);
    }

    @Test
    public void setInstructorIDTest() {
        Course course = new Course();
        course.setInstructorID(INSTRUCTOR_ID);
        assertEquals(course.getInstructorID(), INSTRUCTOR_ID);
    }
}
