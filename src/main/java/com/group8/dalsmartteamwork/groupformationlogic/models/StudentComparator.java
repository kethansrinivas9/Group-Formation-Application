package com.group8.dalsmartteamwork.groupformationlogic.models;

import com.group8.dalsmartteamwork.groupformationlogic.dao.GroupFormationHandlerDaoImpl;
import com.group8.dalsmartteamwork.groupformationlogic.dao.IGroupFormationHandlerDao;

public class StudentComparator implements IStudentComparator {
    @Override
    public int getDistanceBetweenStudents(IStudentResponses student1, IStudentResponses student2) {
        int distance = 0;
        int index = 0;
        int courseID = 5409;
        IGroupFormationHandlerDao iGroupFormationHandlerDao = new GroupFormationHandlerDaoImpl();
        IGroupFormationHandler iGroupFormationHandler = new GroupFormationHandler(iGroupFormationHandlerDao);
        IGroupFormationRules iGroupFormationRules = iGroupFormationHandler.getRules(courseID);
        IComparatorFactory iComparatorFactory = new ComparatorFactory();

        for (Integer questionID : student1.getResponses().keySet()) {
            int typeID = iGroupFormationHandlerDao.getQuestionTypeID(questionID);
            IComparator comparator = iComparatorFactory.getComparator(typeID);

            distance += comparator.compare(student1.getResponses().get(questionID), student2.getResponses().get(questionID), iGroupFormationRules);
        }

        return distance;
    }
}
