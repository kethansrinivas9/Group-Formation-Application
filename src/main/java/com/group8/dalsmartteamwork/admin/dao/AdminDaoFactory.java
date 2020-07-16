package com.group8.dalsmartteamwork.admin.dao;

public class AdminDaoFactory extends AdminDaoAbstractFactory {
    private static AdminDaoFactory instance = null;
    private ICourseManagerDao courseManagerDao;
    private IUserManagerDao userManagerDao;

    AdminDaoFactory() {
    }

    public static AdminDaoFactory instance() {
        if (null == instance) {
            instance = new AdminDaoFactory();
        }
        return instance;
    }

    @Override
    public ICourseManagerDao courseManagerDao() {
        if (null == courseManagerDao) {
            courseManagerDao = new CourseManagerDaoImpl();
        }
        return courseManagerDao;
    }

    @Override
    public IUserManagerDao userManagerDao() {
        if (null == userManagerDao) {
            userManagerDao = new UserManagerDaoImpl();
        }
        return userManagerDao;
    }
}
