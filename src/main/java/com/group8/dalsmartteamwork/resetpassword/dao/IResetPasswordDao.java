package com.group8.dalsmartteamwork.resetpassword.dao;

import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;

import java.sql.SQLException;

public interface IResetPasswordDao {
    Boolean addToken(String bannerID) throws SQLException;

    Boolean addToken(String bannerID, String token) throws SQLException;

    Boolean updateTokenStatus() throws SQLException;

    PasswordResetToken getPasswordResetRequest(String bannerID, String token) throws SQLException;

    Boolean updatePassword(String bannerID, String password) throws SQLException;

    String getUserEmail(String bannerID) throws SQLException;

    Boolean userExists(String bannerID) throws SQLException;
}
