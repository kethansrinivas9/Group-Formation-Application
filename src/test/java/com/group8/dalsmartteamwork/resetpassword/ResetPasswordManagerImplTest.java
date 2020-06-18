package com.group8.dalsmartteamwork.resetpassword;

import com.group8.dalsmartteamwork.resetpassword.models.IResetPasswordManager;
import com.group8.dalsmartteamwork.resetpassword.models.ResetPasswordManagerImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ResetPasswordManagerImplTest {
    public static final String TEMP_BANNERID = "B00000000";
    public static final String TEMP_TOKEN = "a0a1a2a3a4a5a6a7a8a9";
    public static final String TEMP_PASSWORD = "password123";

    @Test
    public void addResetRequestTest() {
        IResetPasswordManager resetPasswordManager = mock(ResetPasswordManagerImpl.class);
        when(resetPasswordManager.addResetRequest(TEMP_BANNERID)).thenReturn(true);
        assertTrue(resetPasswordManager.addResetRequest(TEMP_BANNERID));
        verify(resetPasswordManager).addResetRequest(TEMP_BANNERID);
    }

    @Test
    public void sendPasswordResetMailTest() {
        IResetPasswordManager resetPasswordManager = mock(ResetPasswordManagerImpl.class);
        when(resetPasswordManager.sendPasswordResetMail(TEMP_BANNERID, TEMP_TOKEN)).thenReturn(true);
        assertTrue(resetPasswordManager.sendPasswordResetMail(TEMP_BANNERID, TEMP_TOKEN));
        verify(resetPasswordManager).sendPasswordResetMail(TEMP_BANNERID, TEMP_TOKEN);
    }

    @Test
    public void isRequestValidTest() {
        IResetPasswordManager resetPasswordManager = mock(ResetPasswordManagerImpl.class);
        when(resetPasswordManager.isRequestValid(TEMP_BANNERID, TEMP_TOKEN)).thenReturn(true);
        assertTrue(resetPasswordManager.isRequestValid(TEMP_BANNERID, TEMP_TOKEN));
        verify(resetPasswordManager).isRequestValid(TEMP_BANNERID, TEMP_TOKEN);
    }

    @Test
    public void updatePasswordTest() {
        IResetPasswordManager resetPasswordManager = mock(ResetPasswordManagerImpl.class);
        when(resetPasswordManager.updatePassword(TEMP_BANNERID, TEMP_PASSWORD)).thenReturn(true);
        assertTrue(resetPasswordManager.updatePassword(TEMP_BANNERID, TEMP_PASSWORD));
        verify(resetPasswordManager).updatePassword(TEMP_BANNERID, TEMP_PASSWORD);
    }
}
