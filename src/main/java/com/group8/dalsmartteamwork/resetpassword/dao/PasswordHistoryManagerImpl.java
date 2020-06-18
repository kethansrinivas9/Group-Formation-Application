package com.group8.dalsmartteamwork.resetpassword.dao;

import com.group8.dalsmartteamwork.utils.DbConnection;
import com.group8.dalsmartteamwork.utils.Encryption;

import java.sql.ResultSet;
import java.sql.Statement;

public class PasswordHistoryManagerImpl implements IPasswordHistoryManager {

    DbConnection connection;

    @Override
    public Boolean moveCurrentPassword(String bannerID) {
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format(PasswordHistoryQueryConstants.CALL_MOVE_CURRENT_PASSWORD, bannerID);
            Statement statement = connection.getStatement();
            Boolean records = statement.execute(query);
            statement.close();
            return records;
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        } finally {
            connection.closeConnection();
        }
        return false;
    }

    @Override
    public Boolean passwordExists(String bannerID, String password) {
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            Encryption encryption = new Encryption();
            String encryptedPassword = encryption.encrypt(password);
            String query = String.format(PasswordHistoryQueryConstants.GET_PASSWORD_HISTORY, bannerID, encryptedPassword);
            ResultSet rs = connection.getRecords(query);
            while (rs.next()) {
                return true;
            }
            rs.close();
            query = String.format(PasswordHistoryQueryConstants.GET_CURRENT_PASSWORD, bannerID);
            ResultSet currentPasswordResultSet = connection.getRecords(query);
            while (currentPasswordResultSet.next()) {
                if (encryptedPassword.equals(currentPasswordResultSet.getString("Password"))) {
                    return true;
                }
            }
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        } finally {
            connection.closeConnection();
        }
        return false;
    }
}
