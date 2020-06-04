package com.group8.dalsmartteamwork.student.model;

public class Student {
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

    public String getBannerId() {
        return BannerId;
    }

    public void setBannerId(String bannerId) {
        this.BannerId = bannerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        this.Role = role;
    }

}