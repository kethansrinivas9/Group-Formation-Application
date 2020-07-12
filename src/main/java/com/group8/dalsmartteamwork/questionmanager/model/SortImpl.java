package com.group8.dalsmartteamwork.questionmanager.model;

import com.group8.dalsmartteamwork.questionmanager.dao.SortDao;
import com.group8.dalsmartteamwork.questions.Question;

import java.util.List;

public class SortImpl implements Sort {
    private final SortDao sortDao;

    public SortImpl(SortDao sortDao) {
        this.sortDao = sortDao;
    }

    @Override
    public List<Question> getAllQuestion(String BannerID) {
        return sortDao.getAllQuestion(BannerID);
    }

    @Override
    public List<Question> sortQuestionsByTitle(String BannerID) {
        return sortDao.sortQuestionsByTitle(BannerID);
    }

    @Override
    public List<Question> sortAllQuestionByDate(String BannerID) {
        return sortDao.sortAllQuestionByDate(BannerID);
    }
}