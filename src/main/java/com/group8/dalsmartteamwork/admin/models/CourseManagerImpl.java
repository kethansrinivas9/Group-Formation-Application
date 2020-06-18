package com.group8.dalsmartteamwork.admin.models;

import com.group8.dalsmartteamwork.admin.dao.ICourseManagerDao;
import com.group8.dalsmartteamwork.course.model.Course;

import java.util.List;

public class CourseManagerImpl implements ICourseManager {
    private ICourseManagerDao courseManagerDao;

    public CourseManagerImpl(ICourseManagerDao courseManagerDao) {
        this.courseManagerDao = courseManagerDao;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseManagerDao.getAllCourses();
    }

    @Override
    public boolean createNewCourse(Course courseDetails) {
        String instructorID;
        if (!courseDetails.getInstructorID().equals("Select an Instructor")) {
            instructorID = courseDetails.getInstructorID().split(",")[0];
        } else {
            instructorID = courseDetails.getInstructorID();
        }
        return courseManagerDao.createNewCourse(courseDetails.getCourseName(), courseDetails.getCourseID(), instructorID);
    }

    public boolean updateCourse(String newCourseName, int newCourseID, String instructorId, int oldCourseID) {
        if (!instructorId.equals("Select an Instructor")) {
            return courseManagerDao.updateCourse(newCourseName, newCourseID, instructorId, oldCourseID);
        }
        return false;
    }

    @Override
    public boolean deleteCourse(String courseID) {
        return courseManagerDao.deleteCourse(courseID);
    }
}
