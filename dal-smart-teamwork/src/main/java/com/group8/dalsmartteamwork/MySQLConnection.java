package com.group8.dalsmartteamwork;

import java.sql.*;

public class MySQLConnection {
    public final String ENVIRONMENT;
    private final String USER;
    private final String PASSWORD;
    private static final String CONNECTION_STRING = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_8_DEVINT";
    private Statement statement;

    public MySQLConnection(String ENVIRONMENT) {
        this.ENVIRONMENT = ENVIRONMENT;
        this.USER = "CSCI5308_8_DEVINT_USER";
        this.PASSWORD = "CSCI5308_8_DEVINT_8189";

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING, this.USER, this.PASSWORD);
            this.statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            this.statement = null;
        }

    }

    public Statement getStatement() {
        return this.statement;
    }

    public ResultSet getRecords(String query) {
        try {
            return this.statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int updateRecords(String query) {
        try {
            return this.statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}