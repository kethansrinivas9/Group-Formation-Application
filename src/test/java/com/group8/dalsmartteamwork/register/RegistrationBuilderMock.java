package com.group8.dalsmartteamwork.register;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.login.model.Encryption;
import com.group8.dalsmartteamwork.login.model.IEncryption;
import com.group8.dalsmartteamwork.register.dao.IRegistrationDao;
import com.group8.dalsmartteamwork.register.dao.RegistrationDaoImpl;
import com.group8.dalsmartteamwork.register.models.IRegistrationBuilder;
import com.group8.dalsmartteamwork.resetpassword.models.IMail;

import static org.mockito.Mockito.*;

public class RegistrationBuilderMock implements IRegistrationBuilder {
    private User existingUser;
    private User newUserSuccess;
    private User newUserFail;

    public RegistrationBuilderMock(User existingUser, User newUserSuccess, User newUserFail){
        this.existingUser = existingUser;
        this.newUserSuccess = newUserSuccess;
        this.newUserFail = newUserFail;
    }

    @Override
    public IRegistrationDao getRegistrationDaoObject() {
        IRegistrationDao iRegistrationDao = mock(RegistrationDaoImpl.class);
        when(iRegistrationDao.addGuestRoleToUser(newUserSuccess.getId())).thenReturn(true);
        when(iRegistrationDao.addUserToDb(existingUser)).thenReturn(false);
        when(iRegistrationDao.addUserToDb(newUserFail)).thenReturn(true);
        when(iRegistrationDao.addGuestRoleToUser(newUserFail.getId())).thenReturn(false);
        when(iRegistrationDao.addUserToDb(newUserSuccess)).thenReturn(true);
        return iRegistrationDao;
    }

    @Override
    public IMail getMailObject() {
        return null;
    }

    @Override
    public IEncryption getEncryptionObject() {
        IEncryption iEncryption = mock(Encryption.class);
        when(iEncryption.encrypt(anyString())).thenReturn("TEST");
        when(iEncryption.decrypt(anyString())).thenReturn("TEST");
        return iEncryption;
    }
}

