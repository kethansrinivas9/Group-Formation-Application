package com.group8.dalsmartteamwork.admin.models;

import com.group8.dalsmartteamwork.admin.dao.ICourseManagerDao;
import com.group8.dalsmartteamwork.course.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CourseManagerImpl implements ICourseManager {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final ICourseManagerDao courseManagerDao;
    private String instructorID;

    public CourseManagerImpl(ICourseManagerDao courseManagerDao) {
        this.courseManagerDao = courseManagerDao;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseManagerDao.getAllCourses();
    }

    @Override
    public boolean createNewCourse(Course courseDetails) {
        if (courseDetails.getInstructorID().equals("Select an Instructor")) {
            instructorID = courseDetails.getInstructorID();
        } else {
            instructorID = courseDetails.getInstructorID().split(",")[0];
        }

        return courseManagerDao.createNewCourse(courseDetails.getCourseName(), courseDetails.getCourseID(), instructorID);
    }

    public boolean updateCourse(String newCourseName, int newCourseID, String instructorId, int oldCourseID) {
        if (instructorId.equals("Select an Instructor")) {
            LOGGER.warn("Instructor is not selected. CourseID: " + newCourseID);
            return false;
        } else {
            return courseManagerDao.updateCourse(newCourseName, newCourseID, instructorId, oldCourseID);
        }
    }

    @Override
    public boolean deleteCourse(String courseID) {
        return courseManagerDao.deleteCourse(courseID);
    }
}
