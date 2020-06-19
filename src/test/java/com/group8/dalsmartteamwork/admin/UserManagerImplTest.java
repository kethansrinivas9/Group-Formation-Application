package com.group8.dalsmartteamwork.admin;

import com.group8.dalsmartteamwork.admin.dao.IUserManagerDao;
import com.group8.dalsmartteamwork.admin.dao.UserManagerDaoImpl;
import com.group8.dalsmartteamwork.admin.models.IUserManager;
import com.group8.dalsmartteamwork.admin.models.UserManagerImpl;
import com.group8.dalsmartteamwork.course.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserManagerImplTest {
    private final IUserManagerDao userManagerDao = mock(UserManagerDaoImpl.class);
    private final List<String> nonAdminUsers = Arrays.asList("SAMPLE_USER_ONE", "SAMPLE_USER_TWO");
    private final List<String> guestUsersOrInstructors = Arrays.asList("SAMPLE_USER_ONE", "SAMPLE_USER_TWO");
    private final Course courseOne = new Course(123, "SAMPLE_COURSE_NAME", "Instructor123");
    private final String instructorID = "B00123456";
    private IUserManager iUserManager = null;

    @BeforeEach
    public void setup() {
        iUserManager = new UserManagerImpl(userManagerDao);
    }

    @Test
    public void getListOfNonAdminUsersTest() {
        when(userManagerDao.getListOfNonAdminUsers()).thenReturn(nonAdminUsers);
        assertEquals(iUserManager.getListOfNonAdminUsers(), nonAdminUsers);
    }

    @Test
    public void getCourseInstructorTest() {
        when(userManagerDao.getCourseInstructor(String.valueOf(courseOne.getCourseID()))).thenReturn(instructorID);
        assertEquals(iUserManager.getCourseInstructor(String.valueOf(courseOne.getCourseID())), instructorID);
    }

    @Test
    public void getUsersWhoAreGuestsOrInstructorsTest() {
        when(userManagerDao.getUsersWhoAreGuestsOrInstructors(String.valueOf(courseOne.getCourseID()))).thenReturn(guestUsersOrInstructors);
        assertEquals(iUserManager.getUsersWhoAreGuestsOrInstructors(String.valueOf(courseOne.getCourseID())), guestUsersOrInstructors);
    }
}
