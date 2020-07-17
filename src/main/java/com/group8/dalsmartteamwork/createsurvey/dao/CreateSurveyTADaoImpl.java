package com.group8.dalsmartteamwork.createsurvey.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.questions.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CreateSurveyTADaoImpl implements CreateSurveyTADao {
    final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Question> displayQuestionsTA(String bannerID, int courseID) {
        List<Question> listOfQuestions = new ArrayList<>();
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        try {
            procedure = new CallStoredProcedure("spDisplayQuestionsToTA(?,?)");

            procedure.setParameter(1, courseID);
            procedure.setParameter(2, bannerID);
            resultSet = procedure.executeWithResults();

            while (resultSet.next()) {
                int ID = resultSet.getInt(1);
                String questionText = resultSet.getString(2);
                listOfQuestions.add(new Question(ID, questionText));
            }
        } catch (Exception e) {
            LOGGER.error(String.format("Exception occurred while getting for TA with BannerID: %s in CourseID: %s", bannerID, courseID), e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return listOfQuestions;
    }
}