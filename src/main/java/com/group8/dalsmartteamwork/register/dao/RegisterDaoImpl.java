package com.group8.dalsmartteamwork.register.dao;

import com.group8.dalsmartteamwork.MySQLConnection;

public class RegisterDaoImpl implements RegisterDao {

    @Override
    public Boolean setUserDetails(String id, String firstName, String lastName, String email, String password) {
        try {
            MySQLConnection connection = new MySQLConnection();
            String query = String.format("INSERT INTO Users VALUES ('%s', '%s', '%s', '%s', '%s')", id, lastName,
                    firstName, email, password);
            System.out.println("query is" + query);
            int noRecords = connection.updateRecords(query);
            if (noRecords > 0) {
                return true;
            } else
                return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}