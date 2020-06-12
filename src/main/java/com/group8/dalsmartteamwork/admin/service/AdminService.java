package com.group8.dalsmartteamwork.admin.service;

import com.group8.dalsmartteamwork.course.model.Course;

import java.util.List;

public interface AdminService {

    public List<Course> getAllCourses();

    public boolean createNewCourse(Course courseDetails);

    public boolean deleteCourse(String courseID);

    public List<String> getListOfNonAdminUsers();

    public String getCourseInstructor(String courseID);

    public boolean updateCourse(String newCourseName, int newCourseID, String instructorID, int oldCourseID);

}
