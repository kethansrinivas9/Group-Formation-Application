package com.group8.dalsmartteamwork.login.model;

import java.util.Set;

import com.group8.dalsmartteamwork.login.dao.CourseRoleDao;

public class CourseRoleImp implements CourseRole {

    private CourseRoleDao courseRoleDao;

    public CourseRoleImp(CourseRoleDao courseRoleDao) {
        this.courseRoleDao = courseRoleDao;
    }

    @Override
    public Set<String> getCourseRoles() {
        return courseRoleDao.getCourseRoles();
    }
   
}