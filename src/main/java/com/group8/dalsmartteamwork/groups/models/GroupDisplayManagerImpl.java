package com.group8.dalsmartteamwork.groups.models;

import com.group8.dalsmartteamwork.groups.IGroup;
import com.group8.dalsmartteamwork.groups.dao.IGroupRetrieverDao;

import java.util.List;

public class GroupDisplayManagerImpl implements IGroupDisplayManager {
    private final IGroupRetrieverDao iGroupRetrieverDao;

    public GroupDisplayManagerImpl(IGroupRetrieverDao iGroupRetrieverDao) {
        this.iGroupRetrieverDao = iGroupRetrieverDao;
    }

    @Override
    public List<IGroup> getGroups(int courseId) {
        return iGroupRetrieverDao.getGroups(courseId);
    }

    @Override
    public List<Integer> getInstructorCourses(String bannerId) {
        return iGroupRetrieverDao.getCourses(bannerId);
    }
}
