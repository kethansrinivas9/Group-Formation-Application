package com.group8.dalsmartteamwork.guest.Dao;

import com.group8.dalsmartteamwork.course.model.Course;

import java.sql.SQLException;
import java.util.List;

public interface GuestDao {
    List<Course> getCourses() throws SQLException;
}
