package com.group8.dalsmartteamwork.courseadmin.dao;

import com.group8.dalsmartteamwork.database.CallStoredProcedure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentEnrollmentDaoImpl implements IStudentEnrollmentDao {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public Boolean assignCourseToUser(String userId, int courseId) {
        CallStoredProcedure procedure = null;
        try {
            procedure = new CallStoredProcedure("spEnrollStudentToCourse(?, ?)");
            procedure.setParameter(1, userId);
            procedure.setParameter(2, courseId);
            procedure.execute();
            LOGGER.info(String.format("Course assigned. BannerID: %s, CourseID: %s", userId, courseId));
            return true;
        } catch (Exception e) {
            LOGGER.error("Exception occurred while assigning course to user.", e);
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }
        LOGGER.warn(String.format("Failed to assign course. BannerID: %s, CourseID: %s", userId, courseId));
        return false;
    }
}
