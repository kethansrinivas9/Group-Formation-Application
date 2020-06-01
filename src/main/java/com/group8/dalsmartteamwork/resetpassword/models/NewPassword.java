package com.group8.dalsmartteamwork.resetpassword.models;

public class NewPassword {
    private String password;
    private String bannerID;

    public NewPassword(){}

    public NewPassword(String bannerID, String password) {
        this.bannerID = bannerID;
        this.password = password;
    }

    public String getBannerID() {
        return bannerID;
    }

    public void setBannerID(String bannerID) {
        this.bannerID = bannerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
