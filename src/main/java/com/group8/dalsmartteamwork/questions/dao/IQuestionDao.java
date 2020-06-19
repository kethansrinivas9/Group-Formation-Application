package com.group8.dalsmartteamwork.questions.dao;

import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.questions.Question;

public interface IQuestionDao {
    int addQuestionToDb(Question question, int questionId, String bannerId);

    Boolean addOptionToDb(Option option, int questionId);
}
