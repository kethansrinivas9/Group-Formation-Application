package com.group8.dalsmartteamwork.questions;

public class Question {
    private static Question question;
    private String title;
    private String text;
    private String type;
    private int questionID;

    public Question() {
    }

    public Question(String title) {
        this.title = title;
    }

    public Question(int questionID, String text) {
        this.text = text;
        this.questionID = questionID;
    }

    public static Question getInstance() {
        if (question == null) {
            question = new Question();
        }
        return question;
    }

    public void reset() {
        title = null;
        text = null;
        type = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
}
