package com.group8.dalsmartteamwork.student;

public abstract class StudentAbstractFactory {
    public abstract IQuestionDetails questionDetails();

    public abstract IStudent student();

    public abstract Answer answer();

    public abstract IResponseObject freeTextResponse();

    public abstract IResponseObject multipleChoiceMultipleResponse();

    public abstract IResponseObject multipleChoiceSingleResponse();

    public abstract IResponseObject numericResponse();
}
