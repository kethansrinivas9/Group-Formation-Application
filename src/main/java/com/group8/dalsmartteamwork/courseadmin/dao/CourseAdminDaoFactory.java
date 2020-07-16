package com.group8.dalsmartteamwork.courseadmin.dao;

public class CourseAdminDaoFactory extends CourseAdminDaoAbstractFactory {
    private static CourseAdminDaoFactory instance = null;
    private IStudentEnrollmentDao studentEnrollmentDao;

    CourseAdminDaoFactory() {
    }

    public static CourseAdminDaoFactory instance() {
        if (null == instance) {
            instance = new CourseAdminDaoFactory();
        }
        return instance;
    }

    @Override
    public IStudentEnrollmentDao studentEnrollmentDao() {
        if (null == studentEnrollmentDao) {
            studentEnrollmentDao = new StudentEnrollmentDaoImpl();
        }
        return studentEnrollmentDao;
    }
}
