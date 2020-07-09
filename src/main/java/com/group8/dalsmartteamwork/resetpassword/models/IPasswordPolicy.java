package com.group8.dalsmartteamwork.resetpassword.models;

import java.util.ArrayList;

public interface IPasswordPolicy {
    Boolean loadPolicy();

    Boolean isValid(String password);

    ArrayList<String> generateErrorMessage();

    String getMinLength();

    String getMaxLength();

    String getMinUpper();

    String getMinLower();

    String getMinSymbols();

    String getCharsNotAllowed();

    String getHistoryConstraint();

    int getHistoricalPasswordLimit();
}
