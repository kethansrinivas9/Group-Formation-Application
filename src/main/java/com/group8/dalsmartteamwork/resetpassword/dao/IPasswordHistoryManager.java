package com.group8.dalsmartteamwork.resetpassword.dao;

public interface IPasswordHistoryManager {
    Boolean moveCurrentPassword(String bannerID);

    Boolean passwordExists(String bannerID, String password);
}
