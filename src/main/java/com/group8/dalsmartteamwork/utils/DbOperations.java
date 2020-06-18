package com.group8.dalsmartteamwork.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbOperations {
    private DbConnection dbConnection;
    private Statement statement;

    public DbOperations(){
        dbConnection = DbConnection.getInstance();
        statement = dbConnection.getStatement();
    }

    public ResultSet getRecords(String query) {
        try {
            return statement.executeQuery(query);
        } catch (Exception e) {
            // TODO: Add to Log
            e.printStackTrace();
            return null;
        }
    }

    public int updateRecords(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (Exception e) {
            // TODO: Add to Log
            e.printStackTrace();
            return 0;
        }
    }

    public int addRecords(String query) {
        return this.updateRecords(query);
    }

    public int deleteRecords(String query) {
        return this.updateRecords(query);
    }

    public void cleanup(){
        try{
            if(statement != null){
                statement.close();
            }
            if(dbConnection != null){
                dbConnection.closeConnection();
            }
        } catch(SQLException e){
            //TODO: Add to Log
            e.printStackTrace();
        }

    }


}
