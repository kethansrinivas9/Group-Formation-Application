package com.group8.dalsmartteamwork.resetpassword.dao;

final class PasswordHistoryQueryConstants {
    public static final String GET_PASSWORD_HISTORY = "SELECT * FROM PasswordHistory where BannerID='%s' and Value='%s'";
    public static final String GET_CURRENT_PASSWORD = "SELECT Password FROM Users where BannerID='%s'";
    public static final String CALL_MOVE_CURRENT_PASSWORD = "CALL spMoveCurrentPassword('%s', %s)";
}