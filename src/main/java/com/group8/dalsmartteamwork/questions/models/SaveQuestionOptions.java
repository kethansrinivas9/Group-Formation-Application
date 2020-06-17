package com.group8.dalsmartteamwork.questions.models;

import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.questions.Question;
import com.group8.dalsmartteamwork.questions.dao.IQuestionDao;

import java.util.List;

public class SaveQuestionOptions implements ISaveQuestionOptions {
    private IQuestionDao questionDao;

    public SaveQuestionOptions(IQuestionDao questionDao){
        this.questionDao = questionDao;
    }

    @Override
    public int saveQuestion(Question question) {
        int questionType;
        int questionId;
        String questionTypeString = question.getType();
        switch (questionTypeString){
            case "numeric":
                questionType = 1;
                break;
            case "mc-one":
                questionType = 2;
                break;
            case "mc-multiple":
                questionType = 3;
                break;
            default:
                questionType = 4;
        }
        questionId =  questionDao.addQuestionToDb(question, questionType, "B456");
        return questionId;
    }

    @Override
    public Boolean saveOptions(List<Option> options, int questionId) {
        Boolean status = true;
        for(Option option: options){
            status = status && questionDao.addOptionToDb(option, questionId);
        }
        return status;
    }
}
