package com.group8.dalsmartteamwork.admin.dao;

import com.group8.dalsmartteamwork.course.model.Course;
import com.group8.dalsmartteamwork.utils.DbConnection;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseManagerDaoImpl implements ICourseManagerDao{
    String courseID;
    String courseName;
    final String INSTRUCTOR_ROLE_ID = "4";
    Course course;
    DbConnection dbConnection;
    List<Course> courseList;

    @Override
    public List<Course> getAllCourses() {
        courseList = new ArrayList<Course>();
        try {
            String query = String.format(AdminQueryConstants.GET_ALL_COURSES);
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            ResultSet rs = dbConnection.getRecords(query);

            while (rs.next()) {
                courseID = rs.getObject("CourseID").toString();
                courseName = rs.getObject("CourseName").toString();
                course = new Course(Integer.parseInt(courseID), courseName);
                courseList.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return courseList;
    }

    @Override
    public boolean createNewCourse(String courseName, int courseID, String instructorId) {
        try {
            String createCourseQuery = String.format(AdminQueryConstants.CREATE_COURSE, courseID, courseName);
            String createInstructorQuery = String.format(AdminQueryConstants.CREATE_INSTRUCTOR, instructorId, courseID, '4');
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            int createCourseResultSet = dbConnection.addRecords(createCourseQuery);

            if (createCourseResultSet >= 0 && instructorId != "Select an Instructor") {
                System.out.println(createInstructorQuery);
                int createInstructorResultSet = dbConnection.addRecords(createInstructorQuery);
                if(createInstructorResultSet >= 0) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return false;
    }

    @Override
    public boolean updateCourse(String newCourseName, int newCourseID, String instructorID, int oldCourseID) {
        try {
            String updateCourseQuery = String.format(AdminQueryConstants.UPDATE_COURSE, newCourseName, newCourseID, oldCourseID);
            String updateInstructorQuery = String.format(AdminQueryConstants.UPDATE_INSTRUCTOR, instructorID, newCourseID, INSTRUCTOR_ROLE_ID);
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            int courseUpdateResultSet = dbConnection.updateRecords(updateCourseQuery);
            int instructorUpdateResultSet = dbConnection.updateRecords(updateInstructorQuery);

            if (instructorUpdateResultSet <= 0) {
                String createInstructorQuery = String.format(AdminQueryConstants.CREATE_INSTRUCTOR, instructorID, newCourseID, "4" );
                instructorUpdateResultSet = dbConnection.addRecords(createInstructorQuery);
            }

            if (courseUpdateResultSet >= 0 && instructorUpdateResultSet >= 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return false;
    }

    @Override
    public boolean deleteCourse(String courseID) {
        try {
            String query = String.format(AdminQueryConstants.DELETE_COURSE, courseID);
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            int rs = dbConnection.deleteRecords(query);

            if (rs >= 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return false;
    }
}
