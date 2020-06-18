package com.group8.dalsmartteamwork.register.models;

import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.utils.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RegistrationModelImplTest {
    private IRegistrationModel service = null;
    private RegistrationDaoImpl dao = mock(RegistrationDaoImpl.class);
    private User existingUser = new User("B00000000", "fName", "lName", "email@email.com", "pwd");
    private User newUser = new User("B1111111", "fName", "lName", "email@email.com", "pwd");

    @BeforeEach
    void setup(){
        this.service = new RegistrationModelImpl(dao);
    }

    @Test
    void registerUserSuccessTest(){
        when(this.dao.addUserToDb(newUser)).thenReturn(true);
        when(this.dao.addGuestRoleToUser(newUser.getId())).thenReturn(true);
        assertTrue(service.registerUser(newUser));
    }

    @Test
    void registerUserFailTest(){
        when(this.dao.addUserToDb(existingUser)).thenReturn(false);
        when(this.dao.addGuestRoleToUser(newUser.getId())).thenReturn(true);
        assertFalse(service.registerUser(existingUser));
    }

    @Test
    void addGuestRoleFailTest(){
        when(this.dao.addUserToDb(existingUser)).thenReturn(true);
        when(this.dao.addGuestRoleToUser(newUser.getId())).thenReturn(false);
        assertFalse(service.registerUser(existingUser));
    }
}

