package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MySQLConnectionTest {

    @Test
    public void defaultConstructorTest() {
        MySQLConnection connection = new MySQLConnection("DEV_INT");
        assertNotNull(connection.getStatement());
    }

    @Test
    public void updateRecordsTest() {
        MySQLConnection connection = new MySQLConnection("DEV_INT");
        int noRecords = connection
                .updateRecords("INSERT INTO Users VALUES (1234, 'Avinash', 'avinash@gmail.com', 'password')");
        assertTrue(noRecords == 1);
    }

}