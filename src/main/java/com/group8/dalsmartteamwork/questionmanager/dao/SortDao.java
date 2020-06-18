package com.group8.dalsmartteamwork.questionmanager.dao;

import java.util.List;
import com.group8.dalsmartteamwork.questions.Question;

public interface SortDao {

    public List<Question> getAllQuestion(String BannerID);

    public List<Question> sortQuestionsByTitle(String BannerID);

    public List<Question> sortAllQuestionByDate(String BannerID);

}