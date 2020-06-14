package com.group8.dalsmartteamwork.resetpassword.services;

import java.sql.SQLException;

public interface ResetPasswordService {
    Boolean sendPasswordResetMail(String bannerID, String token) throws SQLException ;
}
