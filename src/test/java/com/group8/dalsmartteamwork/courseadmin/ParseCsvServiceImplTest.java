package com.group8.dalsmartteamwork.courseadmin;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.courseadmin.models.CsvParserImpl;
import com.group8.dalsmartteamwork.courseadmin.models.CsvReader;
import com.group8.dalsmartteamwork.courseadmin.models.ICsvParser;
import com.group8.dalsmartteamwork.courseadmin.models.ICsvReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParseCsvServiceImplTest {
    private final ICsvReader reader = mock(CsvReader.class);
    private final List<User> users = new ArrayList<>();
    private final User existingUser = new User("B00000000", "fName", "lName", "email@email.com", "pwd");
    private final User newUser = new User("B1111111", "fName", "lName", "email@email.com", "pwd");
    private ICsvParser service;

    @BeforeEach
    public void setup() {
        service = new CsvParserImpl(reader);
        users.add(existingUser);
        users.add(newUser);
    }

    @Test
    public void getUsersTest() {
        when(reader.getUsers()).thenReturn(users);
        assertSame(service.getUsers(), users);
    }
}
