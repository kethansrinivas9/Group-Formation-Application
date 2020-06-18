package com.group8.dalsmartteamwork.questionmanager.dao;

import java.util.List;
import com.group8.dalsmartteamwork.questionmanager.Question;

public interface QuestionManagerDao {

    public List<Question> getAllQuestion(String BannerID);
    
    public List<Question> sortQuestionsByTitle(String BannerID);

    public List<Question> sortAllQuestionByDate(String BannerID);

    public List<Question> displayListOfQuestions(String BannerID);

    public boolean deleteQuestion(String BannerID, int questionID);

}