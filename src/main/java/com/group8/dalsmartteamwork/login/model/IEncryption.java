package com.group8.dalsmartteamwork.login.model;

public interface IEncryption {
    String encrypt(String strToEncrypt);

    String decrypt(String strToDecrypt);
}
