package com.group8.dalsmartteamwork.courseadmin.services;

import com.group8.dalsmartteamwork.register.dao.RegistrationDao;
import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.utils.Mail;
import com.group8.dalsmartteamwork.utils.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ImportCsvServiceImplTest {
    private ImportCsvServiceImpl service = null;
    private RegistrationDao dao = mock(RegistrationDaoImpl.class);
    private Mail mail = mock(Mail.class);
    private List<User> users;
    private static final int COURSE_ID = 5308;
    private User existingUser = new User("B00000000", "fName", "lName", "email@email.com", "pwd");
    private User newUser = new User("B1111111", "fName", "lName", "email@email.com", "pwd");

    @BeforeEach
    void setup(){
        this.service = new ImportCsvServiceImpl(COURSE_ID, dao, mail);
        this.users = new ArrayList<>();
        users.add(this.existingUser);
        users.add(this.newUser);
    }

    @Test
    void verifyRegistrationTest(){
        List<Boolean> result = Arrays.asList(false,true);
        when(mail.sendEmail(anyString(), anyString(), anyString())).thenReturn(true);
        when(dao.isUserInDb(existingUser.getId())).thenReturn(true);
        when(dao.isUserInDb(newUser.getId())).thenReturn(false);
        when(dao.addUserToDb(existingUser)).thenReturn(false);
        when(dao.addUserToDb(newUser)).thenReturn(true);
        when(dao.assignCourseToUser(newUser.getId(), COURSE_ID)).thenReturn(true);
        when(dao.assignCourseToUser(existingUser.getId(), COURSE_ID)).thenReturn(true);
        assertEquals(service.verifyRegistration(users), result);
    }

    @Test
    void generatePasswordTest(){
        assertEquals(service.generatePassword().length(), 15);
    }
}
