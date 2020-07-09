package com.group8.dalsmartteamwork.resetpassword.models;

import java.util.Date;

public interface IPasswordResetToken {
    int getTokenID();

    void setTokenID(int tokenID);

    String getBannerID();

    void setBannerID(String bannerID);

    String getToken();

    void setToken(String token);

    Date getTimestamp();

    void setTimestamp(Date timestamp);

    String getStatus();

    void setStatusValid();

    void setStatusExpired();

    void setStatusNotFound();
}
