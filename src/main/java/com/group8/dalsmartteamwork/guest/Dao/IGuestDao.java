package com.group8.dalsmartteamwork.guest.Dao;

import com.group8.dalsmartteamwork.course.Course;

import java.sql.SQLException;
import java.util.List;

public interface IGuestDao {
    List<Course> getCourses() throws SQLException;
}
