package com.group8.dalsmartteamwork.guest.Dao;

import com.group8.dalsmartteamwork.course.model.Course;
import com.group8.dalsmartteamwork.utils.DbConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestDaoImpl implements GuestDao {

    DbConnection connection;

    @Override
    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = "SELECT * FROM Courses";
            ResultSet rs = connection.getRecords(query);
            while (rs.next()) {
                courses.add(new Course(Integer.parseInt(rs.getString("CourseID")), rs.getString("CourseName")));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
        return courses;
    }

}
