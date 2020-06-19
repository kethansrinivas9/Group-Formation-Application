package com.group8.dalsmartteamwork.student.dao;

import com.group8.dalsmartteamwork.student.Student;
import com.group8.dalsmartteamwork.utils.CallStoredProcedure;
import com.group8.dalsmartteamwork.utils.DbConnection;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDaoImpl implements IStudentDao {
    public String username;
    Student student;
    String courseName, courseId;
    ArrayList<Student> courseList = new ArrayList<Student>();
    DbConnection dbConnection;
    HttpServletRequest request;

    @Override
    public ArrayList<Student> displayCourses() {

        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        try {
            username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            procedure = new CallStoredProcedure("spDisplayCourses(?)");
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