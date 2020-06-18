package com.group8.dalsmartteamwork.resetpassword.dao;

import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;
import com.group8.dalsmartteamwork.utils.CallStoredProcedure;
import com.group8.dalsmartteamwork.utils.DbConnection;
import com.group8.dalsmartteamwork.utils.ResetToken;

import java.sql.ResultSet;

public class ResetPasswordDaoImpl implements ResetPasswordDao {
    DbConnection connection;

    public ResetPasswordDaoImpl() {
        updateTokenStatus();
    }

    @Override
    public Boolean addToken(String bannerID) {
        ResetToken resetToken = new ResetToken();
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("spInsertToken(?, ?)");
            String token = resetToken.createToken();
            storedProcedure.setParameter(1, bannerID);
            storedProcedure.setParameter(2, token);
            storedProcedure.execute();
            return true;
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        } finally {
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
        return false;
    }

    @Override
    public Boolean addToken(String bannerID, String token) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("spInsertToken(?, ?)");
            storedProcedure.setParameter(1, bannerID);
            storedProcedure.setParameter(2, token);
            storedProcedure.execute();
            return true;
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        } finally {
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
        return false;
    }

    @Override
    public Boolean updateTokenStatus() {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("spResetTokens");
            storedProcedure.execute();
            return true;
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
            return false;
        } finally {
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
    }

    @Override
    public PasswordResetToken getPasswordResetRequest(String bannerID, String token) {
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        String status = "notfound";
        CallStoredProcedure storedProcedure = null;
        ResultSet rs;
        try {
            storedProcedure = new CallStoredProcedure("spGetResetRequest(?, ?)");
            storedProcedure.setParameter(1, bannerID);
            storedProcedure.setParameter(2, token);
            rs = storedProcedure.executeWithResults();

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
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
        if (status.equals("valid")) {
            passwordResetToken.setStatusValid();
        } else if (status.equals("expired")) {
            passwordResetToken.setStatusExpired();
        } else {
            passwordResetToken.setStatusNotFound();
        }
        return passwordResetToken;
    }

    @Override
    public Boolean updatePassword(String bannerID, String password) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("spUpdatePassword(?, ?)");
            storedProcedure.setParameter(1, password);
            storedProcedure.setParameter(2, bannerID);
            storedProcedure.execute();
            storedProcedure = new CallStoredProcedure("spUpdateRequestStatus(?)");
            storedProcedure.setParameter(1, bannerID);
            storedProcedure.execute();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        } finally {
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
    }

    //TODO: Move getUserEmail to User related class if possible
    @Override
    public String getUserEmail(String bannerID) {
        String email = "notfound";
        CallStoredProcedure storedProcedure = null;
        ResultSet rs;
        try {
            storedProcedure = new CallStoredProcedure("spGetUser(?)");
            storedProcedure.setParameter(1, bannerID);
            rs = storedProcedure.executeWithResults();

            while (rs.next()) {
                email = rs.getString("Email");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
        return email;
    }

    @Override
    public Boolean userExists(String bannerID) {
        CallStoredProcedure storedProcedure = null;
        ResultSet rs;
        try {
            storedProcedure = new CallStoredProcedure("spGetUser(?)");
            storedProcedure.setParameter(1, bannerID);
            rs = storedProcedure.executeWithResults();

            if (rs.next()) {
                return true;
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
        return false;
    }
}
