package com.group8.dalsmartteamwork.resetpassword.models;

public interface IMail {
    Boolean sendEmail(String toEmail, String subject, String text);
}
