package com.group8.dalsmartteamwork.courseadmin;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.courseadmin.dao.IStudentEnrollmentDao;
import com.group8.dalsmartteamwork.courseadmin.dao.StudentEnrollmentDaoImpl;
import com.group8.dalsmartteamwork.courseadmin.models.StudentImportManagerImpl;
import com.group8.dalsmartteamwork.register.dao.RegistrationDao;
import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.resetpassword.models.Mail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentImportManagerImplTest {
    private static final int COURSE_ID = 5308;
    private final RegistrationDao registrationDao = mock(RegistrationDaoImpl.class);
    private final IStudentEnrollmentDao studentEnrollmentDao = mock(StudentEnrollmentDaoImpl.class);
    private final Mail mail = mock(Mail.class);
    private final User existingUser = new User("B00000000", "fName", "lName", "email@email.com", "pwd");
    private final User newUser = new User("B1111111", "fName", "lName", "email@email.com", "pwd");
    private StudentImportManagerImpl service = null;
    private List<User> users;

    @BeforeEach
    void setup() {
        this.service = new StudentImportManagerImpl(COURSE_ID, registrationDao, studentEnrollmentDao, mail);
        this.users = new ArrayList<>();
        users.add(this.existingUser);
        users.add(this.newUser);
    }

    @Test
    void verifyRegistrationTest() {
        List<Boolean> result = Arrays.asList(false, true);
        when(mail.sendEmail(anyString(), anyString(), anyString())).thenReturn(true);
        when(registrationDao.isUserInDb(existingUser.getId())).thenReturn(true);
        when(registrationDao.isUserInDb(newUser.getId())).thenReturn(false);
        when(registrationDao.addUserToDb(existingUser)).thenReturn(false);
        when(registrationDao.addUserToDb(newUser)).thenReturn(true);
        when(studentEnrollmentDao.assignCourseToUser(newUser.getId(), COURSE_ID)).thenReturn(true);
        when(studentEnrollmentDao.assignCourseToUser(existingUser.getId(), COURSE_ID)).thenReturn(true);
        assertEquals(service.verifyRegistration(users), result);
    }

}
