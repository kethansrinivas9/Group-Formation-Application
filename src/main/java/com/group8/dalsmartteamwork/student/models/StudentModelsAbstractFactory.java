package com.group8.dalsmartteamwork.student.models;

public abstract class StudentModelsAbstractFactory {
    public abstract IResponseFactory responseFactory();

    public abstract IResponseHandler responseHandler();

    public abstract ISurveyHandler surveyHandler();
}
