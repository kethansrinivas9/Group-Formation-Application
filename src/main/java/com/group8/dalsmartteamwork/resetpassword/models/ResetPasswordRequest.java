package com.group8.dalsmartteamwork.resetpassword.models;

public class ResetPasswordRequest {
	private String BannerID;

	public ResetPasswordRequest() {}

	public ResetPasswordRequest(String bannerID) {
		BannerID = bannerID;
	}
	
	public String getBannerID() {
		return BannerID;
	}

	public void setBannerID(String bannerID) {
		BannerID = bannerID;
	}


}
