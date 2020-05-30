package com.group8.dalsmartteamwork.utils;

import java.io.InputStream;
import java.util.Properties;
import java.sql.*;

public class DbConnection {

    private String ENVIRONMENT;
    private String USER;
    private String PASSWORD;
    private String CONNECTION;
    private String DATABASE;
    private Statement statement;
    public Connection conn = null;

    public DbConnection()
    {
        try {
            Properties properties = new Properties();
            Thread thread = Thread.currentThread();
            ClassLoader classLoader = thread.getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("application.properties");
            if(inputStream!=null)
            {
                properties.load(inputStream);
                this.ENVIRONMENT = properties.getProperty("db.environment");
                this.CONNECTION = properties.getProperty("db.connection");
                switch(this.ENVIRONMENT)
                {
                    case "TEST":
                        this.DATABASE=properties.getProperty("db.test.database");
                        this.USER = properties.getProperty("db.test.user");
                        this.PASSWORD = properties.getProperty("db.test.password");
                        break;

                    case "PRODUCTION":
                        this.DATABASE = properties.getProperty("db.prod.database");
                        this.USER = properties.getProperty("db.prod.user");
                        this.PASSWORD = properties.getProperty("db.prod.password");
                        break;

                    default:
                        this.DATABASE = properties.getProperty("db.dev.database");
                        this.USER = properties.getProperty("db.dev.user");
                        this.PASSWORD = properties.getProperty("db.dev.password");
                
                }
                conn = DriverManager.getConnection(this.CONNECTION + this.DATABASE, this.USER, this.PASSWORD);
                this.statement=conn.createStatement();

            }
        }catch(Exception e)
        {
            e.printStackTrace();
            this.statement=null;
        }
    }
    public Statement getStatement()
    {
        return this.statement;
    }
}