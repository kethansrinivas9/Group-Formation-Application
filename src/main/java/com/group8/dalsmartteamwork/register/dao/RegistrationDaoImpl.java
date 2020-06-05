package com.group8.dalsmartteamwork.register.dao;

import com.group8.dalsmartteamwork.utils.DbConnection;
import com.group8.dalsmartteamwork.utils.User;
//import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.ResultSet;

public class RegistrationDaoImpl implements RegistrationDao {
    private DbConnection dbConnection;

    @Override
    public Boolean isUserInDb(String id) {
        try {
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();

            String selectQuery = String.format("SELECT * FROM Users where BannerId='%s'", id);
            ResultSet resultSet = dbConnection.getRecords(selectQuery);
            Boolean status = resultSet.next();
            return status;
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return false;
    }

    @Override
    public Boolean addUserToDb(User user) {
        try {
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();

            String insertQuery = String.format("INSERT INTO Users VALUES('%s', '%s', '%s', '%s', '%s')",
                    user.getId(), user.getLastName(), user.getFirstName(), user.getEmail(), user.getPassword());
            int numRecords = dbConnection.updateRecords(insertQuery);
            if (numRecords > 0) {
                return true;
            }
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return false;
    }

    @Override
    public Boolean addGuestRole(String id) {
        try {
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();

            String insertQuery = String.format("INSERT INTO SystemRole VALUES('%s', '%d')", id, 1);
            int numRecords = dbConnection.updateRecords(insertQuery);

            if (numRecords > 0) {
                return true;
            }
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            dbConnection.close();
        }
        return false;
    }

    @Override
    public Boolean assignCourseToUser(String userId, int courseId) {
        try {
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();

            String insertQuery = String.format("INSERT INTO CourseRole VALUES('%s', '%d', '%d')",
                    userId, courseId, 2);
            int numRecords = dbConnection.updateRecords(insertQuery);
            if (numRecords > 0) {
                return true;
            }
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return false;
    }
}