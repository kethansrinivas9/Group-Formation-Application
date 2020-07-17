package com.group8.dalsmartteamwork.course.dao;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements ICourseDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public Boolean courseExists(int courseID) {
        CallStoredProcedure storedProcedure = null;
        ResultSet rs;
        try {
            storedProcedure = new CallStoredProcedure("spGetCourse(?)");
            storedProcedure.setParameter(1, courseID);
            rs = storedProcedure.executeWithResults();
            while (rs.next()) {
                return true;
            }
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while fetching course from the database.", exception);
        } finally {
            if (null != storedProcedure) {
                storedProcedure.cleanup();
            }
        }
        return false;
    }

    @Override
    public List<User> getUsersForTA(int courseID) {
        List<User> users = new ArrayList<>();
        CallStoredProcedure storedProcedure = null;
        ResultSet rs;
        try {
            storedProcedure = new CallStoredProcedure("spGetEligibleTAs(?)");
            storedProcedure.setParameter(1, courseID);
            rs = storedProcedure.executeWithResults();
            while (rs.next()) {
                users.add(new User(rs.getString("BannerID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        ""));
            }
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while fetching eligible TAs from the database.", exception);
        } finally {
            if (null != storedProcedure) {
                storedProcedure.cleanup();
            }
        }
        return users;
    }

    @Override
    public List<User> getCurrentTAs(int courseID) {
        List<User> taList = new ArrayList<>();
        CallStoredProcedure storedProcedure = null;
        ResultSet rs;
        try {
            storedProcedure = new CallStoredProcedure("spGetCurrentTAs(?)");
            storedProcedure.setParameter(1, courseID);
            rs = storedProcedure.executeWithResults();
            while (rs.next()) {
                taList.add(new User(rs.getString("BannerID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        ""));
            }
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while fetching current TAs of course from the database.", exception);
        } finally {
            if (null != storedProcedure) {
                storedProcedure.cleanup();
            }
        }
        return taList;
    }

    @Override
    public List<User> getCurrentStudents(int courseID) {
        List<User> studentList = new ArrayList<>();
        CallStoredProcedure storedProcedure = null;
        ResultSet rs;
        try {
            storedProcedure = new CallStoredProcedure("spGetCurrentStudents(?)");
            storedProcedure.setParameter(1, courseID);
            rs = storedProcedure.executeWithResults();
            while (rs.next()) {
                studentList.add(new User(rs.getString("BannerID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), ""));
            }
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while fetching current students in course from the database.", exception);
        } finally {
            if (null != storedProcedure) {
                storedProcedure.cleanup();
            }
        }
        return studentList;
    }

    @Override
    public String getCourseName(int courseID) {
        String result = "notfound";
        CallStoredProcedure storedProcedure = null;
        ResultSet rs;
        try {
            storedProcedure = new CallStoredProcedure("spGetCourseName(?)");
            storedProcedure.setParameter(1, courseID);
            rs = storedProcedure.executeWithResults();
            while (rs.next()) {
                result = rs.getString("BannerID");
            }
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while fetching course name from the database.", exception);
        } finally {
            if (null != storedProcedure) {
                storedProcedure.cleanup();
            }
        }
        return result;
    }

    @Override
    public Boolean addTAtoCourse(String bannerID, int courseID) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("spAddTAtoCourse(?, ?)");
            storedProcedure.setParameter(1, bannerID);
            storedProcedure.setParameter(2, courseID);
            storedProcedure.execute();
            return true;
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while adding TA to a course in the database.", exception);
            return false;
        } finally {
            if (null != storedProcedure) {
                storedProcedure.cleanup();
            }
        }
    }
}
