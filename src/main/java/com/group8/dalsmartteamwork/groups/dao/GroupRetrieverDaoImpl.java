package com.group8.dalsmartteamwork.groups.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.groups.Group;
import com.group8.dalsmartteamwork.groups.IGroup;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GroupRetrieverDaoImpl implements IGroupRetrieverDao {
    public List<IGroup> getGroups(int courseId){
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        List<IGroup> groups = new ArrayList<>();
        try {
            procedure = new CallStoredProcedure("spGetGroups(?)");
            procedure.setParameter(1, courseId);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                IGroup group = new Group();
                group.setGroupId(resultSet.getInt(1));
                group.setBannerId(resultSet.getString(2));
                group.setFirstName(resultSet.getString(3));
                group.setLastName(resultSet.getString(4));
                groups.add(group);
            }
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return groups;
    }

    @Override
    public List<Integer> getCourses(String bannerId) {
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        List<Integer> courses = new ArrayList<>();
        try {
            procedure = new CallStoredProcedure("spGetInstructorCourses(?)");
            procedure.setParameter(1, bannerId);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                int courseId = resultSet.getInt(1);
                courses.add(courseId);
            }
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return courses;
    }
}
