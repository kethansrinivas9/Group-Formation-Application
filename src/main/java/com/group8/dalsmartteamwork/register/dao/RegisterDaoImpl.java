package com.group8.dalsmartteamwork.register.dao;

import com.group8.dalsmartteamwork.MySQLConnection;

public class RegisterDaoImpl implements RegisterDao {

    @Override
    public Boolean setUserDetails(long id, String name, String email, String password) {
        try {
            MySQLConnection connection = new MySQLConnection("DEV_INT");
            String query = String.format("INSERT INTO Users VALUES (%d, '%s', '%s', '%s')", id, name, email, password);
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