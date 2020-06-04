package com.group8.dalsmartteamwork.login.dao;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.group8.dalsmartteamwork.utils.DbConnection;

import org.springframework.security.core.context.SecurityContextHolder;

public class CourseRoleImp {

    DbConnection dbConnection;
    public String username;
    Set<String> roleList = new HashSet<>();
    String RoleId, RoleName;

    public Set<String> getCourseRoles() {
        try {
            dbConnection = DbConnection.getInstance();
            dbConnection.createDbConnection();
            username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String query = String.format(
                    "select r.RoleName, r.RoleID, u.BannerID from Courses AS c INNER JOIN CourseRole AS cr on (c.CourseID = cr.CourseID) INNER JOIN Role AS r on (cr.RoleID = r.RoleID) INNER JOIN Users AS u on (u.BannerID = cr.BannerID) where u.BannerID= '%s' ;",
                    username);
            ResultSet resultSet = dbConnection.getRecords(query);
            while (resultSet.next()) {
                RoleName = resultSet.getString("r.RoleName");
                roleList.add(RoleName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }
        return roleList;
    }

}