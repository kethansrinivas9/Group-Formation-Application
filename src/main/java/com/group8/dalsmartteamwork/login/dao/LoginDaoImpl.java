package com.group8.dalsmartteamwork.login.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;

public class LoginDaoImpl implements ILoginDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private String role, BannerID;
    private String password_temp = null;

    @Override
    public Boolean getUserDetails(String id, String firstName, String email, String password) {

        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        try {
            procedure = new CallStoredProcedure("spGetUserDetails(?, ?)");
            procedure.setParameter(1, id);
            procedure.setParameter(2, password);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                password_temp = resultSet.getString(1);
                setRole(resultSet.getString(2));
                setBannerID(resultSet.getString(3));
            }
            if (password.equals(password_temp)) {
                LOGGER.info("User details fetched for user with BannerID: " + id);
                return true;
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred while fetching user details. ", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return false;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBannerID() {
        return BannerID;
    }

    public void setBannerID(String bannerID) {
        BannerID = bannerID;
    }
}