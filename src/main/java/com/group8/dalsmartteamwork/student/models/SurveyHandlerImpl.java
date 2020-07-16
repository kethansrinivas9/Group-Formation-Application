package com.group8.dalsmartteamwork.student.models;

import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.student.IQuestionDetails;
import com.group8.dalsmartteamwork.student.dao.ISurveyManagerDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurveyHandlerImpl implements ISurveyHandler {
    private ISurveyManagerDao iSurveyManagerDao;

    public SurveyHandlerImpl(ISurveyManagerDao iSurveyManagerDao) {
        this.iSurveyManagerDao = iSurveyManagerDao;
    }

    @Override
    public Map<IQuestionDetails, List<IOption>> getQuestions(int courseId) {
        List<IQuestionDetails> questionDetails = iSurveyManagerDao.getSurveyQuestions(courseId);
        Map<IQuestionDetails, List<IOption>> questions = new HashMap<>();
        for (IQuestionDetails question : questionDetails) {
            if (question.getType() == 1 || question.getType() == 4) {
                questions.put(question, null);
            } else {
                List<IOption> options = iSurveyManagerDao.getQuestionOptions(question.getQuestionId());
                questions.put(question, options);
            }
        }
        return questions;
    }

    @Override
    public Boolean saveResponses(Map<Integer, List<String>> answers, String bannerId, int courseId) {
        Boolean status = true;
        for (Integer questionId : answers.keySet()) {
            for (String response : answers.get(questionId)) {
                status = status && iSurveyManagerDao.saveResponses(questionId, response, bannerId, courseId);
            }
        }
        return status;
    }

    @Override
    public Boolean getSurveyPublishStatus(int courseId) {
        return iSurveyManagerDao.getSurveyPublishStatus(courseId);
    }

}
