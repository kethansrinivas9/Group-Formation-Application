package com.group8.dalsmartteamwork.courseadmin;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.courseadmin.models.IMakePairService;
import com.group8.dalsmartteamwork.courseadmin.models.MakePairServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class IMakePairServiceImplTest {
    private static final User existingUser = new User("B00000000", "fName", "lName", "email@email.com", "pwd");
    private static final User newUser = new User("B1111111", "fName", "lName", "email@email.com", "pwd");
    private static List<User> users;
    private static List<Boolean> status;
    private static IMakePairService service;

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
