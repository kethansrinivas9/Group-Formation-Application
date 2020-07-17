package com.group8.dalsmartteamwork.groupformationlogic.dao;

import com.group8.dalsmartteamwork.groupformationlogic.models.IGroupFormationRules;
import com.group8.dalsmartteamwork.groupformationlogic.models.StudentResponses;

import java.util.List;

public interface IGroupFormationHandlerDao {
    void saveRules(IGroupFormationRules iGroupFormationRules);

    IGroupFormationRules getRules(int courseID);

    List<StudentResponses> getStudentsSurveyResponses();

    int getQuestionTypeID(int questionID);
}
