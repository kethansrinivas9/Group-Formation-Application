package com.group8.dalsmartteamwork.groupformationlogic.models;

import com.group8.dalsmartteamwork.groupformationlogic.dao.IGroupFormationHandlerDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GroupFormationHandler implements IGroupFormationHandler {
    private final IGroupFormationHandlerDao iGroupFormationHandlerDao;

    public GroupFormationHandler(IGroupFormationHandlerDao iGroupFormationHandlerDao) {
        this.iGroupFormationHandlerDao = iGroupFormationHandlerDao;
    }

    @Override
    public void saveRules(HttpServletRequest request) {
        IGroupFormationRules groupFormationRules = new GroupFormationRules();

        String multipleChoiceSingleOptionRule = request.getParameter("MultipleChoiceSingle");
        String multipleChoiceMultipleOptionRule = request.getParameter("MultipleChoiceMultiple");
        String groupSize = request.getParameter("groupSize");
        String numericRule = request.getParameter("Numeric");
        String freeTextRule = request.getParameter("FreeText");

        groupFormationRules.setGroupSize(Integer.parseInt(groupSize));
        groupFormationRules.setNumericRule(numericRule);
        groupFormationRules.setFreeTextRule(freeTextRule);
        groupFormationRules.setMultipleChoiceSingleOptionRule(multipleChoiceSingleOptionRule);
        groupFormationRules.setMultipleChoiceMultipleOptionRule(multipleChoiceMultipleOptionRule);


        if (numericRule.equalsIgnoreCase("oneGreaterThanX") || numericRule.equalsIgnoreCase("oneLessThanX")) {
            String xValue = request.getParameter("xValue");
            groupFormationRules.setNumericValue(Integer.parseInt(xValue));
        }

        iGroupFormationHandlerDao.saveRules(groupFormationRules);
    }

    @Override
    public IGroupFormationRules getRules(int courseID) {
        return iGroupFormationHandlerDao.getRules(courseID);
    }

    @Override
    public List<StudentResponses> getStudentsSurveyResponses() {
        return iGroupFormationHandlerDao.getStudentsSurveyResponses();
    }
}
