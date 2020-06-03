package com.group8.dalsmartteamwork.admin.service;

import com.group8.dalsmartteamwork.admin.dao.AdminDao;
import com.group8.dalsmartteamwork.course.model.Course;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private static final AdminDao adminDao = new AdminDao();

    @Override
    public List<Course> getAllCourses() {
        return adminDao.getAllCourses();
    }

    @Override
    public List<String> getListOfNonAdminUsers() {
        return adminDao.getListOfNonAdminUsers();
    }

    @Override
    public boolean createNewCourse(Course courseDetails) {
        return adminDao.createNewCourse(courseDetails);
    }

    public boolean updateCourse(String newCourseName, int newCourseID, int oldCourseID) {
        return adminDao.updateCourse(newCourseName, newCourseID, oldCourseID);
    }

    @Override
    public boolean assignInstructorToCourse(String bannerID, String courseID, int roleID) {
        return adminDao.assignInstructorToCourse(bannerID, courseID, roleID);
    }

    @Override
    public boolean deleteCourse(String courseID) {
        return adminDao.deleteCourse(courseID);
    }
}
