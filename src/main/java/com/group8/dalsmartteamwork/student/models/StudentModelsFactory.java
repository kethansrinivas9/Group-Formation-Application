package com.group8.dalsmartteamwork.student.models;

import com.group8.dalsmartteamwork.student.dao.StudentDaoFactory;

public class StudentModelsFactory extends StudentModelsAbstractFactory {
    private static StudentModelsFactory instance = null;
    private IResponseFactory responseFactory;
    private IResponseHandler responseHandler;
    private ISurveyHandler surveyHandler;


    StudentModelsFactory() {
    }

    public static StudentModelsFactory instance() {
        if (null == instance) {
            instance = new StudentModelsFactory();
        }
        return instance;
    }

    @Override
    public IResponseFactory responseFactory() {
        if (null == responseFactory) {
            responseFactory = new ResponseFactoryImpl();
        }
        return responseFactory;
    }

    @Override
    public IResponseHandler responseHandler() {
        if (null == responseHandler) {
            responseHandler = new ResponseHandler(responseFactory());
        }
        return responseHandler;
    }

    @Override
    public ISurveyHandler surveyHandler() {
        if (null == surveyHandler) {
            surveyHandler = new SurveyHandlerImpl(StudentDaoFactory.instance().surveyManagerDao());
        }
        return surveyHandler;
    }
}
