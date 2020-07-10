package com.group8.dalsmartteamwork.login;

import com.group8.dalsmartteamwork.login.dao.ILoginDao;
import com.group8.dalsmartteamwork.login.dao.LoginDaoImpl;
import com.group8.dalsmartteamwork.login.model.ILogin;
import com.group8.dalsmartteamwork.login.model.LoginImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class LoginImplTest {

    private final ILoginDao loginDao = mock(LoginDaoImpl.class);
    private final String BannerID = "B00123456";
    private final String FIRSTNAME = "TEST_user";
    private final String EMAIL = "TEST@gmail.com";
    private final String PASSWORD = "TEST@12345";
    private ILogin login = null;

    @BeforeEach
    public void setup() {
        login = new LoginImpl(loginDao);
    }

    @Test
    public void getUserDetailsTest() {
        when(loginDao.getUserDetails(BannerID, FIRSTNAME, EMAIL, PASSWORD)).thenReturn(true);
        assertTrue(login.getUserDetails(BannerID, FIRSTNAME, EMAIL, PASSWORD));
        verify(loginDao).getUserDetails(BannerID, FIRSTNAME, EMAIL, PASSWORD);
    }

}