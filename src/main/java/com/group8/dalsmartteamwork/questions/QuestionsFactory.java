package com.group8.dalsmartteamwork.questions;

import com.group8.dalsmartteamwork.questions.models.*;

public class QuestionsFactory extends QuestionsAbstractFactory{
    private static QuestionsFactory instance = null;
    private IOption option;
    private Question question;

    QuestionsFactory() {
    }

    public static QuestionsFactory instance() {
        if (null == instance) {
            instance = new QuestionsFactory();
        }
        return instance;
    }

    @Override
    public IOption option() {
        if (null == option) {
            option = new Option();
        }
        return option;
    }

    @Override
    public Question question() {
        if (null == question) {
            question = new Question();
        }
        return question;
    }
}
