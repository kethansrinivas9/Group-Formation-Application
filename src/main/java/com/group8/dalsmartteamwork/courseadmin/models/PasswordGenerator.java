package com.group8.dalsmartteamwork.courseadmin.models;

import java.util.Random;

public class PasswordGenerator implements IPasswordGenerator {
    @Override
    public String generatePassword() {
        String ALLOWED_CHARS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM0987654321";
        int len = ALLOWED_CHARS.length();
        StringBuilder stringBuilder = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 15; i++) {
            stringBuilder.append(ALLOWED_CHARS.charAt(rand.nextInt(len)));
        }
        return stringBuilder.toString();
    }
}
