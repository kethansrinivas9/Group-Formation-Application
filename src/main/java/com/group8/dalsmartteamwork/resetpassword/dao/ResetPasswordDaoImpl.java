package com.group8.dalsmartteamwork.resetpassword.dao;

import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;
import com.group8.dalsmartteamwork.utils.DbConnection;
import com.group8.dalsmartteamwork.utils.ResetToken;
import com.group8.dalsmartteamwork.utils.User;

import java.sql.ResultSet;
import java.sql.Statement;

public class ResetPasswordDaoImpl implements ResetPasswordDao {
    DbConnection connection;

    public ResetPasswordDaoImpl() {
        updateTokenStatus();
    }

    //TODO: Replace resultset's label names with index

    @Override
    public Boolean addToken(String bannerID) {
        ResetToken resetToken = new ResetToken();
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String token = resetToken.createToken();
            String query = String.format(ResetPasswordQueryConstants.INSERT_TOKEN, bannerID, token);
            int records = connection.addRecords(query);
            connection.close();
            return records > 0;
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
            return false;
        } finally {
            connection.closeConnection();
        }
    }

    @Override
    public Boolean addToken(String bannerID, String token) {
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format(ResetPasswordQueryConstants.INSERT_TOKEN, bannerID, token);
            int records = connection.addRecords(query);
            connection.close();
            return records > 0;
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
            return false;
        } finally {
            connection.closeConnection();
        }
    }

    @Override
    public Boolean updateTokenStatus() {
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();

            String query = ResetPasswordQueryConstants.CALL_UPDATE_TOKEN_STATUS;
            Statement statement = connection.getStatement();
            boolean records = statement.execute(query);
            statement.close();
            connection.close();
            return records;
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
            return false;
        } finally {
            connection.closeConnection();
        }
    }

    @Override
    public PasswordResetToken getPasswordResetRequest(String bannerID, String token) {
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        String status = "notfound";
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();

            String query = String.format(ResetPasswordQueryConstants.GET_RESET_REQUEST, bannerID, token);
            ResultSet rs = connection.getRecords(query);
            while (rs.next()) {
                passwordResetToken.setTokenID(rs.getInt("TokenID"));
                passwordResetToken.setBannerID(rs.getString("BannerID"));
                passwordResetToken.setToken(rs.getString("Token"));
                passwordResetToken.setTimestamp(rs.getTimestamp("Timestamp"));
                if (rs.getString("Status").equals("expired")) {
                    status = "expired";
                } else if (rs.getString("Status").equals("valid")) {
                    status = "valid";
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }

        if (status.equals("valid"))
            passwordResetToken.setStatusValid();
        else if (status.equals("expired"))
            passwordResetToken.setStatusExpired();
        else
            passwordResetToken.setStatusNotFound();
        return passwordResetToken;
    }

    @Override
    public Boolean updatePassword(String bannerID, String password) {
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();

            String query = String.format(ResetPasswordQueryConstants.UPDATE_PASSWORD, password, bannerID);
            String updateStatusQuery = String.format(ResetPasswordQueryConstants.UPDATE_REQUEST_STATUS, bannerID);
            int records = connection.updateRecords(query);
            if (records > 0) {
                connection.updateRecords(updateStatusQuery);
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
    //TODO: Move getUserEmail to User related class if possible
    @Override
    public String getUserEmail(String bannerID) {
        User user = new User();
        String email = "notfound";
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format(ResetPasswordQueryConstants.GET_USER, bannerID);
            ResultSet rs = connection.getRecords(query);
            while (rs.next()) {
                email = rs.getString("Email");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
        return email;
    }

    @Override
    public Boolean userExists(String bannerID) {
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format(ResetPasswordQueryConstants.GET_USER, bannerID);
            ResultSet rs = connection.getRecords(query);
            if (rs.next()) {
                return true;
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
        return false;
    }
}
