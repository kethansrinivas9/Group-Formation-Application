package com.group8.dalsmartteamwork.admin.service;

import com.group8.dalsmartteamwork.course.model.Course;
import com.group8.dalsmartteamwork.utils.User;

import java.util.List;

public interface AdminService {

    public List<Course> getAllCourses();

    public boolean createNewCourse(Course courseDetails);

    public boolean deleteCourse(String courseID);

    public List<String> getListOfNonAdminUsers();

    public boolean assignInstructorToCourse(String bannerID, String courseID, int roleID);

    public boolean updateCourse(String newCourseName, int newCourseID, int oldCourseID);
}
