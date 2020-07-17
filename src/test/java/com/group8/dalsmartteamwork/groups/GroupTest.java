package com.group8.dalsmartteamwork.groups;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupTest {

    @Test
    void getGroupIdTest() {
        IGroup iGroup = new Group();
        iGroup.setGroupId(1);
        assertEquals(1, iGroup.getGroupId());
    }

    @Test
    void setGroupIdTest() {
        IGroup iGroup = new Group();
        iGroup.setGroupId(0);
        assertEquals(0, iGroup.getGroupId());
    }

    @Test
    void getBannerIdTest() {
        IGroup iGroup = new Group();
        iGroup.setBannerId("TEST");
        assertEquals("TEST", iGroup.getBannerId());
    }

    @Test
    void setBannerIdTest() {
        IGroup iGroup = new Group();
        iGroup.setBannerId("TEST");
        assertEquals("TEST", iGroup.getBannerId());
    }

    @Test
    void getFirstNameTest() {
        IGroup iGroup = new Group();
        iGroup.setFirstName("TEST");
        assertEquals("TEST", iGroup.getFirstName());
    }

    @Test
    void setFirstNameTest() {
        IGroup iGroup = new Group();
        iGroup.setFirstName("TEST");
        assertEquals("TEST", iGroup.getFirstName());
    }

    @Test
    void getLastNameTest() {
        IGroup iGroup = new Group();
        iGroup.setLastName("TEST");
        assertEquals("TEST", iGroup.getLastName());
    }

    @Test
    void setLastNameTest() {
        IGroup iGroup = new Group();
        iGroup.setLastName("TEST");
        assertEquals("TEST", iGroup.getLastName());
    }
}
