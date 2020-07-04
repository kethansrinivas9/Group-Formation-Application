package com.group8.dalsmartteamwork.resetpassword;

import com.group8.dalsmartteamwork.resetpassword.models.IResetToken;
import com.group8.dalsmartteamwork.resetpassword.models.ResetToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ResetTokenTest {

    @Test
    public void createTokenTest() {
        IResetToken resetToken = new ResetToken();
        String token = resetToken.createToken();
        assertNotNull(token, "Token for password reset wasn't generated.");
    }

    @Test
    public void getRandomCharTest() {
        char randomChar = ResetToken.getRandomChar();
        assertNotNull(String.valueOf(randomChar), "Random character for token generation not generated.");
    }
}
