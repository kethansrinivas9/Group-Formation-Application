package com.group8.dalsmartteamwork.questionmanager.model;

import java.util.List;
import com.group8.dalsmartteamwork.questions.Question;

public interface Sort {

    public List<Question> getAllQuestion(String BannerID);

    public List<Question> sortQuestionsByTitle(String BannerID);

    public List<Question> sortAllQuestionByDate(String BannerID);

}