package com.group8.dalsmartteamwork.groupformationlogic.models;

public class GroupFormationRules implements IGroupFormationRules {
    private int groupSize;
    private int numericValue;
    private String numericRule;
    private String freeTextRule;
    private String multipleChoiceSingleOptionRule;
    private String multipleChoiceMultipleOptionRule;

    @Override
    public int getGroupSize() {
        return groupSize;
    }

    @Override
    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    @Override
    public int getNumericValue() {
        return numericValue;
    }

    @Override
    public void setNumericValue(int numericValue) {
        this.numericValue = numericValue;
    }

    @Override
    public String getNumericRule() {
        return numericRule;
    }

    @Override
    public void setNumericRule(String numericRule) {
        this.numericRule = numericRule;
    }

    @Override
    public String getFreeTextRule() {
        return freeTextRule;
    }

    @Override
    public void setFreeTextRule(String freeTextRule) {
        this.freeTextRule = freeTextRule;
    }

    @Override
    public String getMultipleChoiceSingleOptionRule() {
        return multipleChoiceSingleOptionRule;
    }

    @Override
    public void setMultipleChoiceSingleOptionRule(String multipleChoiceSingleOptionRule) {
        this.multipleChoiceSingleOptionRule = multipleChoiceSingleOptionRule;
    }

    @Override
    public String getMultipleChoiceMultipleOptionRule() {
        return multipleChoiceMultipleOptionRule;
    }

    @Override
    public void setMultipleChoiceMultipleOptionRule(String multipleChoiceMultipleOptionRule) {
        this.multipleChoiceMultipleOptionRule = multipleChoiceMultipleOptionRule;
    }

}
