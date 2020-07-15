package com.group8.dalsmartteamwork.student;

public class Student implements IStudent {
    private String BannerId;
    private String firstName;
    private String LastName;
    private String courseName;
    private String courseId;
    private String Role;

    public Student() {
    }

    public Student(String courseId, String courseName) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    public Student(String bannerId, String courseName, String courseId) {
        this.BannerId = bannerId;
        this.courseName = courseName;
        this.courseId = courseId;
    }

    @Override
    public String getBannerId() {
        return BannerId;
    }

    @Override
    public void setBannerId(String bannerId) {
        this.BannerId = bannerId;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return LastName;
    }

    @Override
    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public String getCourseName() {
        return courseName;
    }

    @Override
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String getCourseId() {
        return courseId;
    }

    @Override
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String getRole() {
        return Role;
    }

    @Override
    public void setRole(String role) {
        this.Role = role;
    }

}