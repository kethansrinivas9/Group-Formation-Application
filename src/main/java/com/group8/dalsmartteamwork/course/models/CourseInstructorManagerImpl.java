package com.group8.dalsmartteamwork.course.models;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.course.dao.ICourseDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseInstructorManagerImpl implements ICourseInstructorManager {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	private final ICourseDao courseDao;

	public CourseInstructorManagerImpl(ICourseDao courseDao) {
		this.courseDao = courseDao;
	}

	@Override
	public List<User> getCurrentTAs(int courseID) {
		List<User> currentTAs = new ArrayList<>();
		try {
			currentTAs = courseDao.getCurrentTAs(courseID);
			LOGGER.info(String.format("Fetched TAs of the course with CourseID: %s", courseID));
		} catch (SQLException exception) {
			LOGGER.error("Exception occurred while fetching current TAs in course. ", exception);
		}
		return currentTAs;
	}

	@Override
	public List<User> getCurrentStudents(int courseID) {
		List<User> currentStudents = new ArrayList<>();
		try {
			currentStudents = courseDao.getCurrentStudents(courseID);
			LOGGER.info(String.format("Fetched students enrolled to the course with CourseID: %s", courseID));
		} catch (SQLException exception) {
			LOGGER.error("Exception occurred while fetching current students in course. ", exception);
		}
		return currentStudents;
	}

	@Override
	public Boolean courseExists(int courseID) {
		try {
			if (courseDao.courseExists(courseID)) {
				LOGGER.info(String.format("Course with the CourseID: %d exists", courseID));
				return true;
			}
		} catch (SQLException exception) {
			LOGGER.error("Exception occurred while checking if the course exists. ", exception);
		}
		return false;
	}

	@Override
	public List<User> getEligibleTAs(int courseID) {
		List<User> eligibleTAs = new ArrayList<>();
		try {
			eligibleTAs = courseDao.getUsersForTA(courseID);
			LOGGER.info(String.format("Fetched Eligible TAs. CourseID: %s", courseID));
		} catch (SQLException exception) {
			LOGGER.error("Exception occurred while fetching eligible TAs for course.", exception);
		}
		return eligibleTAs;
	}

	@Override
	public Boolean addTAtoCourse(String bannerID, int courseID) {
		try {
			if (courseDao.addTAtoCourse(bannerID, courseID)) {
				LOGGER.info(String.format("TA Added. BannerID: %s, CourseID: %s", bannerID, courseID));
				return true;
			}
		} catch (SQLException exception) {
			LOGGER.error("Exception occurred while assigning TA to course.", exception);
		}
		return false;
	}
}
