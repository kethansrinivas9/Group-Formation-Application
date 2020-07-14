package com.group8.dalsmartteamwork.student.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.student.IQuestionDetails;
import com.group8.dalsmartteamwork.student.QuestionDetails;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SurveyManagerDaoImpl implements ISurveyManagerDao {
    @Override
    public List<IQuestionDetails> getSurveyQuestions(int courseId) {
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        List<IQuestionDetails> questions = new ArrayList<>();
        try {
            procedure = new CallStoredProcedure("spGetSurveyQuestions(?)");
            procedure.setParameter(1, courseId);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()){
                IQuestionDetails iQuestionDetails = new QuestionDetails();
                iQuestionDetails.setQuestionId(resultSet.getInt("QuestionID"));
                iQuestionDetails.setText(resultSet.getString("QuestionText"));
                iQuestionDetails.setType(resultSet.getInt("TypeID"));
                questions.add(iQuestionDetails);
            }
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return questions;
    }

    @Override
    public List<IOption> getQuestionOptions(int questionId) {
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        List<IOption> options = new ArrayList<>();
        try {
            procedure = new CallStoredProcedure("spGetQuestionOptions(?)");
            procedure.setParameter(1, questionId);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()){
                IOption iOption = new Option();
                iOption.setDisplayText(resultSet.getString("DisplayText"));
                iOption.setOptionId(resultSet.getInt("OptionID"));
                iOption.setStoredAs(resultSet.getInt("StoredAs"));
                options.add(iOption);
            }
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return options;
    }

    @Override
    public void saveResponses(int questionId, String response, String bannerID) {
        CallStoredProcedure procedure = null;
        try {
            procedure = new CallStoredProcedure("spSaveResponse(?, ?, ?)");
            procedure.setParameter(1, questionId);
            procedure.setParameter(2, response);
            procedure.setParameter(3, bannerID);
            procedure.execute();
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
    }
}
