package com.group8.dalsmartteamwork.courseadmin.models;

import com.group8.dalsmartteamwork.courseadmin.dao.IStudentEnrollmentDao;
import com.group8.dalsmartteamwork.courseadmin.dao.StudentEnrollmentDaoImpl;

public class StudentEnrollmentFactoryImpl implements IStudentEnrollmentFactory {
    @Override
    public IStudentEnrollmentDao getStudentEnrollmentDaoObject() {
        return new StudentEnrollmentDaoImpl();
    }

    @Override
    public IPasswordGenerator getPasswordGeneratorObject() {
        return new PasswordGenerator();
    }
}
