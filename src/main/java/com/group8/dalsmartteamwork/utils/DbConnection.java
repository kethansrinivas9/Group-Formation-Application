package com.group8.dalsmartteamwork.utils;

import java.sql.*;

public class DbConnection {
    private String ENVIRONMENT;
    private String USER;
    private String PASSWORD;
    private String CONNECTION;
    private String DATABASE;
    private Statement statement;
    private Connection conn;

    public DbConnection() {

        try {
            Props properties = new Props();
            this.ENVIRONMENT = properties.getValue("db.environment");
            this.CONNECTION = properties.getValue("db.connection");
            switch (this.ENVIRONMENT) {
                case "TEST":
                    this.DATABASE = properties.getValue("db.test.database");
                    this.USER = properties.getValue("db.test.user");
                    this.PASSWORD = properties.getValue("db.test.password");
                    break;

                case "PRODUCTION":
                    this.DATABASE = properties.getValue("db.prod.database");
                    this.USER = properties.getValue("db.prod.user");
                    this.PASSWORD = properties.getValue("db.prod.password");
                    break;

                default:
                    this.DATABASE = properties.getValue("db.dev.database");
                    this.USER = properties.getValue("db.dev.user");
                    this.PASSWORD = properties.getValue("db.dev.password");
            }
            this.conn = DriverManager.getConnection(this.CONNECTION + this.DATABASE + "?serverTimezone=" + properties.getValue("db.timezone"), this.USER, this.PASSWORD);
            this.statement = conn.createStatement();

        } catch (Exception e) {
            // TODO: Add to Log
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
            // TODO: Add to Log
            e.printStackTrace();
            return null;
        }
    }

    public int updateRecords(String query) {
        try {
            return this.statement.executeUpdate(query);
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

    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
            // TODO: Add to Log
            e.printStackTrace();
        }

    }

}