package com.group8.dalsmartteamwork.createsurvey.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.questions.Question;
import com.group8.dalsmartteamwork.course.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateSurveyDaoImpl implements ICreateSurveyDao {
    public int published;

    @Override
    public List<Course> displayListOfCourses(String BannerID) {
        List<Course> listOfCourses = new ArrayList<>();
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        try {
            procedure = new CallStoredProcedure("spListAllCourses(?)");
            procedure.setParameter(1, BannerID);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                int ID = resultSet.getInt(1);
                listOfCourses.add(new Course(ID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return listOfCourses;
    }

    @Override
    public boolean checkIfSurveyCreated(int courseID) {
        ResultSet resultSet;
        CallStoredProcedure procedure = null;
        try {
            procedure = new CallStoredProcedure("spGetStatus(?)");
            procedure.setParameter(1, courseID);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                published = resultSet.getInt(1);
                if (published > 0) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return true;
    }

    @Override
    public List<Question> displayQuestions(String BannerID, int courseID) {
        List<Question> listOfQuestions = new ArrayList<>();
        CallStoredProcedure procedure = null;
        ResultSet resultSet;
        try {
            procedure = new CallStoredProcedure("spDisplayQuestions(?,?)");

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

    @Override
    public boolean saveQuestions(int courseID, List<Integer> questionID) {

        CallStoredProcedure procedure = null;
        try {
            procedure = new CallStoredProcedure("spDeleteQuestions(?)");
            procedure.setParameter(1, courseID);
            procedure.execute();
            procedure = new CallStoredProcedure("spInsertQuestions(?, ?)");
            for (int i = 0; i < questionID.size(); i++) {
                procedure.setParameter(1, courseID);
                procedure.setParameter(2, questionID.get(i));
                procedure.execute();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }

    }

    @Override
    public boolean publishSurvey(int courseID) {
        CallStoredProcedure procedure = null;
        int surveyStatus = published + 1;
        ResultSet resultSet;
        try {
            procedure = new CallStoredProcedure("spCheckIfQuestionsExist(?)");
            procedure.setParameter(1, courseID);
            resultSet = procedure.executeWithResults();
            while (resultSet.next()) {
                int count = resultSet.getInt(1);
                if (count == 0) {
                    return false;
                }
            }
            procedure = new CallStoredProcedure("spUpdateSurveyStatus(?,?)");
            procedure.setParameter(1, courseID);
            procedure.setParameter(2, surveyStatus);
            procedure.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }

    }

}