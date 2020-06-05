package com.group8.dalsmartteamwork.admin.service;

import com.group8.dalsmartteamwork.admin.dao.AdminDao;
import com.group8.dalsmartteamwork.course.model.Course;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao;

    public AdminServiceImpl(){
        this.adminDao = new AdminDao();
    }

    public AdminServiceImpl(AdminDao adminDao){
        this.adminDao = adminDao;
    }

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

    public boolean updateCourse(String newCourseName, int newCourseID, String instructorID, int oldCourseID) {
        return adminDao.updateCourse(newCourseName, newCourseID, instructorID, oldCourseID);
    }

    @Override
    public String getCourseInstructor(String courseID) {
        return adminDao.getCourseInstructor(courseID);
    }

    @Override
    public boolean deleteCourse(String courseID) {
        return adminDao.deleteCourse(courseID);
    }
}
