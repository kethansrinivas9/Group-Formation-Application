package com.group8.dalsmartteamwork.register.dao;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.database.DbConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationDaoImpl implements IRegistrationDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private DbConnection dbConnection;

    @Override
    public Boolean isUserInDb(String id) {
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        try {
            procedure = new CallStoredProcedure("spCheckIfUserExists(?)");
            procedure.setParameter(1, id);
            resultSet = procedure.executeWithResults();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while trying to fetch user details from the database.", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return false;
    }

    @Override
    public Boolean addUserToDb(User user) {
        CallStoredProcedure procedure = null;
        try {
            procedure = new CallStoredProcedure("spCreateUser(?, ?, ?, ?, ?)");
            procedure.setParameter(1, user.getId());
            procedure.setParameter(2, user.getLastName());
            procedure.setParameter(3, user.getFirstName());
            procedure.setParameter(4, user.getEmail());
            procedure.setParameter(5, user.getPassword());
            procedure.execute();
            LOGGER.info("User added to the database. BannerID: " + user.getId());
            return true;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while add user details to the database.", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        LOGGER.warn("User not added to the Database. UserID: " + user.getId());
        return false;
    }

    @Override
    public Boolean addGuestRoleToUser(String id) {
        CallStoredProcedure procedure = null;
        try {
            procedure = new CallStoredProcedure("spAssignGuestRoleToUser(?)");
            procedure.setParameter(1, id);
            procedure.execute();
            LOGGER.info("Guest role assigned to user with BannerID: " + id);
            return true;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while trying to assign guest role to user.", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return false;

    }

}