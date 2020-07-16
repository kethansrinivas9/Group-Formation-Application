package com.group8.dalsmartteamwork.admin.models;

import com.group8.dalsmartteamwork.admin.dao.AdminDaoFactory;

public class AdminModelsFactory extends AdminModelsAbstractFactory {
    private static AdminModelsFactory instance = null;
    private ICourseManager courseManager;
    private IUserManager userManager;

    AdminModelsFactory() {
    }

    public static AdminModelsFactory instance() {
        if (null == instance) {
            instance = new AdminModelsFactory();
        }
        return instance;
    }

    @Override
    public ICourseManager courseManager() {
        if (null == courseManager) {
            courseManager = new CourseManagerImpl(AdminDaoFactory.instance().courseManagerDao());
        }
        return courseManager;
    }

    @Override
    public IUserManager userManager() {
        if (null == userManager) {
            userManager = new UserManagerImpl(AdminDaoFactory.instance().userManagerDao());
        }
        return userManager;
    }
}
