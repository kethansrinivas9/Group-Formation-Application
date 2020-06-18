package com.group8.dalsmartteamwork.courseadmin.dao;

import com.group8.dalsmartteamwork.utils.CallStoredProcedure;

public class StudentEnrollmentDaoImpl implements IStudentEnrollmentDao{
    @Override
    public Boolean assignCourseToUser(String userId, int courseId) {
        CallStoredProcedure procedure = null;
        try {
            procedure = new CallStoredProcedure("spEnrollStudentToCourse(?, ?)");
            procedure.setParameter(1, userId);
            procedure.setParameter(2, courseId);
            procedure.execute();
            return true;
        } catch (Exception e) {
            //TODO: Add to Log
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        return false;
    }
}
