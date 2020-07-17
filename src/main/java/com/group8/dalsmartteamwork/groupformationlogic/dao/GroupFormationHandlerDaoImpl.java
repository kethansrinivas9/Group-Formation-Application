package com.group8.dalsmartteamwork.groupformationlogic.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import com.group8.dalsmartteamwork.groupformationlogic.models.GroupFormationRules;
import com.group8.dalsmartteamwork.groupformationlogic.models.IGroupFormationRules;
import com.group8.dalsmartteamwork.groupformationlogic.models.StudentResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupFormationHandlerDaoImpl implements IGroupFormationHandlerDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public void saveRules(IGroupFormationRules iGroupFormationRules) {
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spSaveGroupFormationRules(?, ?, ?, ?, ?, ?, ?)");
            proc.setParameter(1, "5410");
            proc.setParameter(2, iGroupFormationRules.getGroupSize());
            proc.setParameter(3, iGroupFormationRules.getMultipleChoiceSingleOptionRule());
            proc.setParameter(4, iGroupFormationRules.getMultipleChoiceMultipleOptionRule());
            proc.setParameter(5, iGroupFormationRules.getNumericRule());
            proc.setParameter(6, iGroupFormationRules.getNumericValue());
            proc.setParameter(7, iGroupFormationRules.getFreeTextRule());
            proc.execute();
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while saving Group Formation Rules to database.", e);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
    }

    @Override
    public IGroupFormationRules getRules(int courseID) {
        IGroupFormationRules iGroupFormationRules = new GroupFormationRules();
        CallStoredProcedure proc = null;
        ResultSet resultSet = null;
        try {
            proc = new CallStoredProcedure("spGetGroupFormationRules(?)");
            proc.setParameter(1, courseID);
            resultSet = proc.executeWithResults();
            if (resultSet.next()) {
                int groupSize = Integer.parseInt(resultSet.getString("GroupSize"));
                int numericValue = Integer.parseInt(resultSet.getString("NumericValue"));
                String multipleChoiceSingleOptionRule = resultSet.getString("MultipleChoiceSingleOptionRule");
                String multipleChoiceMultipleOptionRule = resultSet.getString("MultipleChoiceMultipleOptionRule");
                String numericRule = resultSet.getString("NumericRule");
                String freeTextRule = resultSet.getString("FreeTextRule");

                iGroupFormationRules.setGroupSize(groupSize);
                iGroupFormationRules.setMultipleChoiceSingleOptionRule(multipleChoiceSingleOptionRule);
                iGroupFormationRules.setMultipleChoiceMultipleOptionRule(multipleChoiceMultipleOptionRule);
                iGroupFormationRules.setNumericRule(numericRule);
                iGroupFormationRules.setNumericValue(numericValue);
                iGroupFormationRules.setFreeTextRule(freeTextRule);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while retrieving Group Formation Rules from the database.", e);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return iGroupFormationRules;
    }

    @Override
    public List<StudentResponses> getStudentsSurveyResponses() {
        List<StudentResponses> studentResponsesList = new ArrayList<StudentResponses>();

        CallStoredProcedure proc = null;
        ResultSet resultSet = null;
        try {
            proc = new CallStoredProcedure("spGetAnswers(?)");
            proc.setParameter(1, "5410");
            resultSet = proc.executeWithResults();

            StudentResponses studentResponses = new StudentResponses();
            studentResponses.setBannerID(null);
            while (resultSet.next()) {
                int questionID = resultSet.getInt(2);
                String answer = resultSet.getString(3);
                String bannerID = resultSet.getString(4);
                if (studentResponses.getBannerID() == null) {
                    studentResponses.setBannerID(bannerID);
                }

                if (studentResponses.getBannerID().equals(bannerID) == false) {
                    studentResponsesList.add(studentResponses);
                    studentResponses = new StudentResponses();
                    studentResponses.setBannerID(bannerID);
                }
                studentResponses.addAnswer(questionID, answer);
            }
            if (studentResponses.getBannerID() != null) {
                studentResponsesList.add(studentResponses);
            }
            LOGGER.info("Retrieved the Group Formation Rules from the database successfully.");
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while retrieving Group Formation Rules from the database.", e);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return studentResponsesList;
    }

    @Override
    public int getQuestionTypeID(int questionID) {
        CallStoredProcedure proc = null;
        ResultSet resultSet;
        int questionType = -1;
        try {
            proc = new CallStoredProcedure("spGetQuestionTypeID(?)");
            proc.setParameter(1, questionID);
            resultSet = proc.executeWithResults();
            if (resultSet.next()) {
                questionType = Integer.parseInt(resultSet.getString("TypeID"));
            }
            LOGGER.error("Retrieved Question Type IDs from the database successfully.");
        } catch (SQLException e) {
            LOGGER.error("Exception occurred while retrieving Question Type IDs from the database.", e);
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return questionType;
    }

}
