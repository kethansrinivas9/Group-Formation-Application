package com.group8.dalsmartteamwork.course.models;

import com.group8.dalsmartteamwork.course.dao.CourseDaoFactory;

public class CourseModelsFactory extends CourseModelsAbstractFactory {
    private static CourseModelsFactory instance = null;
    private ICourseInstructorManager courseInstructorManager;

    CourseModelsFactory() {
    }

    public static CourseModelsFactory instance() {
        if (null == instance) {
            instance = new CourseModelsFactory();
        }
        return instance;
    }

    @Override
    public ICourseInstructorManager courseInstructorManager() {
        if (null == courseInstructorManager) {
            courseInstructorManager = new CourseInstructorManagerImpl(CourseDaoFactory.instance().courseDao());
        }
        return courseInstructorManager;
    }
}
