package com.group8.dalsmartteamwork.utils;

import java.util.Random;

public class ResetToken {
    public static char getRandomChar() {
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        return characterSet.charAt(random.nextInt(62));
    }

    public String createToken() {
        String tokenResult = "";
        try {
            for (int i = 0; i < 20; i++) {
                tokenResult += getRandomChar();
            }
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        }
        return tokenResult;
    }
}
