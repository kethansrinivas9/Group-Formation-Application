package com.group8.dalsmartteamwork.questions.models;

import com.group8.dalsmartteamwork.questions.Question;

public interface IHandleQuestion {
    public Question createQuestion(String title, String text, String type);
    public void resetQuestion();
}
