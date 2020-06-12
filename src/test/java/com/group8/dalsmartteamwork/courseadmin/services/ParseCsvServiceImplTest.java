package com.group8.dalsmartteamwork.courseadmin.services;

import com.group8.dalsmartteamwork.utils.CsvReader;
import com.group8.dalsmartteamwork.utils.ICsvReader;
import com.group8.dalsmartteamwork.utils.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParseCsvServiceImplTest {
    private ICsvReader reader = mock(CsvReader.class);
    private ParseCsvService service;
    private List<User> users  = new ArrayList<>();
    private User existingUser = new User("B00000000", "fName", "lName", "email@email.com", "pwd");
    private User newUser = new User("B1111111", "fName", "lName", "email@email.com", "pwd");

    @BeforeEach
    public void setup(){
        service = new ParseCsvServiceImpl(reader);
        users.add(existingUser);
        users.add(newUser);
    }

    @Test
    public void getUsersTest(){
        when(reader.getUsers()).thenReturn(users);
        assertSame(service.getUsers(), users);
    }
}
