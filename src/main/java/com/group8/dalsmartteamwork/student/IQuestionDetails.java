package com.group8.dalsmartteamwork.student;

public interface IQuestionDetails {
    int getQuestionId();
    void setQuestionId(int questionId);
    String getText();
    int getType();
    void setText(String text);
    void setType(int type);
}
