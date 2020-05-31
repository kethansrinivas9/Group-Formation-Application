package com.group8.dalsmartteamwork.resetpassword.models;

import java.sql.Timestamp;
import java.util.Date;

public class PasswordResetToken {
    private int tokenID;
    private String bannerID;
    private String token;
    private Date timestamp;
    private String status;

    public PasswordResetToken() {}

    public PasswordResetToken(int tokenID, String bannerID, String token, Date timestamp, String status) {
        this.tokenID = tokenID;
        this.bannerID = bannerID;
        this.token = token;
        this.timestamp = timestamp;
        this.status = status;
    }

    public int getTokenID() {
        return tokenID;
    }

    public void setTokenID(int tokenID) {
        this.tokenID = tokenID;
    }

    public String getBannerID() {
        return bannerID;
    }

    public void setBannerID(String bannerID) {
        this.bannerID = bannerID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatusValid() {
        this.status = "valid";
    }

    public void setStatusExpired(){
        this.status = "expired";
    }
}
