package com.group8.dalsmartteamwork.login.model;

import com.group8.dalsmartteamwork.accesscontrol.AccessControlFactory;
import com.group8.dalsmartteamwork.login.dao.LoginDaoFactory;

public class LoginModelFactory extends LoginModelAbstractFactory {
    private static LoginModelFactory instance = null;
    private IEncryption encryption;
    private ILogin login;
    private IRole role;
    private LoginAuthentication loginAuthentication;
    private RoleAuthorization roleAuthorization;
    private Successhandler successhandler;
    private WebConfig webConfig;

    LoginModelFactory() {
    }

    public static LoginModelFactory instance() {
        if (null == instance) {
            instance = new LoginModelFactory();
        }
        return instance;
    }

    @Override
    public IEncryption encryption() {
        if (null == encryption) {
            encryption = new Encryption();
        }
        return encryption;
    }

    @Override
    public ILogin login() {
        if (null == login) {
            login = new LoginImpl(LoginDaoFactory.instance().loginDao());
        }
        return login;
    }

    @Override
    public IRole role() {
        if (null == role) {
            role = new Role();
        }
        return role;
    }

    @Override
    public LoginAuthentication loginAuthentication() {
        if (null == loginAuthentication) {
            loginAuthentication = new LoginAuthentication();
        }
        return loginAuthentication;
    }

    @Override
    public RoleAuthorization roleAuthorization() {
        if (null == roleAuthorization) {
            roleAuthorization = new RoleAuthorization(AccessControlFactory.instance().user());
        }
        return roleAuthorization;
    }

    @Override
    public Successhandler successhandler() {
        if (null == successhandler) {
            successhandler = new Successhandler();
        }
        return successhandler;
    }

    @Override
    public WebConfig webConfig() {
        if (null == webConfig) {
            webConfig = new WebConfig();
        }
        return webConfig;
    }
}
