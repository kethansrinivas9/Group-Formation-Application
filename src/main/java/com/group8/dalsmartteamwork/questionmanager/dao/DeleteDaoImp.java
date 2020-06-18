package com.group8.dalsmartteamwork.questionmanager.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.group8.dalsmartteamwork.questions.Question;
import com.group8.dalsmartteamwork.utils.CallStoredProcedure;

public class DeleteDaoImp implements DeleteDao{

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
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
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
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return true;
    }

}