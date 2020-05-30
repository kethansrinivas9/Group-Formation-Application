package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.group8.dalsmartteamwork.utils.DbConnection;

import org.junit.jupiter.api.Test;

public class DbConnectionTest {

    @Test
    public void defaultConstructorTest() {
        DbConnection connection = new DbConnection();
        assertNotNull(connection.getStatement());
    }

}