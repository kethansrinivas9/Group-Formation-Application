package com.group8.dalsmartteamwork.createsurvey.model;

import java.util.List;
import com.group8.dalsmartteamwork.questions.Question;

public interface CreateSurveyTA {

    List<Question> displayQuestionsTA(String BannerID,int courseID);
}