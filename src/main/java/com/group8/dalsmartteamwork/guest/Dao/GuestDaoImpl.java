package com.group8.dalsmartteamwork.guest.Dao;

import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.utils.CallStoredProcedure;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestDaoImpl implements IGuestDao {

    @Override
    public List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
        CallStoredProcedure storedProcedure = null;
        ResultSet rs;
        try {
            storedProcedure = new CallStoredProcedure("spGetAllCourses()");
            rs = storedProcedure.executeWithResults();
            while (rs.next()) {
                courses.add(new Course(Integer.parseInt(rs.getString("CourseID")), rs.getString("CourseName")));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
        return courses;
    }

}
