package com.group8.dalsmartteamwork.login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.group8.dalsmartteamwork.login.model.Role;
import com.group8.dalsmartteamwork.utils.DbConnection;

public class LoginImplementation implements LoginDao {
        public Set<Role> roles = new HashSet<Role>();
        private String password_temp = null;

        @Override
        public Boolean getUserDetails(String id, String firstName, String email, String password) throws SQLException {

                try {
                        DbConnection connection = new DbConnection();
                        final String query = String.format(
                                        "SELECT u.Password, r.RoleName,cc.CourseName from Users AS u INNER JOIN CourseRole AS c on (u.BannerID=c.BannerID) INNER JOIN Role AS r on (c.RoleID = r.RoleID) INNER JOIN Courses as cc on (c.CourseID = cc.CourseID) where u.BannerID ='%s' and u.Password='%s' ",
                                        id, password);
                        ResultSet resultSet = connection.getRecords(query);
                        while (resultSet.next()) {
                                password_temp = resultSet.getString("u.Password");
                                roles.add(new Role(resultSet.getString("r.RoleName"),
                                                resultSet.getString("cc.CourseName")));
                        }
                        resultSet.close();
                        connection.close();
                        if (password.equals(password_temp)) {
                                return true;
                        } else {
                                return false;
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                }
        }
}