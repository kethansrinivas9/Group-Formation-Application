package com.group8.dalsmartteamwork.courseinstructor.models;

import com.group8.dalsmartteamwork.course.dao.ICourseDao;
import com.group8.dalsmartteamwork.utils.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseInstructorManagerImpl implements ICourseInstructorManager {
    private final ICourseDao courseDao;

    public CourseInstructorManagerImpl(ICourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<User> getCurrentTAs(int courseID) {
        List<User> currentTAs = new ArrayList<>();
        try {
            currentTAs = courseDao.getCurrentTAs(courseID);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return currentTAs;
    }

    @Override
    public List<User> getCurrentStudents(int courseID) {
        List<User> currentStudents = new ArrayList<>();
        try {
            currentStudents = courseDao.getCurrentStudents(courseID);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return currentStudents;
    }

    @Override
    public Boolean courseExists(int courseID) {
        try {
            if (courseDao.courseExists(courseID)) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> getEligibleTAs(int courseID) {
        List<User> eligibleTAs = new ArrayList<>();
        try {
            eligibleTAs = courseDao.getUsersForTA(courseID);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return eligibleTAs;
    }

    @Override
    public Boolean addTAtoCourse(String bannerID, int courseID) {
        try {
            if (courseDao.addTAtoCourse(bannerID, courseID)) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}
