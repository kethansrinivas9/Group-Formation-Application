package com.group8.dalsmartteamwork.admin.dao;

import com.group8.dalsmartteamwork.course.Course;
import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseManagerDaoImpl implements ICourseManagerDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    String courseID;
    String courseName;
    Course course;
    List<Course> courseList;

    @Override
    public List<Course> getAllCourses() {
        courseList = new ArrayList<Course>();
        CallStoredProcedure storedProcedure = null;
        ResultSet rs;
        try {
            storedProcedure = new CallStoredProcedure("spGetAllCourses()");
            rs = storedProcedure.executeWithResults();

            while (rs.next()) {
                courseID = rs.getObject("CourseID").toString();
                courseName = rs.getObject("CourseName").toString();
                course = new Course(Integer.parseInt(courseID), courseName);
                courseList.add(course);
            }
            LOGGER.info("All courses fetched from the database.");
        } catch (Exception e) {
            LOGGER.error("Exception occurred while fetching all courses from the Database. ", e);
        } finally {
            storedProcedure.cleanup();
        }

        LOGGER.info("Course Deleted. CourseID: " + courseID);
        return courseList;
    }

    @Override
    public boolean createNewCourse(String courseName, int courseID, String instructorId) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("spCreateCourse(?, ?)");
            storedProcedure.setParameter(1, courseID);
            storedProcedure.setParameter(2, courseName);
            storedProcedure.execute();

            if (!instructorId.equals("Select an Instructor")) {
                storedProcedure = new CallStoredProcedure("spCreateInstructor(?, ?)");
                storedProcedure.setParameter(1, instructorId);
                storedProcedure.setParameter(2, courseID);
                storedProcedure.execute();
            }

            LOGGER.info("Course Created. CourseID: " + courseID);
            return true;
        } catch (Exception e) {
            LOGGER.error("Exception occurred while adding new course to the Database. ", e);
        } finally {
            storedProcedure.cleanup();
        }
        return false;
    }

    @Override
    public boolean updateCourse(String newCourseName, int newCourseID, String instructorID, int oldCourseID) {
        CallStoredProcedure storedProcedure = null;
        int updatedRows = 0;
        try {
            storedProcedure = new CallStoredProcedure("spUpdateCourse(?, ?, ?)");
            storedProcedure.setParameter(1, newCourseName);
            storedProcedure.setParameter(2, newCourseID);
            storedProcedure.setParameter(3, oldCourseID);
            storedProcedure.execute();

            storedProcedure = new CallStoredProcedure("spUpdateInstructor(?, ?)");
            storedProcedure.setParameter(1, instructorID);
            storedProcedure.setParameter(2, newCourseID);
            ResultSet rs = storedProcedure.executeWithResults();

            while (rs.next()) {
                updatedRows = rs.getInt(1);
            }

            if (updatedRows <= 0) {
                storedProcedure = new CallStoredProcedure("spCreateInstructor(?, ?)");
                storedProcedure.setParameter(1, instructorID);
                storedProcedure.setParameter(2, newCourseID);
                storedProcedure.execute();
            }

            LOGGER.info("Course updated. CourseID: " + courseID);
            return true;
        } catch (Exception e) {
            LOGGER.error("Exception occurred while updating course in the Database. ", e);
        } finally {
            storedProcedure.cleanup();
        }
        return false;
    }

    @Override
    public boolean deleteCourse(String courseID) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("spDeleteCourse(?)");
            storedProcedure.setParameter(1, courseID);
            storedProcedure.execute();
            LOGGER.info("Course Deleted. CourseID: " + courseID);
            return true;
        } catch (Exception e) {
            LOGGER.error("Exception occurred while deleting course in the Database. ", e);
        } finally {
            storedProcedure.cleanup();
        }
        return false;
    }
}
