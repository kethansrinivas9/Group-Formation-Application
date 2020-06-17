package com.group8.dalsmartteamwork.questions.dao;

import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.questions.Question;

import java.util.List;

public interface IQuestionDao {
    public int addQuestionToDb(Question question, int questionId, String bannerId);
    public Boolean addOptionToDb(Option option, int questionId);
}
