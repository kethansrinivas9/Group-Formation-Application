package com.group8.dalsmartteamwork.resetpassword;

import org.junit.jupiter.api.Test;
import com.group8.dalsmartteamwork.resetpassword.models.ResetPasswordRequest;

import static org.junit.jupiter.api.Assertions.*;


public class ResetPasswordRequestTest {
	public static final String TEMP_BANNERID = "B00000000";

	@Test
	public void defaultConstructorTest() {
		ResetPasswordRequest request = new ResetPasswordRequest();
		assertNull(request.getBannerID());
	}
	
	@Test
	public void constructorWithArgumentTest() {
		ResetPasswordRequest request = new ResetPasswordRequest(TEMP_BANNERID);
		assertEquals(request.getBannerID(), TEMP_BANNERID, "Failed to load BannerID from constructor.");
	}
	
	@Test
	public void getBannerIDTest() {
		ResetPasswordRequest request = new ResetPasswordRequest(TEMP_BANNERID);
		assertEquals(request.getBannerID(), TEMP_BANNERID, "Failed to get BannerID.");
	}
	
	@Test
	public void setBannerIDTest() {
		ResetPasswordRequest request = new ResetPasswordRequest();
		request.setBannerID(TEMP_BANNERID);
		assertEquals(request.getBannerID(), TEMP_BANNERID, "Failed to set BannerID.");
	}
	
	
}
