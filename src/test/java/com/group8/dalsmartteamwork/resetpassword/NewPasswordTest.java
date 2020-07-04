package com.group8.dalsmartteamwork.resetpassword;

import com.group8.dalsmartteamwork.resetpassword.models.INewPassword;
import com.group8.dalsmartteamwork.resetpassword.models.NewPassword;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NewPasswordTest {

    private static final String TEMP_BANNERID = "B00000000";
    private static final String TEMP_PASSWORD = "abcdefgh";

    @Test
    public void defaultConstructorTest() {
        INewPassword newPassword = new NewPassword();
        assertNull(newPassword.getPassword());
    }

    @Test
    public void constructorWithTwoArgumentsTest() {
        INewPassword newPassword = new NewPassword(TEMP_BANNERID, TEMP_PASSWORD);
        assertEquals(newPassword.getPassword(), TEMP_PASSWORD, "The password string was not set.");
        assertEquals(newPassword.getBannerID(), TEMP_BANNERID, "The bannerID string was not set.");
    }

    @Test
    public void getBannerIDTest() {
        INewPassword newPassword = new NewPassword(TEMP_BANNERID, TEMP_PASSWORD);
        assertEquals(newPassword.getBannerID(), TEMP_BANNERID, "Unable to retrieve password string.");
    }

    @Test
    public void setBannerIDTest() {
        INewPassword newPassword = new NewPassword();
        newPassword.setBannerID(TEMP_BANNERID);
        assertEquals(newPassword.getBannerID(), TEMP_BANNERID, "Unable to set BannerID string.");
    }

    @Test
    public void getPasswordTest() {
        INewPassword newPassword = new NewPassword(TEMP_BANNERID, TEMP_PASSWORD);
        assertEquals(newPassword.getPassword(), TEMP_PASSWORD, "Unable to retrieve password string.");
    }

    @Test
    public void setPasswordTest() {
        INewPassword newPassword = new NewPassword();
        newPassword.setPassword(TEMP_PASSWORD);
        assertEquals(newPassword.getPassword(), TEMP_PASSWORD, "Unable to set password string.");
    }
}
