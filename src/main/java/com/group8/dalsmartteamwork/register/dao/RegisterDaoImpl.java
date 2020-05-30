package com.group8.dalsmartteamwork.register.dao;

import com.group8.dalsmartteamwork.utils.DbConnection;

public class RegisterDaoImpl implements RegisterDao {

    @Override
    public Boolean setUserDetails(String id, String firstName, String lastName, String email, String password) {
        try {
            DbConnection connection = new DbConnection();
            String query = String.format("INSERT INTO Users VALUES ('%s', '%s', '%s', '%s', '%s')", id, lastName,
                    firstName, email, password);
            System.out.println("query is" + query);
            int numRecords = connection.updateRecords(query);
            if (numRecords > 0) {
                return true;
            } else
                return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}