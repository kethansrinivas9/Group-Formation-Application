package com.group8.dalsmartteamwork.questions.models;

import com.group8.dalsmartteamwork.questions.Question;

public interface IQuestionHandler {
    Question createQuestion(String title, String text, String type);

    void resetQuestion();
}
