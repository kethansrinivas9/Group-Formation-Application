package com.group8.dalsmartteamwork.admin.dao;

import com.group8.dalsmartteamwork.course.model.Course;
import com.group8.dalsmartteamwork.utils.DbConnection;
import com.group8.dalsmartteamwork.utils.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    int courseID;
    String courseName, bannerID, firstName, lastName;
    Course course;
    User user;
    List<Course> courseList;
    List<String> nonAdminUsersList;
    DbConnection dbConnection;

    public List<Course> getAllCourses() {
        courseList = new ArrayList<Course>();
        try {
            String query = String.format(AdminQueryConstants.GET_ALL_COURSES);
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            ResultSet rs = dbConnection.getRecords(query);

            while (rs.next()) {
                courseID = Integer.parseInt(rs.getObject("CourseID").toString());
                courseName = rs.getObject("CourseName").toString();
                course = new Course(courseID, courseName);
                courseList.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return courseList;
    }

    public List<String> getListOfNonAdminUsers() {
        nonAdminUsersList = new ArrayList<String>();
        try {
            String query = String.format(AdminQueryConstants.GET_ALL_NON_ADMIN_USERS);
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            ResultSet rs = dbConnection.getRecords(query);

            while (rs.next()) {
                bannerID = rs.getObject("BannerID").toString();
                firstName = rs.getObject("FirstName").toString();
                lastName = rs.getObject("LastName").toString();
                user = new User(bannerID, firstName, lastName);
                nonAdminUsersList.add(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return nonAdminUsersList;
    }

    public boolean createNewCourse(Course courseDetails) {
        try {
            String createCourseQuery = String.format(AdminQueryConstants.CREATE_COURSE, courseDetails.getCourseID(), courseDetails.getCourseName());
            String createInstructorQuery = String.format(AdminQueryConstants.CREATE_INSTRUCTOR, courseDetails.getInstructorID(), courseDetails.getCourseID(), '4');
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            int createCourseResultSet = dbConnection.addRecords(createCourseQuery);

            if (createCourseResultSet >= 0) {
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

    public boolean updateCourse(String newCourseName, int newCourseID, String instructorID, int oldCourseID) {
        try {
            String updateCourseQuery = String.format(AdminQueryConstants.UPDATE_COURSE, newCourseName, newCourseID, oldCourseID);
            String updateInstructorQuery = String.format(AdminQueryConstants.UPDATE_INSTRUCTOR, instructorID, newCourseID);
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            int courseUpdateResultSet = dbConnection.updateRecords(updateCourseQuery);
            int instructorUpdateResultSet = dbConnection.updateRecords(updateInstructorQuery);

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

    public String getCourseInstructor(String courseID) {
        try {
            String query = String.format(AdminQueryConstants.GET_INSTRUCTOR_ID, courseID);
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            ResultSet rs = dbConnection.getRecords(query);

            while (rs.next()) {
                bannerID = rs.getObject("BannerID").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return bannerID;
    }
}