package com.group8.dalsmartteamwork.register.dao;

import com.group8.dalsmartteamwork.utils.CallStoredProcedure;
import com.group8.dalsmartteamwork.utils.DbConnection;
import com.group8.dalsmartteamwork.utils.User;

import java.sql.ResultSet;

public class RegistrationDaoImpl implements RegistrationDao {
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
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
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
            return true;
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return false;
    }

    @Override
    public Boolean addGuestRoleToUser(String id) {
        CallStoredProcedure procedure = null;
        try {
            procedure = new CallStoredProcedure("spAssignGuestRoleToUser(?)");
            procedure.setParameter(1, id);
            procedure.execute();
            return true;
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return false;

    }

}