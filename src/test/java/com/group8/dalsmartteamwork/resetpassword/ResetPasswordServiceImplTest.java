package com.group8.dalsmartteamwork.resetpassword;

import com.group8.dalsmartteamwork.resetpassword.services.ResetPasswordService;
import com.group8.dalsmartteamwork.resetpassword.services.ResetPasswordServiceImpl;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class ResetPasswordServiceImplTest {
    public static final String TEMP_BANNERID = "B00000000";
    public static final String TEMP_TOKEN = "a0a1a2a3a4a5a6a7a8a9";

    @Test
    public void sendPasswordResetMailTest() {
        ResetPasswordService resetPasswordService = mock(ResetPasswordServiceImpl.class);
        try {
            when(resetPasswordService.sendPasswordResetMail(TEMP_BANNERID, TEMP_TOKEN)).thenReturn(true);
            Boolean mailStatus = resetPasswordService.sendPasswordResetMail(TEMP_BANNERID, TEMP_TOKEN);
            assertTrue(mailStatus);
            verify(resetPasswordService).sendPasswordResetMail(TEMP_BANNERID, TEMP_TOKEN);
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
            fail();
        }
    }

}
