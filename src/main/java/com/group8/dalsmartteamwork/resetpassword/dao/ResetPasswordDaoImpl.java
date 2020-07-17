package com.group8.dalsmartteamwork.resetpassword.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.resetpassword.models.IPasswordResetToken;
import com.group8.dalsmartteamwork.resetpassword.models.IResetToken;
import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;
import com.group8.dalsmartteamwork.resetpassword.models.ResetToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResetPasswordDaoImpl implements IResetPasswordDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public ResetPasswordDaoImpl() {
        updateTokenStatus();
    }

    @Override
    public Boolean addToken(String bannerID) {
        IResetToken resetToken = new ResetToken();
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("spInsertToken(?, ?)");
            String token = resetToken.createToken();
            LOGGER.info("Password reset token generated");
            storedProcedure.setParameter(1, bannerID);
            storedProcedure.setParameter(2, token);
            storedProcedure.execute();
            LOGGER.info(String.format("Password reset request for user with bannerID: %s added to the database", bannerID));
            return true;
        } catch (SQLException exception) {
            LOGGER.error(String.format("An exception occurred while adding password reset request to database for user with bannerID: %s. ", bannerID), exception);
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
            LOGGER.info(String.format("Password reset request for user with bannerID: %s added to the database", bannerID));
            return true;
        } catch (SQLException exception) {
            LOGGER.error(String.format("An exception occurred while adding password reset request to database for user with bannerID: %s. ", bannerID), exception);
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
            LOGGER.info("All password reset request's status with timestamp greater than 15 minutes updated (set to expired)");
            return true;
        } catch (SQLException exception) {
            LOGGER.error("Exception thrown while updating password reset requests status. ", exception);
            return false;
        } finally {
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
    }

    @Override
    public IPasswordResetToken getPasswordResetRequest(String bannerID, String token) {
        IPasswordResetToken passwordResetToken = new PasswordResetToken();
        String status = "notfound";
        CallStoredProcedure storedProcedure = null;
        ResultSet rs;
        try {
            storedProcedure = new CallStoredProcedure("spGetResetRequest(?, ?)");
            storedProcedure.setParameter(1, bannerID);
            storedProcedure.setParameter(2, token);
            rs = storedProcedure.executeWithResults();
            LOGGER.info(String.format("Password reset request fetched for bannerID: %s", bannerID));
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
        } catch (SQLException exception) {
            LOGGER.error("Exception occurred while fetching password reset request. ", exception);
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
            LOGGER.info(String.format("Password reset request not found for bannerID: %s", bannerID));
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
            LOGGER.info(String.format("Password updated for user with bannerID: %s", bannerID));
            storedProcedure = new CallStoredProcedure("spUpdateRequestStatus(?)");
            storedProcedure.setParameter(1, bannerID);
            storedProcedure.execute();
            LOGGER.info(String.format("Password request status updated for recent password update for bannerID: %s", bannerID));
            return true;
        } catch (SQLException exception) {
            LOGGER.error(String.format("Exception occurred while updating password of bannerID: %s. ", bannerID), exception);
            return false;
        } finally {
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
    }

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
        } catch (SQLException exception) {
            LOGGER.error(String.format("Exception occurred while fetching user details of bannerID: %s. ", bannerID), exception);
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
        } catch (SQLException exception) {
            LOGGER.error(String.format("Exception occurred while fetching user details of bannerID: %s. ", bannerID), exception);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
        return false;
    }
}
