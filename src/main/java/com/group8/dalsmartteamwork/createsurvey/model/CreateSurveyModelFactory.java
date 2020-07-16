package com.group8.dalsmartteamwork.createsurvey.model;

import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyDaoFactory;

public class CreateSurveyModelFactory extends CreateSurveyModelAbstractFactory {
    private static CreateSurveyModelFactory instance = null;
    private CreateSurvey createSurvey;
    private CreateSurveyTA createSurveyTA;

    CreateSurveyModelFactory() {
    }

    public static CreateSurveyModelFactory instance() {
        if (null == instance) {
            instance = new CreateSurveyModelFactory();
        }
        return instance;
    }

    @Override
    public CreateSurvey createSurvey() {
        if (null == createSurvey) {
            createSurvey = new CreateSurveyImpl(CreateSurveyDaoFactory.instance().createSurveyDao());
        }
        return createSurvey;
    }

    @Override
    public CreateSurveyTA createSurveyTA() {
        if (null == createSurveyTA) {
            createSurveyTA = new CreateSurveyTAImpl(CreateSurveyDaoFactory.instance().createSurveyTADao());
        }
        return createSurveyTA;
    }
}
