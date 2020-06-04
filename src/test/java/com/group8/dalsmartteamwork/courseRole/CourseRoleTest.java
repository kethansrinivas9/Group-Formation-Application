package com.group8.dalsmartteamwork.courseRole;

import com.group8.dalsmartteamwork.CourseRole.models.CourseRole;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CourseRoleTest {
    private static final String TEMP_BANNERID = "B00000000";
    private static final int TEMP_COURSEID = 1111;
    private static final int TEMP_ROLEID = 2;

    @Test
    public void defaultConstructorTest(){
        CourseRole courseRole = new CourseRole();
        assertEquals(courseRole.getCourseID(), 0, "Default constructor of PasswordResetToken failed");
        assertNull(courseRole.getBannerID(), "Default constructor of PasswordResetToken failed");
        assertEquals(courseRole.getCourseID(), 0, "Default constructor of PasswordResetToken failed");
    }

    @Test
    public void constructorWithThreeArgumentsTest(){
        CourseRole courseRole = new CourseRole(TEMP_BANNERID, TEMP_COURSEID, TEMP_ROLEID);
        assertEquals(courseRole.getCourseID(), TEMP_COURSEID, "Constructor failed");
        assertEquals(courseRole.getRoleID(), TEMP_ROLEID, "Constructor failed");
        assertEquals(courseRole.getBannerID(), TEMP_BANNERID, "Constructor failed");
    }

    @Test
    public void getBannerIDTest(){
        CourseRole courseRole = new CourseRole(TEMP_BANNERID, TEMP_COURSEID, TEMP_ROLEID);
        assertEquals(courseRole.getBannerID(), TEMP_BANNERID, "Failed to get BannerID");
    }

    @Test
    public void setBannerIDTest(){
        CourseRole courseRole = new CourseRole();
        courseRole.setBannerID(TEMP_BANNERID);
        assertEquals(courseRole.getBannerID(), TEMP_BANNERID, "Failed to set BannerID");
    }

    @Test
    public void getCourseIDTest(){
        CourseRole courseRole = new CourseRole(TEMP_BANNERID, TEMP_COURSEID, TEMP_ROLEID);
        assertEquals(courseRole.getCourseID(), TEMP_COURSEID, "Failed to get CourseID");
    }

    @Test
    public void setCourseIDTest(){
        CourseRole courseRole = new CourseRole();
        courseRole.setCourseID(TEMP_COURSEID);
        assertEquals(courseRole.getCourseID(), TEMP_COURSEID, "Failed to set CourseID");
    }

    @Test
    public void getRoleIDTest(){
        CourseRole courseRole = new CourseRole(TEMP_BANNERID, TEMP_COURSEID, TEMP_ROLEID);
        assertEquals(courseRole.getRoleID(), TEMP_ROLEID, "Failed to get RoleID");
    }

    @Test
    public void setRoleIDTest(){
        CourseRole courseRole = new CourseRole();
        courseRole.setRoleID(TEMP_ROLEID);
        assertEquals(courseRole.getRoleID(), TEMP_ROLEID, "Failed to set RoleID");
    }
}
