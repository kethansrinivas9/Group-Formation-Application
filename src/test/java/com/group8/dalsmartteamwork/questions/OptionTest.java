package com.group8.dalsmartteamwork.questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionTest {
    private final String TEST_DISPLAY_TEXT = "TEST_STRING";
    private final int TEST_STORED_AS = 10;

    @Test
    void getDisplayTextTest() {
        Option option = new Option(TEST_DISPLAY_TEXT, TEST_STORED_AS);
        assertEquals(option.getDisplayText(), TEST_DISPLAY_TEXT);
    }

    @Test
    void setDisplayTextTest() {
        Option option = new Option();
        option.setDisplayText(TEST_DISPLAY_TEXT);
        assertEquals(option.getDisplayText(), TEST_DISPLAY_TEXT);
    }

    @Test
    void getStoredAsTest() {
        Option option = new Option(TEST_DISPLAY_TEXT, TEST_STORED_AS);
        assertEquals(option.getStoredAs(), TEST_STORED_AS);
    }

    @Test
    void setStoredAsTest() {
        Option option = new Option();
        option.setStoredAs(TEST_STORED_AS);
        assertEquals(option.getStoredAs(), TEST_STORED_AS);
    }
}
