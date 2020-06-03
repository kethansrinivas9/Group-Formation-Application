package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.group8.dalsmartteamwork.courseadmin.dao.VerifyRegistrationImpl;

import org.junit.jupiter.api.Test;

public class VerifyRegistrationImplTest {
    public static final int TEST_LENGTH = 15;

    @Test
    public void generatePasswordText() {
        VerifyRegistrationImpl vri = new VerifyRegistrationImpl();
        assertTrue(vri.generatePassword(TEST_LENGTH).length() == TEST_LENGTH);
    }

    @Test
    public void VerifyRegistrationTest() {
        // TODO: to be implemeted
    }
}