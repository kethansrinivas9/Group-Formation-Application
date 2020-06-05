package com.group8.dalsmartteamwork.course.model;

public class Course {
    private int courseID;
    private String courseName;
    private String instructorID;

    public Course() {
    }

    public Course(int courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public Course(int courseID, String courseName, String instructorID) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.instructorID = instructorID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(String instructorID) {
        this.instructorID = instructorID;
    }
}
