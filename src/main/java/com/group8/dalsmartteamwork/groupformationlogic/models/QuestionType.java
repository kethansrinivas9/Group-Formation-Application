package com.group8.dalsmartteamwork.groupformationlogic.models;

public enum QuestionType {
    NUMERIC(1),
    MULTIPLE_CHOICE_SINGLE_OPTION(2),
    MULTIPLE_CHOICE_MULTIPLE_OPTION(3),
    FREE_TEXT(4);

    private final int value;

    QuestionType(final int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }
}
