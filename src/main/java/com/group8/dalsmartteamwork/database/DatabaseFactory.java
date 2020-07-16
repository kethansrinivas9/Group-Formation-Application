package com.group8.dalsmartteamwork.database;

import com.group8.dalsmartteamwork.login.model.*;

public class DatabaseFactory extends DatabaseAbstractFactory{
    private static DatabaseFactory instance = null;
    private CallStoredProcedure callStoredProcedure;

    DatabaseFactory() {
    }

    public static DatabaseFactory instance() {
        if (null == instance) {
            instance = new DatabaseFactory();
        }
        return instance;
    }

    @Override
    public CallStoredProcedure callStoredProcedure(String procedure) {
        if (null == callStoredProcedure) {
            callStoredProcedure = new CallStoredProcedure(procedure);
        }
        return callStoredProcedure;
    }
}
