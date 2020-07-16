package com.group8.dalsmartteamwork.course.dao;

public class CourseDaoFactory extends CourseDaoAbstractFactory {
    private static CourseDaoFactory instance = null;
    private ICourseDao courseDao;

    CourseDaoFactory() {
    }

    public static CourseDaoFactory instance() {
        if (null == instance) {
            instance = new CourseDaoFactory();
        }
        return instance;
    }

    @Override
    public ICourseDao courseDao() {
        if (null == courseDao) {
            courseDao = new CourseDaoImpl();
        }
        return courseDao;
    }
}
