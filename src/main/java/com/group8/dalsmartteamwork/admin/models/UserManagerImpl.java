package com.group8.dalsmartteamwork.admin.models;

import com.group8.dalsmartteamwork.admin.dao.IUserManagerDao;

import java.util.List;

public class UserManagerImpl implements IUserManager {
    private final IUserManagerDao userManagerDao;

    public UserManagerImpl(IUserManagerDao userManagerDao) {
        this.userManagerDao = userManagerDao;
    }

    @Override
    public List<String> getListOfNonAdminUsers() {
        return userManagerDao.getListOfNonAdminUsers();
    }

    @Override
    public String getCourseInstructor(String courseID) {
        return userManagerDao.getCourseInstructor(courseID);
    }

    @Override
    public List<String> getUsersWhoAreGuestsOrInstructors(String courseID) {
        return userManagerDao.getUsersWhoAreGuestsOrInstructors(courseID);
    }
}
