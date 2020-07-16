package com.group8.dalsmartteamwork.courseadmin.models;

import com.group8.dalsmartteamwork.courseadmin.dao.CourseAdminDaoFactory;
import com.group8.dalsmartteamwork.courseadmin.dao.IStudentEnrollmentDao;
import com.group8.dalsmartteamwork.courseadmin.dao.StudentEnrollmentDaoImpl;

public class StudentEnrollmentFactoryImpl implements IStudentEnrollmentFactory {
    @Override
    public IStudentEnrollmentDao getStudentEnrollmentDaoObject() {
        return CourseAdminDaoFactory.instance().studentEnrollmentDao();
    }

    @Override
    public IPasswordGenerator getPasswordGeneratorObject() {
        return CourseAdminModelsFactory.instance().passwordGenerator();
    }
}
