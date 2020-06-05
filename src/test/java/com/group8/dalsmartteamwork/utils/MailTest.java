package com.group8.dalsmartteamwork.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.group8.dalsmartteamwork.utils.Mail;

import org.junit.jupiter.api.Test;

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