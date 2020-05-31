package com.group8.dalsmartteamwork;

import com.group8.dalsmartteamwork.utils.DbConnection;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class DbConnectionTest {

    @Test
    public void defaultConstructorTest() {
        DbConnection connection = new DbConnection();
        assertNotNull(connection.getStatement());
        connection.close();
    }

    @Test
    public void updateRecordsTest() {
        DbConnection connection = new DbConnection();
        Random rand = new Random();
        String id = Integer.toString(rand.nextInt(1000000));
        String query = String
                .format("INSERT INTO Users VALUES ('%s', 'Avinash', 'Gazula', 'avinash@gmail.com', 'password')", id);
        int noRecords = connection.updateRecords(query);
        assertTrue(noRecords == 1);
        connection.close();
    }

}