package com.group8.dalsmartteamwork.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MailTest {

    @Test
    public void getSessionTest() {
        Mail mail = new Mail();
        assertNotNull(mail.getSession());
    }

    @Test
    public void sendEmailTest() {
        // TODO: Add Test
    }
}