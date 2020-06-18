package com.group8.dalsmartteamwork.resetpassword;

import com.group8.dalsmartteamwork.resetpassword.models.PasswordPolicy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PasswordPolicyTest {

    private static final String TEMP_BANNERID = "B00000000";
    private static final String TEMP_PASSWORD = "password123";

    @Test
    public void loadPolicyTest() {
        PasswordPolicy passwordPolicy = mock(PasswordPolicy.class);
        when(passwordPolicy.loadPolicy()).thenReturn(true);
        assertTrue(passwordPolicy.loadPolicy());
    }

    @Test
    public void validateTest() {
        PasswordPolicy passwordPolicy = mock(PasswordPolicy.class);
        when(passwordPolicy.isValid(TEMP_PASSWORD)).thenReturn(true);
        assertTrue(passwordPolicy.isValid(TEMP_PASSWORD));
    }

    @Test
    public void generateErrorMessageTest() {
        PasswordPolicy passwordPolicy = mock(PasswordPolicy.class);
        ArrayList<String> errorMessages = new ArrayList<>();
        errorMessages.add("The password must be atleast 5 characters.");
        errorMessages.add("The password should have atleast 1 special character.");
        when(passwordPolicy.generateErrorMessage()).thenReturn(errorMessages);
        assertEquals(passwordPolicy.generateErrorMessage(), errorMessages);
    }
}
