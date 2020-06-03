package com.group8.dalsmartteamwork.resetpassword.dao;

import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;
import com.group8.dalsmartteamwork.utils.DbConnection;
import com.group8.dalsmartteamwork.utils.ResetToken;

import java.sql.ResultSet;
import java.sql.Statement;

public class ResetPasswordDaoImpl implements ResetPasswordDao {
    DbConnection connection;

    public ResetPasswordDaoImpl() {
        resetTokens();
    }

    @Override
    public Boolean addToken(String bannerID) {
        ResetToken resetToken = new ResetToken();
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String token = resetToken.createToken();
            String query = String.format("INSERT INTO CSCI5308_8_DEVINT.PasswordResetToken (BannerID, Token, Timestamp, Status) VALUES ('%s', '%s', now(), 'valid')", bannerID, token);
            int records = connection.addRecords(query);
            if (records > 0) {
                return true;
            } else {
                return false;
            }
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
            String query = String.format("INSERT INTO CSCI5308_8_DEVINT.PasswordResetToken (BannerID, Token, Timestamp, Status) VALUES ('%s', '%s', now(), 'valid')", bannerID, token);
            int records = connection.addRecords(query);
            if (records > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
            return false;
        } finally {
            connection.closeConnection();
        }
    }

    @Override
    public Boolean resetTokens() {
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();

            String query = "CALL CSCI5308_8_DEVINT.resettokens";
            Statement statement = connection.getStatement();
            boolean records = statement.execute(query);
            statement.close();
            if (records) {
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
            return false;
        } finally {
            connection.closeConnection();
        }
    }

    @Override
    public PasswordResetToken getRequestByToken(String bannerID, String token) {
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        String status = "notfound";
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();

            String query = String.format("SELECT * FROM CSCI5308_8_DEVINT.PasswordResetToken WHERE BannerID='%s' and token='%s'", bannerID, token);
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
            connection.closeConnection();
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

            String query = String.format("UPDATE CSCI5308_8_DEVINT.Users SET Password='%s' WHERE BannerID='%s'", password, bannerID);
            String updateStatusQuery = String.format("UPDATE CSCI5308_8_DEVINT.PasswordResetToken SET Status='expired' WHERE BannerID='%s'", bannerID);
            int records = connection.updateRecords(query);

            if (records > 0) {
                records = connection.updateRecords(updateStatusQuery);
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        } finally {
            connection.closeConnection();
        }
    }
}
