package com.group8.dalsmartteamwork.accesscontrol;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CurrentUserTest {
    private static final String BannerId = "B00123456";
    private static final Set<String> rolesList = new HashSet<String>();

    @BeforeAll
    public static void initializeValuesForTests() {
        rolesList.add("TA");
        rolesList.add("Guest");
    }

    @Test
    public void getInstanceTest() {
        CurrentUser currentUser = CurrentUser.getInstance();
        Assert.notNull(currentUser, "Object is null");
    }

    @Test
    public void checkIfInstanceIsSingletonTest() {
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setBannerId(BannerId);

        CurrentUser currentUserDuplicateInstance = CurrentUser.getInstance();
        assertEquals(currentUserDuplicateInstance.getBannerId(), BannerId);
    }

    @Test
    public void getBannerIdTest() {
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setBannerId(BannerId);

        assertEquals(currentUser.getBannerId(), BannerId);
    }

    @Test
    public void setBannerIdTest() {
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setBannerId(BannerId);

        assertEquals(currentUser.getBannerId(), BannerId);
    }

    @Test
    public void setRolesListTest() {
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setRoles(rolesList);

        assertEquals(currentUser.getRoles(), rolesList);
    }

    @Test
    public void getRolesListTest() {
        CurrentUser currentUser = CurrentUser.getInstance();
        currentUser.setRoles(rolesList);

        assertEquals(currentUser.getRoles(), rolesList);
    }
}
