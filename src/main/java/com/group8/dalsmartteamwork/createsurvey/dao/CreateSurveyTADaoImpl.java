package com.group8.dalsmartteamwork.createsurvey.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.questions.Question;

public class CreateSurveyTADaoImpl implements ICreateSurveyTADao {
    
    @Override
    public List<Question> displayQuestionsTA(String BannerID,int courseID) {
        List<Question> listOfQuestions = new ArrayList<>();
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        try {
            procedure = new CallStoredProcedure("spDisplayQuestionsToTA(?,?)");
            procedure.setParameter(1, courseID);
            procedure.setParameter(2, BannerID);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                int ID = resultSet.getInt(1);
                String questionText = resultSet.getString(2);
                listOfQuestions.add(new Question(ID, questionText));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return listOfQuestions;
    }
}