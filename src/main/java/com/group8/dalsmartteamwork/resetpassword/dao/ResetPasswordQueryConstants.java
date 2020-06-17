package com.group8.dalsmartteamwork.resetpassword.dao;

final class ResetPasswordQueryConstants {
    public static final String INSERT_TOKEN = "INSERT INTO PasswordResetToken (BannerID, Token, Timestamp, Status) VALUES ('%s', '%s', now(), 'valid')";
    public static final String CALL_UPDATE_TOKEN_STATUS = "CALL resettokens";
    public static final String GET_RESET_REQUEST = "SELECT * FROM PasswordResetToken WHERE BannerID='%s' and token='%s'";
    public static final String UPDATE_PASSWORD = "UPDATE Users SET Password='%s' WHERE BannerID='%s'";
    public static final String UPDATE_REQUEST_STATUS = "UPDATE PasswordResetToken SET Status='expired' WHERE BannerID='%s'";
    public static final String GET_USER = "SELECT * FROM Users WHERE BannerID='%s'";
}
