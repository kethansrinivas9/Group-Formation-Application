package com.group8.dalsmartteamwork.questions;

import com.group8.dalsmartteamwork.questions.models.OptionRetrieveManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OptionRetrieveManagerTest {
    private final String TEST_DISPLAY_TEXT = "DISPLAY_TEXT";
    private final int TEST_STORED_AS = 5;
    private HttpServletRequest request;

    @BeforeEach
    void setup() {
        request = mock(HttpServletRequest.class);
    }

    @Test
    void getOptionsSuccessTest() {
        OptionRetrieveManager parseRequest = new OptionRetrieveManager();
        when(request.getParameter("display-text-1")).thenReturn(TEST_DISPLAY_TEXT);
        when(request.getParameter("stored-as-1")).thenReturn(String.valueOf(TEST_STORED_AS));
        when(request.getParameter("display-text-2")).thenReturn(null);
        when(request.getParameter("stored-as-2")).thenReturn(null);
        assertEquals(parseRequest.getOptions(request).size(), 1);
    }

    @Test
    void getOptionsFailTest() {
        OptionRetrieveManager parseRequest = new OptionRetrieveManager();
        when(request.getParameter("display-text-1")).thenReturn(null);
        when(request.getParameter("stored-as-1")).thenReturn(null);
        when(request.getParameter("display-text-2")).thenReturn(TEST_DISPLAY_TEXT);
        when(request.getParameter("stored-as-2")).thenReturn(String.valueOf(TEST_STORED_AS));
        assertNotEquals(parseRequest.getOptions(request).size(), 1);
    }
}
