package com.group8.dalsmartteamwork.questions.models;

import com.group8.dalsmartteamwork.questions.Question;

public class QuestionHandler implements IQuestionHandler {
    private final Question question;

    public QuestionHandler(Question question) {
        this.question = question;
    }

    @Override
    public Question createQuestion(String title, String text, String type) {
        question.setTitle(title);
        question.setText(text);
        question.setType(type);
        return question;
    }

    @Override
    public void resetQuestion() {
        question.reset();
    }
}
