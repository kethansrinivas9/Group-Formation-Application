package com.group8.dalsmartteamwork.questions;

public class Question {
    private String title;
    private String text;
    private String type;
    private static Question question;

    private Question() {}

    public static Question getInstance(){
        if (question == null){
            question = new Question();
        }
        return question;
    }

    public void reset(){
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


}
