package com.group8.dalsmartteamwork.student.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.questions.IOption;
import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.student.IQuestionDetails;
import com.group8.dalsmartteamwork.student.QuestionDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SurveyManagerDaoImpl implements ISurveyManagerDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<IQuestionDetails> getSurveyQuestions(int courseId) {
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        List<IQuestionDetails> questions = new ArrayList<>();
        try {
            procedure = new CallStoredProcedure("spGetSurveyQuestions(?)");
            procedure.setParameter(1, courseId);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                IQuestionDetails iQuestionDetails = new QuestionDetails();
                iQuestionDetails.setQuestionId(resultSet.getInt("QuestionID"));
                iQuestionDetails.setText(resultSet.getString("QuestionText"));
                iQuestionDetails.setType(resultSet.getInt("TypeID"));
                questions.add(iQuestionDetails);
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred while getting survey questions. ", e);
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
            while (resultSet.next()) {
                IOption iOption = new Option();
                iOption.setDisplayText(resultSet.getString("DisplayText"));
                iOption.setOptionId(resultSet.getInt("OptionID"));
                iOption.setStoredAs(resultSet.getInt("StoredAs"));
                options.add(iOption);
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred while getting question's options. QuestionID: " + questionId + ".", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return options;
    }

    @Override
    public Boolean saveResponses(int questionId, String response, String bannerId, int courseId) {
        CallStoredProcedure procedure = null;
        try {
            procedure = new CallStoredProcedure("spSaveResponse(?, ?, ?, ?)");
            procedure.setParameter(1, questionId);
            procedure.setParameter(2, response);
            procedure.setParameter(3, bannerId);
            procedure.setParameter(4, courseId);
            procedure.execute();
            return true;
        } catch (Exception e) {
            LOGGER.info(String.format("Responses saved for QuestionID: %s, BannerID: %s, courseID: %d.", questionId, bannerId, courseId));
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return false;
    }

    @Override
    public Boolean getSurveyPublishStatus(int courseId) {
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        try {
            procedure = new CallStoredProcedure("spGetSurveyPublishStatus(?)");
            procedure.setParameter(1, courseId);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                if (resultSet.getBoolean(1)) {
                    return true;
                }
            }
            LOGGER.info("Survey successfully published for CourseID: " + courseId);
        } catch (Exception e) {
            LOGGER.error("Exception occurred while getting survey publish status. ", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return false;
    }
}
