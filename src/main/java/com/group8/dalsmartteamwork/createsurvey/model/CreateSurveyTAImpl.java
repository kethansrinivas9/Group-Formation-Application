package com.group8.dalsmartteamwork.createsurvey.model;

import java.util.List;

import com.group8.dalsmartteamwork.createsurvey.dao.ICreateSurveyTADao;
import com.group8.dalsmartteamwork.questions.Question;

public class CreateSurveyTAImpl implements CreateSurveyTA {
    private final ICreateSurveyTADao iCreateSurveyTADao;

    public CreateSurveyTAImpl(ICreateSurveyTADao iCreateSurveyTADao) {
        this.iCreateSurveyTADao = iCreateSurveyTADao;
    }
    

    @Override
    public List<Question> displayQuestionsTA(String BannerID, int courseID) {
        return iCreateSurveyTADao.displayQuestionsTA(BannerID, courseID);
    }
    
}