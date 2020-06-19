package com.group8.dalsmartteamwork.courseadmin.models;

import com.group8.dalsmartteamwork.utils.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class MakePairServiceImplTest {
    private static List<User> users;
    private static List<Boolean> status;
    private static final User existingUser = new User("B00000000", "fName", "lName", "email@email.com", "pwd");
    private static final User newUser = new User("B1111111", "fName", "lName", "email@email.com", "pwd");
    private static MakePairService service;

    @BeforeAll
    static void setup() {
        service = new MakePairServiceImpl();
        status = Arrays.asList(false, true);
        users = Arrays.asList(existingUser, newUser);
    }

    @Test
    public void getUserDetailsTest() {
        assertFalse(service.getUserDetails(users, status).isEmpty());
    }
}
