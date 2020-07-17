package com.group8.dalsmartteamwork.createsurvey.model;

import com.group8.dalsmartteamwork.createsurvey.dao.CreateSurveyTADao;
import com.group8.dalsmartteamwork.questions.Question;

import java.util.List;

public class CreateSurveyTAImpl implements CreateSurveyTA {
    private final CreateSurveyTADao createSurveyTADao;

    public CreateSurveyTAImpl(CreateSurveyTADao createSurveyTADao) {
        this.createSurveyTADao = createSurveyTADao;
    }


    @Override
    public List<Question> displayQuestionsTA(String BannerID, int courseID) {
        return createSurveyTADao.displayQuestionsTA(BannerID, courseID);
    }

}