package com.group8.dalsmartteamwork.questions.models;

import com.group8.dalsmartteamwork.questions.QuestionsFactory;
import com.group8.dalsmartteamwork.questions.dao.QuestionsDaoFactory;

public class QuestionModelsFactory extends QuestionsModelsAbstractFactory {
    private static QuestionModelsFactory instance = null;
    private IOptionRetrieveManager optionRetrieveManager;
    private IQuestionHandler questionHandler;
    private IQuestionOptionManager questionOptionManager;

    QuestionModelsFactory() {
    }

    public static QuestionModelsFactory instance() {
        if (null == instance) {
            instance = new QuestionModelsFactory();
        }
        return instance;
    }

    @Override
    public IOptionRetrieveManager optionRetrieveManager() {
        if (null == optionRetrieveManager) {
            optionRetrieveManager = new OptionRetrieveManager();
        }
        return optionRetrieveManager;
    }

    @Override
    public IQuestionHandler questionHandler() {
        if (null == questionHandler) {
            questionHandler = new QuestionHandler(QuestionsFactory.instance().question());
        }
        return questionHandler;
    }

    @Override
    public IQuestionOptionManager questionOptionManager() {
        if (null == questionOptionManager) {
            questionOptionManager = new QuestionOptionManager(QuestionsDaoFactory.instance().questionDao());
        }
        return questionOptionManager;
    }
}
