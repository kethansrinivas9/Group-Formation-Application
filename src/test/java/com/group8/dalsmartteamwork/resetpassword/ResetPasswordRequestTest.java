package com.group8.dalsmartteamwork.resetpassword;

import com.group8.dalsmartteamwork.resetpassword.models.IResetPasswordRequest;
import com.group8.dalsmartteamwork.resetpassword.models.ResetPasswordRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class ResetPasswordRequestTest {
    public static final String TEMP_BANNERID = "B00000000";

    @Test
    public void defaultConstructorTest() {
        IResetPasswordRequest request = new ResetPasswordRequest();
        assertNull(request.getBannerID());
    }

    @Test
    public void constructorWithArgumentTest() {
        IResetPasswordRequest request = new ResetPasswordRequest(TEMP_BANNERID);
        assertEquals(request.getBannerID(), TEMP_BANNERID, "Failed to load BannerID from constructor.");
    }

    @Test
    public void getBannerIDTest() {
        IResetPasswordRequest request = new ResetPasswordRequest(TEMP_BANNERID);
        assertEquals(request.getBannerID(), TEMP_BANNERID, "Failed to get BannerID.");
    }

    @Test
    public void setBannerIDTest() {
        IResetPasswordRequest request = new ResetPasswordRequest();
        request.setBannerID(TEMP_BANNERID);
        assertEquals(request.getBannerID(), TEMP_BANNERID, "Failed to set BannerID.");
    }
}
