package com.group8.dalsmartteamwork.questions.models;

import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.questions.Question;

import java.util.List;

public interface IQuestionOptionManager {
    int saveQuestion(Question question);

    Boolean saveOptions(List<Option> options, int questionId);
}
