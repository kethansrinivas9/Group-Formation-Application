package com.group8.dalsmartteamwork.register.models;

public class ResetPasswordRequest {
	private String BannerID;

	
	public ResetPasswordRequest() {}

	public ResetPasswordRequest(String bannerID) {
		super();
		BannerID = bannerID;
	}
	
	public String getBannerID() {
		return BannerID;
	}

	public void setBannerID(String bannerID) {
		BannerID = bannerID;
	}


}
