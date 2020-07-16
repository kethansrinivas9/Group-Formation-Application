package com.group8.dalsmartteamwork.questions.models;

public abstract class QuestionsModelsAbstractFactory {
    public abstract IOptionRetrieveManager optionRetrieveManager();

    public abstract IQuestionHandler questionHandler();

    public abstract IQuestionOptionManager questionOptionManager();
}
