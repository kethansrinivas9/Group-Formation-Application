package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.group8.dalsmartteamwork.courseadmin.dao.VerifyRegistrationImpl;

import org.junit.jupiter.api.Test;

public class VerifyRegistrationImplTest {
    private static final String TEST_EMAIL = "avinashgazula1@gmail.com";
    private static final String TEST_SUBJECT = "Test Subject";
    private static final String TEST_TEXT = "This is a test";
    public static final int TEST_LENGTH = 15;

    @Test
    public void sendEmailTest() {
        VerifyRegistrationImpl vri = new VerifyRegistrationImpl();
        assertTrue(vri.sendEmail(TEST_EMAIL, TEST_SUBJECT, TEST_TEXT));
    }

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