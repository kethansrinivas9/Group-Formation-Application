package com.group8.dalsmartteamwork.login.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;

import com.group8.dalsmartteamwork.utils.DbConnection;

public class LoginImplementation implements LoginDao{

    //boolean checkUser = false;
	@Override
	public Boolean getUserDetails(String id, String name, String email, String password) {
        // TODO Auto-generated method stub
        
		try{
            DbConnection connection=new DbConnection();
            Connection con = connection.conn;
            //MySQLConnection conn = new MySQLConnection("DEV_INT");
            //Connection con = DriverManager.getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_8_DEVINT", "CSCI5308_8_DEVINT_USER", "CSCI5308_8_DEVINT_8189");
            System.out.println("Database connected");
            //String query = "SELECT Name from Users WHERE Email= '%s' and Password = '%s' ";
            PreparedStatement ps = con.prepareStatement("SELECT FirstName from Users WHERE Email=? and Password =? ");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
        if (rs.next()) {
        System.out.println("User exists");
        return true;
        } else {
        System.out.println("No user");
        return false;
        }
       
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
	}


}