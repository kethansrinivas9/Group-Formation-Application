package com.group8.dalsmartteamwork.courseadmin;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.courseadmin.dao.IStudentEnrollmentDao;
import com.group8.dalsmartteamwork.courseadmin.dao.StudentEnrollmentDaoImpl;
import com.group8.dalsmartteamwork.courseadmin.models.IPasswordGenerator;
import com.group8.dalsmartteamwork.courseadmin.models.IStudentEnrollmentFactory;
import com.group8.dalsmartteamwork.courseadmin.models.PasswordGenerator;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentEnrollmentFactoryMock implements IStudentEnrollmentFactory {
    private static final int COURSE_ID = 5308;
    private final User existingUser = new User("B00000000", "fName", "lName", "email@email.com", "pwd");
    private final User newUser = new User("B1111111", "fName", "lName", "email@email.com", "pwd");

    @Override
    public IStudentEnrollmentDao getStudentEnrollmentDaoObject() {
        IStudentEnrollmentDao iStudentEnrollmentDao = mock(StudentEnrollmentDaoImpl.class);
        when(iStudentEnrollmentDao.assignCourseToUser(newUser.getId(), COURSE_ID)).thenReturn(true);
        when(iStudentEnrollmentDao.assignCourseToUser(existingUser.getId(), COURSE_ID)).thenReturn(true);
        return iStudentEnrollmentDao;
    }

    @Override
    public IPasswordGenerator getPasswordGeneratorObject() {
        return new PasswordGenerator();
    }
}
