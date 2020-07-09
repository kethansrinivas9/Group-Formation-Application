package com.group8.dalsmartteamwork.resetpassword;

import com.group8.dalsmartteamwork.resetpassword.dao.IPasswordHistoryManager;
import com.group8.dalsmartteamwork.resetpassword.dao.PasswordHistoryManagerImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PasswordHistoryManagerImplTest {
    public static final String TEMP_BANNERID = "B00000000";
    public static final String TEMP_PASSWORD = "password123";

    @Test
    public void moveCurrentPasswordTest() {
        IPasswordHistoryManager passwordHistoryManager = mock(PasswordHistoryManagerImpl.class);
        when(passwordHistoryManager.moveCurrentPassword(TEMP_BANNERID)).thenReturn(true);
        assertTrue(passwordHistoryManager.moveCurrentPassword(TEMP_BANNERID));
        verify(passwordHistoryManager).moveCurrentPassword(TEMP_BANNERID);
    }

    @Test
    public void passwordExistsTest() {
        IPasswordHistoryManager passwordHistoryManager = mock(PasswordHistoryManagerImpl.class);
        when(passwordHistoryManager.passwordExists(TEMP_BANNERID, TEMP_PASSWORD)).thenReturn(true);
        assertTrue(passwordHistoryManager.passwordExists(TEMP_BANNERID, TEMP_PASSWORD));
        verify(passwordHistoryManager).passwordExists(TEMP_BANNERID, TEMP_PASSWORD);
    }

}
