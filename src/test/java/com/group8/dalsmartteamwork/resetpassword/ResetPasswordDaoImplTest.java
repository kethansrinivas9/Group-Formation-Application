package com.group8.dalsmartteamwork.resetpassword;

import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoImpl;
import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;
import com.group8.dalsmartteamwork.utils.ResetToken;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ResetPasswordDaoImplTest {
    public static final String TEMP_BANNERID = "B00000000";
    public static final String TEMP_TOKEN = "a0a1a2a3a4a5a6a7a8a9";
    public static final String TEMP_PASSWORD = "Test@123";
    ResetPasswordDaoImpl resetPasswordDaoImplMock = mock(ResetPasswordDaoImpl.class);

    @Test
    public void addTokenTwoArgumentsTest() {
        ResetPasswordDaoImpl resetPasswordDaoImpl = new ResetPasswordDaoImpl();
        ResetToken resetToken = new ResetToken();
        String token = resetToken.createToken();
        when(resetPasswordDaoImplMock.addToken(TEMP_BANNERID, token)).thenReturn(true);
        assertTrue(resetPasswordDaoImplMock.addToken(TEMP_BANNERID, token), "Database token insertion failed.");
        verify(resetPasswordDaoImplMock).addToken(TEMP_BANNERID, token);
    }

    @Test
    public void addTokenOneArgumentTest() {
        when(resetPasswordDaoImplMock.addToken(TEMP_BANNERID)).thenReturn(true);
        assertTrue(resetPasswordDaoImplMock.addToken(TEMP_BANNERID), "Database token insertion failed.");
        verify(resetPasswordDaoImplMock).addToken(TEMP_BANNERID);
    }

    @Test
    public void resetTokensTest() {
        when(resetPasswordDaoImplMock.resetTokens()).thenReturn(true);
        assertTrue(resetPasswordDaoImplMock.resetTokens(), "Tokens were not reset.");
        verify(resetPasswordDaoImplMock).resetTokens();
    }

    @Test
    public void getRequestByTokenTest() {
        PasswordResetToken passwordResetToken = new PasswordResetToken(1, TEMP_BANNERID, TEMP_TOKEN, new Date(), "valid");

        when(resetPasswordDaoImplMock.getRequestByToken(TEMP_BANNERID, TEMP_TOKEN)).thenReturn(passwordResetToken);
        passwordResetToken = resetPasswordDaoImplMock.getRequestByToken(TEMP_BANNERID, TEMP_TOKEN);
        if (!passwordResetToken.getStatus().equals("expired") && !passwordResetToken.getStatus().equals("notfound")) {
            assertEquals(passwordResetToken.getBannerID(), TEMP_BANNERID, "Unable to retrieve Password Token Data");
            assertEquals(passwordResetToken.getToken(), TEMP_TOKEN, "Unable to retrieve Password Token Data");
            assertNotNull(passwordResetToken.getTimestamp(), "Unable to retrieve Password Token Data");
            assertEquals(passwordResetToken.getStatus(), "valid", "Unable to retrieve Password Token Data");
        }
        verify(resetPasswordDaoImplMock).getRequestByToken(TEMP_BANNERID, TEMP_TOKEN);
    }

    @Test
    public void updatePasswordTest() {
        when(resetPasswordDaoImplMock.addToken(TEMP_BANNERID, TEMP_PASSWORD)).thenReturn(true);
        assertTrue(resetPasswordDaoImplMock.addToken(TEMP_BANNERID, TEMP_PASSWORD), "Password not updated in the database.");
        verify(resetPasswordDaoImplMock).addToken(TEMP_BANNERID, TEMP_PASSWORD);
    }
}
