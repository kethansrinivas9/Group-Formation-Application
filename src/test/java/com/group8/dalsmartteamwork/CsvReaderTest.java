package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.group8.dalsmartteamwork.utils.CsvReader;

import org.junit.jupiter.api.Test;

public class CsvReaderTest {
    public static final String FILE_PATH = "students.csv";
    public static final String TEST_FILE = "B123,FN1,LN1,FN1@gmail.com,pwd\n" + "b124,fn2,lm2,FN2@gmail.com,pwd";
    public static final String[] TEST_ARRAY = { "B124", "fn", "ln", "email@email.com", "password" };

    @Test
    public void constructorInputStreamTest() {
        try {
            InputStream inputStream = new ByteArrayInputStream(TEST_FILE.getBytes(StandardCharsets.UTF_8));
            CsvReader reader = new CsvReader(inputStream);
            assertNotNull(reader.getBufferedReader());
        } catch (Exception e) {
            // TODO: Add to Log
            assertTrue(false);
        }
    }

    @Test
    public void getUsersTest() {
        try {
            InputStream inputStream = new ByteArrayInputStream(TEST_FILE.getBytes(StandardCharsets.UTF_8));
            CsvReader reader = new CsvReader(inputStream);
            assertTrue(reader.getUsers().size() == 2);
        } catch (Exception e) {
            // TODO: Add to Log
            assertTrue(false);
        }
    }

}