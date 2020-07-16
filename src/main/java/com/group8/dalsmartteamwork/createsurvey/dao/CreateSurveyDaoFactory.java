package com.group8.dalsmartteamwork.createsurvey.dao;

public class CreateSurveyDaoFactory extends CreateSurveyDaoAbstractFactory {
    private static CreateSurveyDaoFactory instance = null;
    private CreateSurveyDao createSurveyDao;
    private CreateSurveyTADao createSurveyTADao;

    CreateSurveyDaoFactory() {
    }

    public static CreateSurveyDaoFactory instance() {
        if (null == instance) {
            instance = new CreateSurveyDaoFactory();
        }
        return instance;
    }

    @Override
    public CreateSurveyDao createSurveyDao() {
        if (null == createSurveyDao) {
            createSurveyDao = new CreateSurveyDaoImpl();
        }
        return createSurveyDao;
    }

    @Override
    public CreateSurveyTADao createSurveyTADao() {
        if (null == createSurveyTADao) {
            createSurveyTADao = new CreateSurveyTADaoImpl();
        }
        return createSurveyTADao;
    }
}
