package com.group8.dalsmartteamwork.resetpassword.models;

import java.util.Random;

public class ResetToken implements IResetToken {
    public static char getRandomChar() {
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        return characterSet.charAt(random.nextInt(62));
    }

    @Override
    public String createToken() {
        StringBuilder tokenResult = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            tokenResult.append(getRandomChar());
        }
        return tokenResult.toString();
    }
}