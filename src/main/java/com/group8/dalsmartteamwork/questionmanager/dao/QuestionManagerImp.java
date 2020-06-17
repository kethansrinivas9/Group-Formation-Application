package com.group8.dalsmartteamwork.questionmanager.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.group8.dalsmartteamwork.questionmanager.model.Question;
import com.group8.dalsmartteamwork.utils.DbConnection;

public class QuestionManagerImp implements QuestionManagerDao {
    DbConnection connection;

    @Override
    public List<Question> getAllQuestion(String BannerID) {
        List<Question> sortedList = new ArrayList<>();
        try {

            connection = DbConnection.getInstance();
            connection.createDbConnection();
            final String query = String.format("Select Title from Question where BannerID = '%s' ", BannerID);
            ResultSet resultSet = connection.getRecords(query);
            while (resultSet.next()) {
                String title = resultSet.getString("Title");
                sortedList.add(new Question(title));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return sortedList;
    }

    @Override
    public List<Question> sortQuestionsByTitle(String BannerID) {
        List<Question> sortedListByTitle = new ArrayList<>();
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            final String query = String.format("Select Title from Question where BannerID = '%s' ORDER BY Title ",
                    BannerID);
            ResultSet resultSet = connection.getRecords(query);
            while (resultSet.next())
                ;
            {
                String title = resultSet.getString("Title");
                sortedListByTitle.add(new Question(title));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return sortedListByTitle;
    }

    @Override
    public List<Question> sortAllQuestionByDate(String BannerID) {
        List<Question> sortedListBydate = new ArrayList<>();
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            final String query = String.format("Select Title from Question where BannerID = '%s' ORDER BY DateCreated ",
                    BannerID);
            ResultSet resultSet = connection.getRecords(query);
            while (resultSet.next()) {
                String title = resultSet.getString("Title");
                sortedListBydate.add(new Question(title));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return sortedListBydate;
    }

    @Override
    public boolean deleteQuestion(String BannerID, int questionID) {
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            final String query = String.format("Delete from Question where QuestionID='%d' ", questionID);
            int x = connection.deleteRecords(query);
            if (x == 0) {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return true;
    }

    @Override
    public List<Question> displayListOfQuestions(String BannerID) {
        List<Question> listOfQuestions = new ArrayList<>();
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            final String query = String.format("Select QuestionID, QuestionText from Question where BannerID = '%s' ",
                    BannerID);
            ResultSet resultSet = connection.getRecords(query);
            while (resultSet.next()) {
                int ID = resultSet.getInt("QuestionID");
                String questionText = resultSet.getString("QuestionText");
                listOfQuestions.add(new Question(ID, questionText));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return listOfQuestions;
    }

}