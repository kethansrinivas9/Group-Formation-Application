package com.group8.dalsmartteamwork.register.dao;

import com.group8.dalsmartteamwork.utils.DbConnection;
import com.group8.dalsmartteamwork.utils.User;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.ResultSet;

public class RegistrationDaoImpl implements RegistrationDao {

    @Override
    public Boolean isUserInDb(String id){
        try {
            DbConnection dbConnection = new DbConnection();
            String selectQuery = String.format("SELECT * FROM Users where BannerId='%s'", id);
            ResultSet resultSet = dbConnection.getRecords(selectQuery);
            Boolean status = resultSet.next();
            dbConnection.close();
            return status;
        }
        catch (Exception e){
            //TODO: Add to Log
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean addUserToDb(User user){
        try {
            DbConnection dbConnection = new DbConnection();
            String insertQuery = String.format("INSERT INTO Users VALUES('%s', '%s', '%s', '%s', '%s')",
                    user.getId(), user.getLastName(), user.getFirstName(), user.getEmail(), user.getPassword());
            int numRecords = dbConnection.updateRecords(insertQuery);
            dbConnection.close();
            return numRecords>0;
        }
        catch (Exception e){
            //TODO: Add to Log
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean addGuestRole(String id) {
        try{
            DbConnection dbConnection = new DbConnection();
            String insertQuery = String.format("INSERT INTO SystemRole VALUES('%s', '%d')", id, 1);
            int numRecords = dbConnection.updateRecords(insertQuery);
            dbConnection.close();
            return numRecords>0;
        }
        catch (Exception e){
            //TODO: Add to Log
            return false;
        }
    }


}