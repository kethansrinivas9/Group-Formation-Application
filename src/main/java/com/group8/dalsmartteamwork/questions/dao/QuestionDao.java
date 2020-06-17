package com.group8.dalsmartteamwork.questions.dao;

import com.group8.dalsmartteamwork.questions.Option;
import com.group8.dalsmartteamwork.questions.Question;
import com.group8.dalsmartteamwork.utils.CallStoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDao implements IQuestionDao {

    @Override
    public int addQuestionToDb(Question question, int questionType, String bannerId) {
        CallStoredProcedure proc = null;
        ResultSet resultSet;
        int questionId = -1;
        try
        {
            proc = new CallStoredProcedure("spCreateQuestion(?, ?, ?, ?)");
            proc.setParameter(1, question.getTitle());
            proc.setParameter(2, questionType);
            proc.setParameter(3, question.getText());
            proc.setParameter(4, "B456");
            resultSet = proc.executeWithResults();
            while(resultSet.next()){
                questionId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
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
            return true;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        finally{
            if (null != proc) {
                proc.cleanup();
            }
        }
    }
}
