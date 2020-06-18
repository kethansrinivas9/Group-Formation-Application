package com.group8.dalsmartteamwork.course.dao;

import com.group8.dalsmartteamwork.course.model.Course;
import com.group8.dalsmartteamwork.utils.DbConnection;
import com.group8.dalsmartteamwork.utils.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    private DbConnection connection;

    @Override
    public Boolean courseExists(int courseID) {
        Course course = new Course();
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format("SELECT * FROM Courses WHERE CourseID='%s'", courseID);
            ResultSet rs = connection.getRecords(query);
            if (rs.next()) {
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
    public List<User> getUsersForTA(int courseID) {
        List<User> users = new ArrayList<>();
        List<String> enrolled = new ArrayList<>();
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format("SELECT * FROM Users WHERE BannerID NOT IN (SELECT BannerID FROM CourseRole where CourseID=%s);", courseID);
            ResultSet rs = connection.getRecords(query);
            while (rs.next()) {
                users.add(new User(rs.getString("BannerID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), ""));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
        return users;
    }

    @Override
    public List<User> getCurrentTAs(int courseID) {
        List<String> taBannerIDList = new ArrayList<>();
        List<User> taList = new ArrayList<>();
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format("SELECT * FROM Users u, CourseRole c WHERE c.CourseID=%s and c.RoleID=3 and u.BannerID=c.BannerID", courseID);
            ResultSet rs = connection.getRecords(query);
            while (rs.next()) {
                taList.add(new User(rs.getString("BannerID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), ""));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
        return taList;
    }

    @Override
    public List<User> getCurrentStudents(int courseID) {
        List<String> studentBannerIDList = new ArrayList<>();
        List<User> studentList = new ArrayList<>();
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format("SELECT * FROM Users u, CourseRole c WHERE CourseID=%s and RoleID=2 and u.BannerID=c.BannerID;", courseID);
            ResultSet rs = connection.getRecords(query);
            while (rs.next()) {
                studentList.add(new User(rs.getString("BannerID"), rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Email"), ""));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
        return studentList;
    }

    @Override
    public String getCourseName(int courseID) {
        String result = "notfound";
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format("SELECT * FROM Courses WHERE CourseID='%s'", courseID);
            ResultSet rs = connection.getRecords(query);
            while (rs.next()) {
                result = rs.getString("BannerID");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            connection.close();
        }
        return result;
    }

    @Override
    public Boolean addTAtoCourse(String bannerID, int courseID) {
        try {
            connection = DbConnection.getInstance();
            connection.createDbConnection();
            String query = String.format("INSERT INTO CourseRole (BannerID, CourseID, RoleID) VALUES ('%s', '%s', 3)", bannerID, courseID);
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
