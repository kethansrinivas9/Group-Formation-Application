package com.group8.dalsmartteamwork.questionmanager.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.questions.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeleteDaoImpl implements DeleteDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Question> displayListOfQuestions(String BannerID) {
        List<Question> listOfQuestions = new ArrayList<>();
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        try {
            procedure = new CallStoredProcedure("spListAllQuestions(?)");
            procedure.setParameter(1, BannerID);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                int ID = resultSet.getInt(1);
                String questionText = resultSet.getString(2);
                listOfQuestions.add(new Question(ID, questionText));
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred while getting all questions from the database. ", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        LOGGER.info("List of questions retrieved from the database");
        return listOfQuestions;
    }

    @Override
    public boolean deleteQuestion(int questionID) {
        CallStoredProcedure procedure = null;
        try {
            procedure = new CallStoredProcedure("spDeleteQuestion(?)");
            procedure.setParameter(1, questionID);
            procedure.execute();
        } catch (Exception e) {
            LOGGER.error("Exception occurred while deleting question from the database. ", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        LOGGER.info("Question deleted. QuestionID: " + questionID);
        return true;
    }

}