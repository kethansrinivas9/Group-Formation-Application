package com.group8.dalsmartteamwork.resetpassword.models;

public class ResetPasswordRequest implements IResetPasswordRequest {
    private String BannerID;

    public ResetPasswordRequest() {
    }

    public ResetPasswordRequest(String bannerID) {
        BannerID = bannerID;
    }

    @Override
    public String getBannerID() {
        return BannerID;
    }

    @Override
    public void setBannerID(String bannerID) {
        BannerID = bannerID;
    }

}
