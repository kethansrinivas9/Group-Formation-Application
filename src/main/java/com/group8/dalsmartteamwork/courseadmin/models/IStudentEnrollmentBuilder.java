package com.group8.dalsmartteamwork.courseadmin.models;

import com.group8.dalsmartteamwork.courseadmin.dao.IStudentEnrollmentDao;

public interface IStudentEnrollmentBuilder {
    IStudentEnrollmentDao getStudentEnrollmentDaoObject();
    IPasswordGenerator getPasswordGeneratorObject();
}
