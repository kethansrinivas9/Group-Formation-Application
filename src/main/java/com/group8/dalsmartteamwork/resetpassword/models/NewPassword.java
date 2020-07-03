package com.group8.dalsmartteamwork.resetpassword.models;

public class NewPassword implements INewPassword {
    private String password;
    private String bannerID;

    public NewPassword() {
    }

    public NewPassword(String bannerID, String password) {
        this.bannerID = bannerID;
        this.password = password;
    }

    @Override
    public String getBannerID() {
        return bannerID;
    }

    @Override
    public void setBannerID(String bannerID) {
        this.bannerID = bannerID;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
