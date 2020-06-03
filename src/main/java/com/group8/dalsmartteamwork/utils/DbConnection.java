package com.group8.dalsmartteamwork.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbConnection {
    private String environment;
    private String user;
    private String password;
    private String connection;
    private String database;
    private Statement statement;
    private Connection conn;
    private static DbConnection dbConnection;
    private static final String IGNORE_TIME_ZONE = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private DbConnection() {
    }

    public static DbConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DbConnection();
        }
        return dbConnection;
    }

    public void createDbConnection() {
        try {
            Properties properties = new Properties();
            Thread currentThread = Thread.currentThread();
            ClassLoader contextClassLoader = currentThread.getContextClassLoader();
            InputStream propertiesStream = contextClassLoader.getResourceAsStream("application.properties");
            if (propertiesStream != null) {
                properties.load(propertiesStream);
                this.environment = properties.getProperty("db.environment");
                this.connection = properties.getProperty("db.connection");
                switch (this.environment) {
                    case "TEST":
                        this.database = properties.getProperty("db.test.database");
                        this.user = properties.getProperty("db.test.user");
                        this.password = properties.getProperty("db.test.password");
                        break;

                    case "PRODUCTION":
                        this.database = properties.getProperty("db.prod.database");
                        this.user = properties.getProperty("db.prod.user");
                        this.password = properties.getProperty("db.prod.password");
                        break;

                    default:
                        this.database = properties.getProperty("db.dev.database");
                        this.user = properties.getProperty("db.dev.user");
                        this.password = properties.getProperty("db.dev.password");
                }
                conn = DriverManager.getConnection(this.connection + this.database + this.IGNORE_TIME_ZONE, this.user,
                        this.password);
                this.statement = conn.createStatement();
            }
        } catch (Exception e) {
            // TODO: Add to Log
            e.printStackTrace();
            this.statement = null;
        }
    }

    public void closeConnection() {
        try {
            if (conn.isValid(120)) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
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