package com.group8.dalsmartteamwork.resetpassword.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.login.model.Encryption;
import com.group8.dalsmartteamwork.login.model.IEncryption;
import com.group8.dalsmartteamwork.resetpassword.models.IPasswordPolicy;
import com.group8.dalsmartteamwork.resetpassword.models.PasswordPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;

public class PasswordHistoryManagerImpl implements IPasswordHistoryManager {
    final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public Boolean moveCurrentPassword(String bannerID) {
        CallStoredProcedure storedProcedure = null;
        try {
            storedProcedure = new CallStoredProcedure("spMoveCurrentPassword(?, ?)");
            IPasswordPolicy passwordPolicy = new PasswordPolicy();
            storedProcedure.setParameter(1, bannerID);
            storedProcedure.setParameter(2, passwordPolicy.getHistoricalPasswordLimit());
            storedProcedure.execute();
            LOGGER.info("Password moved to password history table for BannerID: " + bannerID);
            return true;
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while moving the current password for BannerID: " + bannerID, exception);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
        return false;
    }

    @Override
    public Boolean passwordExists(String bannerID, String password) {
        CallStoredProcedure storedProcedure = null;
        ResultSet rs;
        try {
            IEncryption encryption = new Encryption();
            String encryptedPassword = encryption.encrypt(password);
            if (null != encryptedPassword) {
                LOGGER.info("Password encrypted");
                storedProcedure = new CallStoredProcedure("spGetPasswordHistory(?, ?)");
                storedProcedure.setParameter(1, bannerID);
                storedProcedure.setParameter(2, encryptedPassword);
                rs = storedProcedure.executeWithResults();
                while (rs.next()) {
                    LOGGER.warn(String.format("Password matches to one of the previously set passwords for BannerID: %s", bannerID));
                    return true;
                }
                storedProcedure = new CallStoredProcedure("spGetCurrentPassword(?)");
                storedProcedure.setParameter(1, bannerID);
                rs = storedProcedure.executeWithResults();
                while (rs.next()) {
                    if (encryptedPassword.equals(rs.getString("Password"))) {
                        LOGGER.warn(String.format("New Password matches to the current password for BannerID: %s", bannerID));
                        return true;
                    }
                }
            } else {
                LOGGER.warn("Password encryption failed");
            }
        } catch (Exception exception) {
            LOGGER.error("Exception occurred while fetching password history for BannerID: " + bannerID, exception);
        } finally {
            if (storedProcedure != null) {
                storedProcedure.cleanup();
            }
        }
        LOGGER.info(String.format("New password does not match with current or previously set passwords for BannerID: %s", bannerID));
        return false;
    }
}
