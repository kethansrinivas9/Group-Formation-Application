package com.group8.dalsmartteamwork.courseadmin;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.courseadmin.models.IStudentEnrollmentFactory;
import com.group8.dalsmartteamwork.courseadmin.models.StudentImportManagerImpl;
import com.group8.dalsmartteamwork.register.models.IRegistrationFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentImportManagerImplTest {
    private static final int COURSE_ID = 5308;
    private final User existingUser = new User("B00000000", "fName", "lName", "email@email.com", "pwd");
    private final User newUser = new User("B1111111", "fName", "lName", "email@email.com", "pwd");
    private List<User> users;

    @BeforeEach
    void setup() {
        this.users = new ArrayList<>();
        users.add(this.existingUser);
        users.add(this.newUser);
    }

    @Test
    void verifyRegistrationTest() {
        final IRegistrationFactory iRegistrationFactory = new RegistrationFactoryMock();
        final IStudentEnrollmentFactory iStudentEnrollmentFactory = new StudentEnrollmentFactoryMock();
        StudentImportManagerImpl service = new StudentImportManagerImpl(COURSE_ID, iRegistrationFactory, iStudentEnrollmentFactory);
        List<Boolean> result = Arrays.asList(false, true);
        assertEquals(service.verifyRegistration(users), result);
    }

}
