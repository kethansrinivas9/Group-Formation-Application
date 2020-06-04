package com.group8.dalsmartteamwork.student.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.group8.dalsmartteamwork.student.model.Student;
import org.junit.jupiter.api.Test;

public class StudentDaoImpTest {

    private boolean check = false;
    private StudentDaoImp studentDaoImp = mock(StudentDaoImp.class);
    Student student = new Student("1100", "C++");
    Student student1 = new Student("1120", "C");
    ArrayList <Student> studentArray = new ArrayList<>();

    @Test
    public void displayCoursesTest() {
        studentArray.add(student);
        studentArray.add(student1);
        when(studentDaoImp.displayCourses()).thenReturn(studentArray);
        assertEquals(studentDaoImp.displayCourses(), studentArray, "failed");
        verify(studentDaoImp).displayCourses();
    
    }
    @Test
    public void verifyCoursesTest() {
        check = studentDaoImp.displayCourses().add(student);
        assertTrue(check);
    }

}