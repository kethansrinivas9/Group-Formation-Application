package com.group8.dalsmartteamwork.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallStoredProcedure {
    private String procedureName;
    private DbConnection dbConnection;
    private Connection connection;
    private CallableStatement statement;

    public CallStoredProcedure(String procedureName) {
        this.procedureName = procedureName;
        connection = null;
        statement = null;
        openConnection();
        createStatement();
    }

    private void openConnection() {
        dbConnection = DbConnection.getInstance();
        dbConnection.createDbConnection();
        connection = dbConnection.getConnection();
    }

    private void createStatement() {
        try {
            statement = connection.prepareCall("{call " + procedureName + "}");
        } catch (SQLException e) {
            e.printStackTrace();
            //TODO: Add to Log
        }

    }

    public void cleanup() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (dbConnection != null) {
                dbConnection.closeConnection();
            }
        } catch (SQLException e) {
            //TODO: Add to Log
            e.printStackTrace();
        }

    }

    public void setParameter(int paramIndex, String value) throws SQLException {
        statement.setString(paramIndex, value);
    }

    public void registerOutputParameterString(int paramIndex) throws SQLException {
        statement.registerOutParameter(paramIndex, java.sql.Types.VARCHAR);
    }

    public void setParameter(int paramIndex, long value) throws SQLException {
        statement.setLong(paramIndex, value);
    }

    public void registerOutputParameterLong(int paramIndex) throws SQLException {
        statement.registerOutParameter(paramIndex, java.sql.Types.BIGINT);
    }

    public ResultSet executeWithResults() throws SQLException {
        if (statement.execute()) {
            return statement.getResultSet();
        }
        return null;
    }

    public void execute() throws SQLException {
        statement.execute();
    }

}
