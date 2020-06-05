package com.group8.dalsmartteamwork.course.dao;

import com.group8.dalsmartteamwork.utils.User;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    Boolean courseExists(int courseID) throws SQLException;
    List<User> getUsersForTA(int courseID) throws SQLException;
    Boolean addTAtoCourse(String bannerID, int courseID) throws SQLException;
    List<User> getCurrentTAs(int courseID) throws SQLException;
    List<User> getCurrentStudents(int courseID) throws SQLException;
    String getCourseName(int courseID) throws SQLException;
}
