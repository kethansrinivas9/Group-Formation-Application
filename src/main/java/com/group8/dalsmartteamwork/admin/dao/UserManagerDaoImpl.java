package com.group8.dalsmartteamwork.admin.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.accesscontrol.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserManagerDaoImpl implements IUserManagerDao {
    String bannerID, firstName, lastName;
    User user;

    public List<String> getListOfNonAdminUsers() {
        List<String> nonAdminUsersList = new ArrayList<String>();
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("spGetNonAdminUsers()");
            ResultSet rs = storedProcedure.executeWithResults();

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
            storedProcedure.cleanup();
        }
        return nonAdminUsersList;
    }

    public String getCourseInstructor(String courseID) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("spGetCourseInstructors(?)");
            storedProcedure.setParameter(1, courseID);
            ResultSet rs = storedProcedure.executeWithResults();

            while (rs.next()) {
                bannerID = rs.getObject("BannerID").toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            storedProcedure.cleanup();
        }
        return bannerID;
    }

    public List<String> getUsersWhoAreGuestsOrInstructors(String courseID) {
        CallStoredProcedure storedProcedure = null;
        List<String> guestsAndInstructorsList = new ArrayList<String>();
        try {
            storedProcedure = new CallStoredProcedure("spGetGuestsAndInstructors()");
            ResultSet rs = storedProcedure.executeWithResults();

            while (rs.next()) {
                bannerID = rs.getObject("BannerID").toString();
                guestsAndInstructorsList.add(bannerID);
            }

            if (courseID.isEmpty()) {
                guestsAndInstructorsList.add(0, "Select an Instructor");
            } else {
                String currentInstructorBannerID = "Select an Instructor";
                storedProcedure = new CallStoredProcedure("spGetCourseInstructors(?)");
                storedProcedure.setParameter(1, courseID);
                rs = storedProcedure.executeWithResults();
                while (rs.next()) {
                    currentInstructorBannerID = rs.getObject("BannerID").toString();
                }
                guestsAndInstructorsList.remove(currentInstructorBannerID);
                guestsAndInstructorsList.add(0, currentInstructorBannerID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            storedProcedure.cleanup();
        }
        return guestsAndInstructorsList;
    }
}