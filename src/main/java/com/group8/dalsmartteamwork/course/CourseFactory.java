package com.group8.dalsmartteamwork.course;

public class CourseFactory extends CourseAbstractFactory {
    private static CourseFactory instance = null;
    private Course course;

    CourseFactory() {
    }

    public static CourseFactory instance() {
        if (null == instance) {
            instance = new CourseFactory();
        }
        return instance;
    }

    @Override
    public Course course() {
        if (null == course) {
            course = new Course();
        }
        return course;
    }
}
