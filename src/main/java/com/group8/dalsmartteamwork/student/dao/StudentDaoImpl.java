package com.group8.dalsmartteamwork.student.dao;

import com.group8.dalsmartteamwork.accesscontrol.CurrentUser;
import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.student.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDaoImpl implements IStudentDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final ArrayList<Student> courseList = new ArrayList<Student>();
    private String username;
    private String courseName, courseId;

    @Override
    public ArrayList<Student> displayCourses() {

        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        username = CurrentUser.getInstance().getBannerId();
        try {
            procedure = new CallStoredProcedure("spGetEnrolledCourses(?)");
            procedure.setParameter(1, username);
            resultSet = procedure.executeWithResults();
            LOGGER.info("Fetched courses of student with BannerID: " + username);
            while (resultSet.next()) {
                courseId = resultSet.getString(1);
                courseName = resultSet.getString(2);
                courseList.add(new Student(courseId, courseName));
            }

        } catch (Exception e) {
            LOGGER.error("Exception occurred while fetching courses for BannerID: " + username, e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return courseList;
    }
}