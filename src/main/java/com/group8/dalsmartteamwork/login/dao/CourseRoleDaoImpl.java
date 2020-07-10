package com.group8.dalsmartteamwork.login.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import org.springframework.security.core.context.SecurityContextHolder;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class CourseRoleDaoImpl implements ICourseRoleDao {
    public String username;
    String RoleName;

    public Set<String> getCourseRoles() {
        Set<String> roleList = new HashSet<>();
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        try {
            username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            procedure = new CallStoredProcedure("spGetCourseRole(?)");
            procedure.setParameter(1, username);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                RoleName = resultSet.getString(1);
                roleList.add(RoleName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return roleList;
    }

}