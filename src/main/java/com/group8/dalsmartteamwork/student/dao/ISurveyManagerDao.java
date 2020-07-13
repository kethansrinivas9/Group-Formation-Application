package com.group8.dalsmartteamwork.student.dao;

import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.student.IQuestionDetails;

import java.util.List;

public interface ISurveyManagerDao {
    List<IQuestionDetails> getSurveyQuestions(int courseId);
    List<IOption> getQuestionOptions(int questionId);
}
