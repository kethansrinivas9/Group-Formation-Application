package com.group8.dalsmartteamwork.resetpassword.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class PasswordPolicy implements IPasswordPolicy {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private String minLength;
    private String maxLength;
    private String minUpper;
    private String minLower;
    private String minSymbols;
    private String charsNotAllowed;
    private String historyConstraint;
    private int historicalPasswordLimit;


    public PasswordPolicy() {
        loadPolicy();
    }

    @Override
    public Boolean loadPolicy() {
        this.minLength = System.getenv("password.minLength");
        this.maxLength = System.getenv("password.maxLength");
        this.minUpper = System.getenv("password.minUpper");
        this.minLower = System.getenv("password.minLower");
        this.minSymbols = System.getenv("password.minSymbols");
        this.charsNotAllowed = System.getenv("password.charsNotAllowed");
        this.historyConstraint = System.getenv("password.historyConstraint");
        this.historicalPasswordLimit = Integer.parseInt(System.getenv("password.historicalPasswords"));
        LOGGER.info("Password Policy loaded successfully");
        return true;
    }

    @Override
    public String getMinLength() {
        return minLength;
    }

    @Override
    public String getMaxLength() {
        return maxLength;
    }

    @Override
    public String getMinUpper() {
        return minUpper;
    }

    @Override
    public String getMinLower() {
        return minLower;
    }

    @Override
    public String getMinSymbols() {
        return minSymbols;
    }

    @Override
    public String getCharsNotAllowed() {
        return charsNotAllowed;
    }

    @Override
    public String getHistoryConstraint() {
        return historyConstraint;
    }

    @Override
    public int getHistoricalPasswordLimit() {
        return historicalPasswordLimit;
    }

    @Override
    public Boolean isValid(String password) {

        int passwordLength = password.length();

        if (!this.minLength.equals("false")) {
            int minLength = Integer.parseInt(this.minLength);
            if (minLength > passwordLength) {
                LOGGER.warn("The password does not satisfy the minimum length requirement");
                return false;
            }
        }

        if (!this.maxLength.equals("false")) {
            int maxLength = Integer.parseInt(this.maxLength);
            if (maxLength < passwordLength) {
                LOGGER.warn("The password does not satisfy the maximum length requirement");
                return false;
            }
        }

        if (!this.minUpper.equals("false")) {
            int minUpper = Integer.parseInt(this.minUpper);
            int count = 0;
            for (int i = 0; i < passwordLength; i++) {
                if (isUpperCase(password.charAt(i))) {
                    ++count;
                }
            }
            if (count < minUpper) {
                LOGGER.warn("The password does not satisfy the minimum uppercase characters requirement");
                return false;
            }
        }

        if (!this.minLower.equals("false")) {
            int minLower = Integer.parseInt(this.minLower);
            int count = 0;
            for (int i = 0; i < passwordLength; i++) {
                if (isLowerCase(password.charAt(i))) {
                    ++count;
                }
            }
            if (count < minLower) {
                LOGGER.warn("The password does not satisfy the minimum lowercase characters requirement");
                return false;
            }
        }

        if (!this.minSymbols.equals("false")) {
            int minSymbols = Integer.parseInt(this.minSymbols);
            String symbols = "+-*@#~";
            int count = 0;
            for (int i = 0; i < passwordLength; i++) {
                if (symbols.contains(Character.toString(password.charAt(i)))) {
                    ++count;
                }
            }
            if (count < minSymbols) {
                LOGGER.warn("The password does not satisfy the minimum symbols requirement");
                return false;
            }
        }

        if (!this.charsNotAllowed.equals("false")) {
            String symbolsNotAllowed = this.charsNotAllowed;
            for (int i = 0; i < passwordLength; i++) {
                if (symbolsNotAllowed.contains(Character.toString(password.charAt(i)))) {
                    LOGGER.warn("The password has characters that are not allowed");
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public ArrayList<String> generateErrorMessage() {
        ArrayList<String> errorMessages = new ArrayList<>();

        if (!this.minLength.equals("false")) {
            String errorMessage = "";
            errorMessage += "The password must contain atleast " + this.minLength + " characters.";
            errorMessages.add(errorMessage);
        }

        if (!this.maxLength.equals("false")) {
            String errorMessage = "";
            errorMessage += "The password must contain atmost " + this.maxLength + " characters.";
            errorMessages.add(errorMessage);
        }

        if (!this.minUpper.equals("false")) {
            String errorMessage = "";
            errorMessage += "The password must contain atleast " + this.minUpper + " Upper Case characters.";
            errorMessages.add(errorMessage);
        }

        if (!this.minLower.equals("false")) {
            String errorMessage = "";
            errorMessage += "The password must contain atleast " + this.minLower + " Lower Case characters.";
            errorMessages.add(errorMessage);
        }

        if (!this.minSymbols.equals("false")) {
            String errorMessage = "";
            errorMessage += "The password must contain atleast " + this.minSymbols + " special characters.";
            errorMessages.add(errorMessage);
        }

        if (!this.charsNotAllowed.equals("false")) {
            StringBuilder errorMessage = new StringBuilder();
            errorMessage.append("Using ");
            for (int i = 0; i < charsNotAllowed.length() - 1; i++) {
                errorMessage.append(charsNotAllowed.charAt(i));
                errorMessage.append(", ");
            }
            errorMessage.append(charsNotAllowed.charAt(charsNotAllowed.length() - 1));
            errorMessage.append(" is not allowed.");
            errorMessages.add(errorMessage.toString());
        }
        return errorMessages;
    }
}