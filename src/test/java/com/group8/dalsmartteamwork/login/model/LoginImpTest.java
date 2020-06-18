package com.group8.dalsmartteamwork.login.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import com.group8.dalsmartteamwork.login.dao.LoginDao;
import com.group8.dalsmartteamwork.login.dao.LoginDaoImplementation;

public class LoginImpTest {

    private Login login = null;
    private final LoginDao loginDao = mock(LoginDaoImplementation.class);
    private final String BannerID = "B00123456";
    private final String FIRSTNAME = "TEST_user";
    private final String EMAIL = "TEST@gmail.com";
    private final String PASSWORD = "TEST@12345";

    @BeforeEach
    public void setup() {
        login = new LoginImplementation(loginDao);
    }

    @Test
    public void getUserDetailsTest() {
        when(loginDao.getUserDetails(BannerID,FIRSTNAME,EMAIL,PASSWORD)).thenReturn(true);
        assertTrue(login.getUserDetails(BannerID,FIRSTNAME,EMAIL,PASSWORD));
        verify(loginDao).getUserDetails(BannerID,FIRSTNAME,EMAIL,PASSWORD);
    }

}