package com.group8.dalsmartteamwork.login.model;

public abstract class LoginModelAbstractFactory {
    public abstract IEncryption encryption();

    public abstract ILogin login();

    public abstract IRole role();

    public abstract LoginAuthentication loginAuthentication();

    public abstract RoleAuthorization roleAuthorization();

    public abstract Successhandler successhandler();

    public abstract WebConfig webConfig();
}
