package com.group8.dalsmartteamwork.courseadmin;

import com.group8.dalsmartteamwork.courseadmin.models.CsvReader;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CsvReaderTest {
    private static final String TEST_FILE = "B123,FN1,LN1,FN1@gmail.com,pwd\n" + "b124,fn2,lm2,FN2@gmail.com,pwd";
    private static final String TEST_FILE_NAME = "Test.csv";

    @Test
    public void getUsersTest() {
        try {
            MultipartFile file = new MockMultipartFile(TEST_FILE_NAME, TEST_FILE.getBytes());
            CsvReader reader = new CsvReader(file);
            assertEquals(2, reader.getUsers().size());
        } catch (Exception e) {
            // TODO: Add to Log
            fail();
        }
    }

}