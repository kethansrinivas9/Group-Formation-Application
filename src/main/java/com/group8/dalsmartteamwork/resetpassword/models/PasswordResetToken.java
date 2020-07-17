package com.group8.dalsmartteamwork.resetpassword.models;

import java.util.Date;

public class PasswordResetToken implements IPasswordResetToken {
    private int tokenID;
    private String bannerID;
    private String token;
    private Date timestamp;
    private String status;

    public PasswordResetToken() {
    }

    public PasswordResetToken(int tokenID, String bannerID, String token, Date timestamp, String status) {
        this.tokenID = tokenID;
        this.bannerID = bannerID;
        this.token = token;
        this.timestamp = timestamp;
        this.status = status;
    }

    @Override
    public int getTokenID() {
        return tokenID;
    }

    @Override
    public void setTokenID(int tokenID) {
        this.tokenID = tokenID;
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
    public String getToken() {
        return token;
    }

    @Override
    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatusValid() {
        this.status = "valid";
    }

    @Override
    public void setStatusExpired() {
        this.status = "expired";
    }

    @Override
    public void setStatusNotFound() {
        this.status = "notfound";
    }
}
