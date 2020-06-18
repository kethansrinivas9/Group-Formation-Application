package com.group8.dalsmartteamwork.student.model;

import com.group8.dalsmartteamwork.student.dao.StudentDao;
import com.group8.dalsmartteamwork.student.dao.StudentDaoImp;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class StudentImpTest {

    private boolean check = false;
    private StudentDao studentDaoImp = mock(StudentDaoImp.class);
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