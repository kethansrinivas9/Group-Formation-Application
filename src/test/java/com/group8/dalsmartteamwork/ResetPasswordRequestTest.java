package com.group8.dalsmartteamwork;

import org.junit.jupiter.api.Test;
import com.group8.dalsmartteamwork.register.models.ResetPasswordRequest;

import static org.junit.jupiter.api.Assertions.*;


public class ResetPasswordRequestTest {
	public static final String TEMP_BannerID = "B00853506";

	@Test
	public void defaultConstructorTest() {
		ResetPasswordRequest request = new ResetPasswordRequest();
		assertNull(request.getBannerID());
	}
	
	@Test
	public void constructorWithArgumentTest() {
		ResetPasswordRequest request = new ResetPasswordRequest(TEMP_BannerID);
		assertTrue(request.getBannerID().equals(TEMP_BannerID));
	}
	
	@Test
	public void getBannerIDTest() {
		ResetPasswordRequest request = new ResetPasswordRequest(TEMP_BannerID);
		assertTrue(request.getBannerID().equals(TEMP_BannerID));
	}
	
	@Test
	public void setBannerIDTest() {
		ResetPasswordRequest request = new ResetPasswordRequest();
		request.setBannerID(TEMP_BannerID);
		assertTrue(request.getBannerID().equals(TEMP_BannerID));
	}
	
	
}
