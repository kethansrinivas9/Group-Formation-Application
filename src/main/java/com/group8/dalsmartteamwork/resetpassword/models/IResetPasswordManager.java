package com.group8.dalsmartteamwork.resetpassword.models;

public interface IResetPasswordManager {
    Boolean sendPasswordResetMail(String bannerID, String token);

    Boolean addResetRequest(String bannerID);

    Boolean isRequestValid(String bannerID, String token);

    Boolean updatePassword(String bannerID, String password);
}
