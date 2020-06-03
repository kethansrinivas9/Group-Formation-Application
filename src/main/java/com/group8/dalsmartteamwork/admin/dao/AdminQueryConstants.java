package com.group8.dalsmartteamwork.admin.dao;

final class AdminQueryConstants {
    private AdminQueryConstants() {
    }

    public static final String GET_ALL_USERS = "SELECT * FROM Users";
    public static final String GET_ALL_COURSES = "SELECT * FROM Courses";
    public static final String CREATE_COURSE = "INSERT INTO Courses VALUES ('%s', '%s')";
    public static final String UPDATE_COURSE = "UPDATE Courses SET CourseName = '%s', CourseID = '%s' where CourseID = '%s'";
    public static final String DELETE_COURSE = "DELETE FROM Courses WHERE CourseID = '%s'";
    public static final String GET_ALL_NON_ADMIN_USERS = "SELECT Users.BannerID, Users.FirstName, Users.LastName FROM " +
            "Users INNER JOIN SystemRole on Users.BannerID = SystemRole.BannerID AND SystemRole.RoleID = 1";
}
