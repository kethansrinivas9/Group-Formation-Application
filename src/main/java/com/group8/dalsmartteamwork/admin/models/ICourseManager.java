package com.group8.dalsmartteamwork.admin.models;

import com.group8.dalsmartteamwork.course.Course;

import java.util.List;

public interface ICourseManager {
    List<Course> getAllCourses();

    boolean createNewCourse(Course courseDetails);

    boolean deleteCourse(String courseID);

    boolean updateCourse(String newCourseName, int newCourseID, String instructorID, int oldCourseID);
}
