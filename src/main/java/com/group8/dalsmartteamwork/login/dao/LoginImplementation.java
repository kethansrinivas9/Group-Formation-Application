package com.group8.dalsmartteamwork.login.dao;

import com.group8.dalsmartteamwork.utils.DbConnection;

import java.sql.ResultSet;

public class LoginImplementation implements LoginDao {
    public String role;
    private String password_temp = null;
    DbConnection connection;

    @Override
    public Boolean getUserDetails(String id, String firstName, String email, String password) {

        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            final String query = String.format(
                    "Select u.Password, r.RoleName, u.BannerID from Users AS u INNER JOIN SystemRole AS s on (u.BannerID = s.BannerID) INNER JOIN Role AS r on (r.RoleID = s.RoleID) where u.BannerID = '%s' and u.Password= '%s' ",
                    id, password);
            ResultSet resultSet = connection.getRecords(query);
            while (resultSet.next()) {
                password_temp = resultSet.getString("u.Password");
                role = resultSet.getString("r.RoleName");
            }
            if (password.equals(password_temp)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return false;
    }
}