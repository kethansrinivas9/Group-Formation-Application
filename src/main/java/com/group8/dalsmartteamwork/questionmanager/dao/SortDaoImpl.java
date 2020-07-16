package com.group8.dalsmartteamwork.questionmanager.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.questions.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SortDaoImpl implements SortDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

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
            LOGGER.error("Exception occurred while getting all questions from the database. ", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        LOGGER.info("List of all questions was retrieved from the database");
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
            LOGGER.error("Exception occurred while getting all questions by Title from the database. ", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        LOGGER.info("List of questions sorted by title was retrieved from the database");
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
            LOGGER.error("Exception occurred while getting all questions by Date from the database. ", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        LOGGER.info("List of questions sorted by date was retrieved from the database");
        return sortedListBydate;
    }
}