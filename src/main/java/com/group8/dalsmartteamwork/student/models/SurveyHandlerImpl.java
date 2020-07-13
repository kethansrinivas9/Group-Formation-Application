package com.group8.dalsmartteamwork.student.models;

import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.student.IQuestionDetails;
import com.group8.dalsmartteamwork.student.dao.ISurveyManagerDao;

import java.util.HashMap;
import java.util.List;

public class SurveyHandlerImpl implements ISurveyHandler {
    private ISurveyManagerDao iSurveyManagerDao;

    public SurveyHandlerImpl(ISurveyManagerDao iSurveyManagerDao){
        this.iSurveyManagerDao = iSurveyManagerDao;
    }

    @Override
    public HashMap<IQuestionDetails, List<IOption>> getQuestions(int courseId) {
        List<IQuestionDetails> questionDetails = iSurveyManagerDao.getSurveyQuestions(courseId);
        HashMap<IQuestionDetails, List<IOption>> questions = new HashMap<>();
        for(IQuestionDetails question: questionDetails) {
            if(question.getType() == 1 || question.getType() == 4){
                questions.put(question, null);
            } else{
                List<IOption> options = iSurveyManagerDao.getQuestionOptions(question.getQuestionId());
                questions.put(question, options);
            }
        }
        return questions;
    }
}
