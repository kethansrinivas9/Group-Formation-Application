package com.group8.dalsmartteamwork.login.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class CourseRoleDaoImpl implements ICourseRoleDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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
            LOGGER.error("Exception occurred while fetching course roles of a user.", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        LOGGER.info("Course roles fetched for user with BannerID: " + username);
        return roleList;
    }

}