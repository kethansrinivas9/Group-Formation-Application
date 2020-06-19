package com.group8.dalsmartteamwork.questionmanager.dao;

import com.group8.dalsmartteamwork.questions.Question;
import com.group8.dalsmartteamwork.utils.CallStoredProcedure;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SortDaoImp implements SortDao {

    @Override
    public List<Question> getAllQuestion(String BannerID) {
        List<Question> sortedList = new ArrayList<>();
        CallStoredProcedure procedure = null;
        ResultSet resultSet;

        try {

            procedure = new CallStoredProcedure("spGetAllQuestions(?)");
            procedure.setParameter(1, BannerID);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                String title = resultSet.getString(1);
                sortedList.add(new Question(title));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return sortedList;
    }

    @Override
    public List<Question> sortQuestionsByTitle(String BannerID) {
        List<Question> sortedListByTitle = new ArrayList<>();
        CallStoredProcedure procedure = null;
        ResultSet resultSet;

        try {
            procedure = new CallStoredProcedure("spGetAllQuestionsByTitle(?)");
            procedure.setParameter(1, BannerID);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                String title = resultSet.getString(1);
                sortedListByTitle.add(new Question(title));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return sortedListByTitle;
    }

    @Override
    public List<Question> sortAllQuestionByDate(String BannerID) {
        List<Question> sortedListBydate = new ArrayList<>();
        CallStoredProcedure procedure = null;
        ResultSet resultSet;

        try {
            procedure = new CallStoredProcedure("spGetAllQuestionsByDate(?)");
            procedure.setParameter(1, BannerID);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                String title = resultSet.getString(1);
                sortedListBydate.add(new Question(title));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return sortedListBydate;
    }
}