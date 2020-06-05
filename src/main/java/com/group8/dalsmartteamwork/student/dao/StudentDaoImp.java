package com.group8.dalsmartteamwork.student.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import com.group8.dalsmartteamwork.student.model.Student;
import com.group8.dalsmartteamwork.utils.DbConnection;
import org.springframework.security.core.context.SecurityContextHolder;

public class StudentDaoImp implements StudentDao {
    Student student;
    String courseName, courseId;
    ArrayList<Student> courseList = new ArrayList<Student>();
    DbConnection dbConnection;
    HttpServletRequest request;
    public String username;

    @Override
    public ArrayList<Student> displayCourses() {
        try {
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String query = String.format(
                    "select c.CourseID, c.CourseName, u.BannerID from Courses AS c INNER JOIN CourseRole AS cr on (c.CourseID = cr.CourseID) INNER JOIN Role AS r on (cr.RoleID = r.RoleID) INNER JOIN Users AS u on (u.BannerID = cr.BannerID) where r.RoleID='2' and u.BannerID= '%s' ;",
                    username);
            ResultSet resultSet = dbConnection.getRecords(query);
            while (resultSet.next()) {
                courseId = resultSet.getString("c.CourseID");
                courseName = resultSet.getString("c.CourseName");
                courseList.add(new Student(courseId, courseName));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return courseList;
    }

}