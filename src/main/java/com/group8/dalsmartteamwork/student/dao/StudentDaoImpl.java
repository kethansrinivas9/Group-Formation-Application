package com.group8.dalsmartteamwork.student.dao;

import com.group8.dalsmartteamwork.accesscontrol.CurrentUser;
import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.student.Student;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDaoImpl implements IStudentDao {
    private String username;
    private String courseName, courseId;
    private ArrayList<Student> courseList = new ArrayList<Student>();

    @Override
    public ArrayList<Student> displayCourses() {

        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        try {
            username = CurrentUser.getInstance().getBannerId();
            procedure = new CallStoredProcedure("spGetEnrolledCourses(?)");
            procedure.setParameter(1, username);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                courseId = resultSet.getString(1);
                courseName = resultSet.getString(2);
                courseList.add(new Student(courseId, courseName));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return courseList;
    }
}