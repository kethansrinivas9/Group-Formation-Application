package com.group8.dalsmartteamwork.student;

import com.group8.dalsmartteamwork.student.dao.IStudentDao;
import com.group8.dalsmartteamwork.student.dao.StudentDaoImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class StudentDaoImplTest {

    private final IStudentDao studentDaoImpl = mock(StudentDaoImpl.class);
    Student student = new Student("1100", "C++");
    Student student1 = new Student("1120", "C");
    ArrayList<Student> studentArray = new ArrayList<>();
    private boolean check = false;

    @Test
    public void displayCoursesTest() {
        studentArray.add(student);
        studentArray.add(student1);
        when(studentDaoImpl.displayCourses()).thenReturn(studentArray);
        assertEquals(studentDaoImpl.displayCourses(), studentArray, "failed");
        verify(studentDaoImpl).displayCourses();

    }

    @Test
    public void verifyCoursesTest() {
        check = studentDaoImpl.displayCourses().add(student);
        assertTrue(check);
    }

}