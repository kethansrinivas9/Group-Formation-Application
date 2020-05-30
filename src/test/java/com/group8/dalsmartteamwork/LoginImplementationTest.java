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
        DbConnection connection = new DbConnection();
        Connection con = connection.conn;
        PreparedStatement ps = con.prepareStatement("SELECT FirstName from Users WHERE Email=? and Password =? ");
        ps.setString(1, "email");
        ps.setString(2, "password");
        ResultSet rs = ps.executeQuery();
        assertTrue(!rs.next());
    }
}