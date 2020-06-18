package com.group8.dalsmartteamwork.resetpassword.models;

import java.sql.SQLException;

public interface IResetPasswordManager {
    Boolean sendPasswordResetMail(String bannerID, String token) throws SQLException;

    Boolean addResetRequest(String bannerID) throws SQLException;
}
