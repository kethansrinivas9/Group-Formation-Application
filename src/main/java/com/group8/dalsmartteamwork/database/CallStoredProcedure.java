package com.group8.dalsmartteamwork.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallStoredProcedure {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final String procedureName;
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
            LOGGER.error("Exception occurred while creating a statement from the database connection.", e);
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
            LOGGER.error("Exception occurred while cleaning up the database resources.", e);
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
