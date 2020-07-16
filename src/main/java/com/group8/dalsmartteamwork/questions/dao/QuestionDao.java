package com.group8.dalsmartteamwork.questions.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.questions.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDao implements IQuestionDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public int addQuestionToDb(Question question, int questionType, String bannerId) {
        CallStoredProcedure proc = null;
        ResultSet resultSet;
        int questionId = -1;
        try {
            proc = new CallStoredProcedure("spCreateQuestion(?, ?, ?, ?)");
            proc.setParameter(1, question.getTitle());
            proc.setParameter(2, questionType);
            proc.setParameter(3, question.getText());
            proc.setParameter(4, bannerId);
            resultSet = proc.executeWithResults();
            while (resultSet.next()) {
                questionId = resultSet.getInt(1);
            }
            LOGGER.info("Question added to the database. QuestionID: " + questionId);
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while adding question to the database. ", e);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        LOGGER.info("Question added. QuestionID: " + questionId);
        return questionId;
    }

    public Boolean addOptionToDb(Option option, int questionId) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spInsertOptions(?, ?, ?)");
            proc.setParameter(1, questionId);
            proc.setParameter(2, option.getDisplayText());
            proc.setParameter(3, option.getStoredAs());
            proc.execute();
            LOGGER.info("Option added. QuestionID: " + questionId + " OptionID: " + option.getOptionId());
            return true;
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while adding question to the database. ", e);
            return false;
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
    }
}
