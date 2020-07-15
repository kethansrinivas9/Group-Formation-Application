package com.group8.dalsmartteamwork.questions;

public class Option implements IOption {
    private int optionId;
    private String displayText;
    private int storedAs;

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public Option() {
    }

    public Option(String displayText, int storedAs) {
        this.displayText = displayText;
        this.storedAs = storedAs;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public int getStoredAs() {
        return storedAs;
    }

    public void setStoredAs(int storedAs) {
        this.storedAs = storedAs;
    }
}
