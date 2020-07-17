package com.group8.dalsmartteamwork.register;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.register.models.IRegistrationFactory;
import com.group8.dalsmartteamwork.register.models.IRegistrationModel;
import com.group8.dalsmartteamwork.register.models.RegistrationModelImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class RegistrationModelImplTest {
    private final RegistrationDaoImpl dao = mock(RegistrationDaoImpl.class);
    private final User existingUser = new User("B00000000", "fName", "lName", "email@email.com", "pwd");
    private final User newUserSuccess = new User("B1111111", "fName", "lName", "email@email.com", "pwd");
    private final User newUserFail = new User("B2222222", "fName", "lName", "email@email.com", "pwd");
    private IRegistrationModel service = null;

    @BeforeEach
    void setup() {
        IRegistrationFactory iRegistrationFactory = new RegistrationFactoryMock(existingUser, newUserSuccess, newUserFail);
        service = new RegistrationModelImpl(iRegistrationFactory);
    }

    @Test
    void registerUserSuccessTest() {
        assertTrue(service.registerUser(newUserSuccess));
    }

    @Test
    void registerUserFailTest() {
        assertFalse(service.registerUser(existingUser));
    }

    @Test
    void addGuestRoleFailTest() {
        assertFalse(service.registerUser(newUserFail));
    }
}

