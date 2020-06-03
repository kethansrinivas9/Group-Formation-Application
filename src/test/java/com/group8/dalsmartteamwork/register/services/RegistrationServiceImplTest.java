package com.group8.dalsmartteamwork.register.services;

import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.utils.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegistrationServiceImplTest {
    private RegistrationServiceImpl service = null;
    private RegistrationDaoImpl dao = mock(RegistrationDaoImpl.class);
    private User existingUser = new User("B00000000", "fName", "lName", "email@email.com", "pwd");
    private User newUser = new User("B1111111", "fName", "lName", "email@email.com", "pwd");

    @BeforeEach
    void setup(){
        this.service = new RegistrationServiceImpl(dao);
    }

    @Test
    void registerUserSuccessTest(){
        when(this.dao.addUserToDb(newUser)).thenReturn(true);
        assertTrue(service.registerUser(newUser));
    }

    @Test
    void registerUserFailTest(){
        when(this.dao.addUserToDb(existingUser)).thenReturn(false);
        assertFalse(service.registerUser(existingUser));
    }
}

