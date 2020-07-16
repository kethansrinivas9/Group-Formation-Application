package com.group8.dalsmartteamwork.createsurvey.dao;

import java.util.List;
import com.group8.dalsmartteamwork.questions.Question;

public interface CreateSurveyTADao {
    
    List<Question> displayQuestionsTA(String BannerID,int courseID);
}