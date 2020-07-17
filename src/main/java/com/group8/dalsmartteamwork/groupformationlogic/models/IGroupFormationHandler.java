package com.group8.dalsmartteamwork.groupformationlogic.models;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IGroupFormationHandler {

    void saveRules(HttpServletRequest request);

    IGroupFormationRules getRules(int courseID);

    List<StudentResponses> getStudentsSurveyResponses();
}
