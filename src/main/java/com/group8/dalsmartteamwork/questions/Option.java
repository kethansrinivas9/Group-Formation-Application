package com.group8.dalsmartteamwork.questions;

public class Option {
    private String displayText;
    private int storedAs;

    public Option(){}

    public Option(String displayText, int storedAs){
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
