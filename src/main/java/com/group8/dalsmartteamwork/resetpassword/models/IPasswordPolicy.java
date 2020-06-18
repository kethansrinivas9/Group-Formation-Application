package com.group8.dalsmartteamwork.resetpassword.models;

import java.util.ArrayList;

public interface IPasswordPolicy {
    Boolean loadPolicy();

    Boolean isValid(String password);

    ArrayList<String> generateErrorMessage();
}
