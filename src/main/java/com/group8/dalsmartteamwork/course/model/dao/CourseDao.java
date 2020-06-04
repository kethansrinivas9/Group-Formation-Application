package com.group8.dalsmartteamwork.course.model.dao;

import com.group8.dalsmartteamwork.utils.User;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    Boolean courseExists(int courseID) throws SQLException;
    List<User> getStudentsForTA(int courseID) throws SQLException;
    Boolean addTAtoCourse(String bannerID, int courseID) throws SQLException;
}
