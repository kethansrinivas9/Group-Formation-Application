package com.group8.dalsmartteamwork.groups;

import com.group8.dalsmartteamwork.groups.dao.GroupRetrieverDaoImpl;
import com.group8.dalsmartteamwork.groups.dao.IGroupRetrieverDao;
import com.group8.dalsmartteamwork.groups.models.GroupDisplayManagerImpl;
import com.group8.dalsmartteamwork.groups.models.IGroupDisplayManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GroupDisplayManagerImplTest {
    private IGroupRetrieverDao iGroupRetrieverDao;
    private IGroupDisplayManager iGroupDisplayManager;

    @BeforeEach
    void setup() {
        iGroupRetrieverDao = mock(GroupRetrieverDaoImpl.class);
        iGroupDisplayManager = new GroupDisplayManagerImpl(iGroupRetrieverDao);
    }

    @Test
    void getGroupsTest() {
        when(iGroupRetrieverDao.getGroups(0)).thenReturn(null);
        assertNull(iGroupDisplayManager.getGroups(0));
    }

    @Test
    void getInstructorCoursesTest() {
        when(iGroupRetrieverDao.getCourses("TEST")).thenReturn(null);
        assertNull(iGroupDisplayManager.getInstructorCourses("TEST"));
    }
}
