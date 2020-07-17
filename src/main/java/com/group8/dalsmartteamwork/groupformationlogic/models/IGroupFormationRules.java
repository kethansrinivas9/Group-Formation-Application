package com.group8.dalsmartteamwork.groupformationlogic.models;

public interface IGroupFormationRules {
    int getGroupSize();

    void setGroupSize(int groupSize);

    String getNumericRule();

    void setNumericRule(String numericRule);

    String getFreeTextRule();

    void setFreeTextRule(String freeTextRule);

    String getMultipleChoiceSingleOptionRule();

    void setMultipleChoiceSingleOptionRule(String multipleChoiceSingleOptionRule);

    String getMultipleChoiceMultipleOptionRule();

    void setMultipleChoiceMultipleOptionRule(String multipleChoiceMultipleOptionRule);

    int getNumericValue();

    void setNumericValue(int numericValue);
}
