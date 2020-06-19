package com.group8.dalsmartteamwork.questionmanager.dao;

import com.group8.dalsmartteamwork.questions.Question;

import java.util.List;

public interface SortDao {

    List<Question> getAllQuestion(String BannerID);

    List<Question> sortQuestionsByTitle(String BannerID);

    List<Question> sortAllQuestionByDate(String BannerID);

}