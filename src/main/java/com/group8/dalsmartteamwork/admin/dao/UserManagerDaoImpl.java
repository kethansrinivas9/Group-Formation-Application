package com.group8.dalsmartteamwork.admin.dao;

import com.group8.dalsmartteamwork.utils.DbConnection;
import com.group8.dalsmartteamwork.utils.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserManagerDaoImpl implements IUserManagerDao {
    String bannerID, firstName, lastName;
    final String INSTRUCTOR_ROLE_ID = "4";
    final String GUEST_ROLE_ID = "1";
    User user;
    List<String> nonAdminUsersList;
    List<String> guestsOrInstructorsList;
    DbConnection dbConnection;

    public List<String> getListOfNonAdminUsers() {
        nonAdminUsersList = new ArrayList<String>();
        try {
            String query = String.format(AdminQueryConstants.GET_ALL_NON_ADMIN_USERS, GUEST_ROLE_ID);
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

    public String getCourseInstructor(String courseID) {
        try {
            String query = String.format(AdminQueryConstants.GET_INSTRUCTOR_ID, courseID, INSTRUCTOR_ROLE_ID);
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

    public List<String> getUsersWhoAreGuestsOrInstructors(String courseID){
        guestsOrInstructorsList = new ArrayList<String>();
        try {

            String guestUserOrInstructorQuery = String.format(AdminQueryConstants.GET_USERS_WHO_ARE_GUEST_OR_INSTRUCTOR, INSTRUCTOR_ROLE_ID, GUEST_ROLE_ID);
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();

            ResultSet rs = dbConnection.getRecords(guestUserOrInstructorQuery);

            while (rs.next()) {
                bannerID = rs.getObject("BannerID").toString();
                guestsOrInstructorsList.add(bannerID);
            }

            if (courseID.isEmpty()) {
                guestsOrInstructorsList.add(0, "Select an Instructor");
            } else {
                String currentInstructorBannerID = "Select an Instructor";
                String instructorIdQuery = String.format(AdminQueryConstants.GET_INSTRUCTOR_ID, courseID, INSTRUCTOR_ROLE_ID);
                rs = dbConnection.getRecords(instructorIdQuery);
                while (rs.next()) {
                    currentInstructorBannerID = rs.getObject("BannerID").toString();
                }
                guestsOrInstructorsList.remove(currentInstructorBannerID);
                guestsOrInstructorsList.add(0, currentInstructorBannerID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return guestsOrInstructorsList;
    }
}