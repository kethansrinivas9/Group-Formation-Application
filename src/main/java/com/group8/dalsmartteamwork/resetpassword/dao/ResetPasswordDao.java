package com.group8.dalsmartteamwork.resetpassword.dao;

import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;

import java.sql.SQLException;

public interface ResetPasswordDao {
    Boolean addToken(String bannerID) throws SQLException;

    Boolean addToken(String bannerID, String token) throws SQLException;

    Boolean resetTokens() throws SQLException;

    PasswordResetToken getRequestByToken(String bannerID, String token) throws SQLException;

    Boolean updatePassword(String bannerID, String password) throws SQLException;
}
