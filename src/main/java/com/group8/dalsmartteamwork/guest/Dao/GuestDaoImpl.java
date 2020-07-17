package com.group8.dalsmartteamwork.guest.Dao;

import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GuestDaoImpl implements IGuestDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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
            LOGGER.error("Exception occurred while fetching courses from the database.", exception);
        } finally {
            if (null != storedProcedure) {
                storedProcedure.cleanup();
            }
        }
        LOGGER.info("Fetched all courses for Guest");
        return courses;
    }

}
