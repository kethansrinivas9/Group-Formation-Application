package com.group8.dalsmartteamwork.questions.models;

import com.group8.dalsmartteamwork.accesscontrol.CurrentUser;
import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.questions.Question;
import com.group8.dalsmartteamwork.questions.dao.IQuestionDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class QuestionOptionManager implements IQuestionOptionManager {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final IQuestionDao questionDao;

    public QuestionOptionManager(IQuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public int saveQuestion(Question question) {
        String questionTypeString = question.getType();
        CurrentUser currentUser = CurrentUser.getInstance();
        int questionType;
        int questionId;
        switch (questionTypeString) {
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
        questionId = questionDao.addQuestionToDb(question, questionType, currentUser.getBannerId());
        LOGGER.info("Question saved. QuestionID: " + question.getQuestionID());
        return questionId;
    }

    @Override
    public Boolean saveOptions(List<Option> options, int questionId) {
        Boolean status = true;
        for (Option option : options) {
            status = status && questionDao.addOptionToDb(option, questionId);
        }
        LOGGER.info("Options saved for QuestionID: " + questionId);
        return status;
    }
}
