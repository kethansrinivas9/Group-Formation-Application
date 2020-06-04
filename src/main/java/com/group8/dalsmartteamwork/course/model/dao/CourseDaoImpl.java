package com.group8.dalsmartteamwork.course.model.dao;

import com.group8.dalsmartteamwork.course.model.Course;
import com.group8.dalsmartteamwork.resetpassword.models.PasswordResetToken;
import com.group8.dalsmartteamwork.utils.DbConnection;
import com.group8.dalsmartteamwork.utils.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao{
    DbConnection connection;

    @Override
    public Boolean courseExists(int courseID) {
        Course course = new Course();
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format("SELECT * FROM CSCI5308_8_DEVINT.Courses WHERE CourseID='%s'", courseID);
            ResultSet rs = connection.getRecords(query);
            while (rs.next()) {
                connection.close();
                return true;
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
        return false;
    }

    @Override
    public List<User> getStudentsForTA(int courseID){
        List<User> users = new ArrayList<>();
        List<String> enrolled = new ArrayList<>();
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format("SELECT * FROM CSCI5308_8_DEVINT.CourseRole WHERE CourseID='%s'", courseID);
            ResultSet rs = connection.getRecords(query);
            while (rs.next()) {
                enrolled.add(rs.getString("BannerID"));
            }
                query = "SELECT * FROM CSCI5308_8_DEVINT.Users";
                rs = connection.getRecords(query);
                while (rs.next()) {
                    String bannerID;
                    Boolean alreadyExists = false;
                    for (String s : enrolled) {
                        bannerID = rs.getString("BannerID");
                        if (bannerID.equals(s)) {
                            alreadyExists = true;
                        }
                    }
                    if (!alreadyExists){
                        users.add(new User(rs.getString("BannerID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), ""));
                    }
                }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
        return users;
    }

    @Override
    public Boolean addTAtoCourse(String bannerID, int courseID){
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format("INSERT INTO CSCI5308_8_DEVINT.CourseRole (BannerID, CourseID, RoleID) VALUES ('%s', '%s', 3)", bannerID, courseID);
            int records = connection.addRecords(query);
            connection.close();
            return records > 0;
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
            connection.closeConnection();
            return false;
        } finally {
            connection.closeConnection();
        }
    }
}
