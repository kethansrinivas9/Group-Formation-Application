package com.group8.dalsmartteamwork.resetpassword.dao;

import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;

import java.sql.SQLException;

public interface ResetPasswordDao {
	public Boolean addToken(String BannerID) throws SQLException;
	public Boolean addToken(String BannerID, String Token) throws SQLException;
	public Boolean resetTokens() throws SQLException;
	public PasswordResetToken getRequestByToken(String bannerID, String token) throws SQLException;
	public Boolean updatePassword(String bannerID, String password) throws SQLException;
}
