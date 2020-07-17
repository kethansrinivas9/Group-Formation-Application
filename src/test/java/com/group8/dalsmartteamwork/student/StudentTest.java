package com.group8.dalsmartteamwork.student;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {

    public Student studentMock() {
        Student student = new Student();
        student.setBannerId("B00884438");
        student.setCourseId("1100");
        student.setFirstName("name");
        student.setLastName("last");
        student.setCourseName("ASDC");
        student.setRole("student");

        return student;
    }

    @Test
    public void defaultConstructorTest() {
        Student student1 = new Student();
        assertNull(student1.getBannerId());
    }

    @Test
    public void constructorTest() {
        Student student = studentMock();
        assertTrue(student.getCourseId().equals("1100"));
    }

    @Test
    public void getBannerIDTest() {
        Student student = studentMock();
        assertTrue(student.getBannerId().equals("B00884438"));
    }

    @Test
    public void setBannerIDtest() {
        Student student = studentMock();
        student.setBannerId("B00884438");
        assertTrue(student.getBannerId().equals("B00884438"));
    }

    @Test
    public void getFirstNameTest() {
        Student student = studentMock();
        assertTrue(student.getFirstName().equals(("name")));
    }

    @Test
    public void setFirstNameTest() {
        Student student = studentMock();
        student.setFirstName("name");
        assertTrue(student.getFirstName().equals("name"));
    }

    @Test
    public void getLastNameTest() {
        Student student = studentMock();
        assertTrue(student.getLastName().equals(("last")));
    }

    @Test
    public void setLastNameTest() {
        Student student = studentMock();
        student.setLastName("last");
        assertTrue(student.getLastName().equals("last"));
    }

    @Test
    public void getCourseIDTest() {
        Student student = studentMock();
        assertTrue(student.getCourseId().equals(("1100")));
    }

    @Test
    public void setEmailTest() {
        Student student = studentMock();
        student.setCourseId("1100");
        assertTrue(student.getCourseId().equals("1100"));
    }

    @Test
    public void getCourseNameTest() {
        Student student = studentMock();
        assertTrue(student.getCourseName().equals("ASDC"));
    }

    @Test
    public void setCourseNameTest() {
        Student student = studentMock();
        student.setCourseName("ASDC");
        assertTrue(student.getCourseName().equals("ASDC"));
    }

    @Test
    public void getRoleTest() {
        Student student = studentMock();
        assertTrue(student.getRole().equals("student"));
    }

    @Test
    public void setRoleTest() {
        Student student = studentMock();
        student.setRole("student");
        assertTrue(student.getRole().equals("student"));
    }

}