package com.group8.dalsmartteamwork.student;

public class QuestionDetails implements IQuestionDetails {
    private int questionId;
    private String text;
    private int type;

    public QuestionDetails() {
    }

    public QuestionDetails(int questionId, String text, int type) {
        this.questionId = questionId;
        this.text = text;
        this.type = type;
    }

    @Override
    public int getQuestionId() {
        return questionId;
    }

    @Override
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public void setType(int type) {
        this.type = type;
    }
}
