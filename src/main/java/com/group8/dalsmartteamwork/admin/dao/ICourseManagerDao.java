package com.group8.dalsmartteamwork.admin.dao;

import com.group8.dalsmartteamwork.course.Course;

import java.util.List;

public interface ICourseManagerDao {

    List<Course> getAllCourses();

    boolean createNewCourse(String courseName, int courseID, String instructorId);

    boolean updateCourse(String newCourseName, int newCourseID, String instructorID, int oldCourseID);

    boolean deleteCourse(String courseID);

}
