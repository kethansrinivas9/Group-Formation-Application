package com.group8.dalsmartteamwork.login.dao;

public class LoginDaoFactory extends LoginDaoAbstractFactory {
    private static LoginDaoFactory instance = null;
    private ICourseRoleDao courseRoleDao;
    private ILoginDao loginDao;

    LoginDaoFactory() {
    }

    public static LoginDaoFactory instance() {
        if (null == instance) {
            instance = new LoginDaoFactory();
        }
        return instance;
    }

    @Override
    public ICourseRoleDao courseRoleDao() {
        if (null == courseRoleDao) {
            courseRoleDao = new CourseRoleDaoImpl();
        }
        return courseRoleDao;
    }

    @Override
    public ILoginDao loginDao() {
        if (null == loginDao) {
            loginDao = new LoginDaoImpl();
        }
        return loginDao;
    }
}
