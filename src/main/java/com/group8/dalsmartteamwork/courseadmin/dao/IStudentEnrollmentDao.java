package com.group8.dalsmartteamwork.courseadmin.dao;

public interface IStudentEnrollmentDao {
    Boolean assignCourseToUser(String userId, int courseId);
}
