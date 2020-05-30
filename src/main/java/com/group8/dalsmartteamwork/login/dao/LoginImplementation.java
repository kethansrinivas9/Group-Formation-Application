package com.group8.dalsmartteamwork.login.dao;

import java.sql.ResultSet;

import com.group8.dalsmartteamwork.utils.DbConnection;

public class LoginImplementation implements LoginDao{

	@Override
	public Boolean getUserDetails(String id, String name, String email, String password) {
        
		try{
            DbConnection connection=new DbConnection();
            System.out.println("Database connected");
            String query = String.format("SELECT Email from Users WHERE Email= '%s' and Password = '%s' ", email,password);
            ResultSet rs = connection.getRecords(query);
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