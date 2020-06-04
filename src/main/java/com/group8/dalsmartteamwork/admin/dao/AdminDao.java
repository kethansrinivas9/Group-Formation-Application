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
            String query = String.format(AdminQueryConstants.CREATE_COURSE, courseDetails.getCourseID(), courseDetails.getCourseName());
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            int rs = dbConnection.addRecords(query);

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

    public boolean updateCourse(String newCourseName, int newCourseID, int oldCourseID) {
        try {
            String query = String.format(AdminQueryConstants.UPDATE_COURSE, newCourseName, newCourseID, oldCourseID);
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            int rs = dbConnection.updateRecords(query);

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

    public boolean assignInstructorToCourse(String bannerID, String courseID, int roleID) {
        return false;
    }
}