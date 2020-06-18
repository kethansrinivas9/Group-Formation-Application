package com.group8.dalsmartteamwork.questionmanager.model;

import java.util.List;
import com.group8.dalsmartteamwork.questionmanager.dao.DeleteDao;
import com.group8.dalsmartteamwork.questions.Question;

public class DeleteImp implements Delete {
    private DeleteDao deleteDao;

    public DeleteImp(DeleteDao deleteDao) {
        this.deleteDao = deleteDao;
    }

    @Override
    public List<Question> displayListOfQuestions(String BannerID) {
        return deleteDao.displayListOfQuestions(BannerID);
    }

    @Override
    public boolean deleteQuestion(int questionID) {
        return deleteDao.deleteQuestion(questionID);
    }
}