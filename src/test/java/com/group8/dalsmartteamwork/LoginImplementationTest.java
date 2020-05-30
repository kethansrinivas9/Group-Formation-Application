package com.group8.dalsmartteamwork;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group8.dalsmartteamwork.utils.DbConnection;

import org.junit.jupiter.api.Test;

public class LoginImplementationTest {

    @Test
    public void getUserDetails() throws SQLException
    {
        String email = "email@gmail.com";
        String password = "email@123";
        DbConnection connection = new DbConnection();
        String query = String.format("SELECT Email from Users WHERE Email= '%s' and Password = '%s' ", email,password);
        ResultSet rs = connection.getRecords(query);
        assertTrue(!rs.next());
    }
}