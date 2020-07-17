package com.group8.dalsmartteamwork.resetpassword;

import com.group8.dalsmartteamwork.resetpassword.dao.ResetPasswordDaoImpl;
import com.group8.dalsmartteamwork.resetpassword.models.IPasswordResetToken;
import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;
import com.group8.dalsmartteamwork.resetpassword.models.ResetToken;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ResetPasswordDaoImplTest {
    public static final String TEMP_BANNERID = "B00000000";
    public static final String TEMP_TOKEN = "a0a1a2a3a4a5a6a7a8a9";
    public static final String TEMP_PASSWORD = "Test@123";
    public static final String TEMP_EMAIL = "test123@gmail.com";
    ResetPasswordDaoImpl resetPasswordDaoImplMock = mock(ResetPasswordDaoImpl.class);

    @Test
    public void addTokenTwoArgumentsTest() {
        ResetToken resetToken = new ResetToken();
        String token = resetToken.createToken();
        when(resetPasswordDaoImplMock.addToken(TEMP_BANNERID, token)).thenReturn(true);
        assertTrue(resetPasswordDaoImplMock.addToken(TEMP_BANNERID, token), "Database token insertion failed");
        verify(resetPasswordDaoImplMock).addToken(TEMP_BANNERID, token);
    }

    @Test
    public void addTokenOneArgumentTest() {
        when(resetPasswordDaoImplMock.addToken(TEMP_BANNERID)).thenReturn(true);
        assertTrue(resetPasswordDaoImplMock.addToken(TEMP_BANNERID), "Database token insertion failed");
        verify(resetPasswordDaoImplMock).addToken(TEMP_BANNERID);
    }

    @Test
    public void resetTokensTest() {
        when(resetPasswordDaoImplMock.updateTokenStatus()).thenReturn(true);
        assertTrue(resetPasswordDaoImplMock.updateTokenStatus(), "Tokens were not reset");
        verify(resetPasswordDaoImplMock).updateTokenStatus();
    }

    @Test
    public void getRequestByTokenTest() {
        IPasswordResetToken passwordResetToken = new PasswordResetToken(1, TEMP_BANNERID, TEMP_TOKEN, new Date(), "valid");

        when(resetPasswordDaoImplMock.getPasswordResetRequest(TEMP_BANNERID, TEMP_TOKEN)).thenReturn(passwordResetToken);
        passwordResetToken = resetPasswordDaoImplMock.getPasswordResetRequest(TEMP_BANNERID, TEMP_TOKEN);
        if (!passwordResetToken.getStatus().equals("expired") && !passwordResetToken.getStatus().equals("notfound")) {
            assertEquals(passwordResetToken.getBannerID(), TEMP_BANNERID, "Unable to retrieve Password Token Data");
            assertEquals(passwordResetToken.getToken(), TEMP_TOKEN, "Unable to retrieve Password Token Data");
            assertNotNull(passwordResetToken.getTimestamp(), "Unable to retrieve Password Token Data");
            assertEquals(passwordResetToken.getStatus(), "valid", "Unable to retrieve Password Token Data");
        }
        verify(resetPasswordDaoImplMock).getPasswordResetRequest(TEMP_BANNERID, TEMP_TOKEN);
    }

    @Test
    public void updatePasswordTest() {
        when(resetPasswordDaoImplMock.addToken(TEMP_BANNERID, TEMP_PASSWORD)).thenReturn(true);
        assertTrue(resetPasswordDaoImplMock.addToken(TEMP_BANNERID, TEMP_PASSWORD), "Password not updated in the database");
        verify(resetPasswordDaoImplMock).addToken(TEMP_BANNERID, TEMP_PASSWORD);
    }

    @Test
    void getUserEmailTest() {
        when(resetPasswordDaoImplMock.getUserEmail(TEMP_BANNERID)).thenReturn(TEMP_EMAIL);
        assertEquals(resetPasswordDaoImplMock.getUserEmail(TEMP_BANNERID), TEMP_EMAIL, "Failed to get user Email");
        verify(resetPasswordDaoImplMock).getUserEmail(TEMP_BANNERID);
    }

    @Test
    void userExistsTest() {
        when(resetPasswordDaoImplMock.userExists(TEMP_BANNERID)).thenReturn(true);
        assertTrue(resetPasswordDaoImplMock.userExists(TEMP_BANNERID));
        verify(resetPasswordDaoImplMock).userExists(TEMP_BANNERID);
    }


}
