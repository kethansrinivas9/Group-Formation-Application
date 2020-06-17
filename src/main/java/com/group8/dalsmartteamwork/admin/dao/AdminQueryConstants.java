package com.group8.dalsmartteamwork.admin.dao;

final class AdminQueryConstants {
    private AdminQueryConstants() {
    }

    public static final String GET_ALL_USERS = "SELECT * FROM Users";
    public static final String GET_ALL_COURSES = "SELECT * FROM Courses";
    public static final String CREATE_COURSE = "INSERT INTO Courses VALUES ('%s', '%s')";
    public static final String CREATE_INSTRUCTOR = "INSERT INTO CourseRole VALUES ('%s', '%s', '%s')";
    public static final String GET_INSTRUCTOR_ID = "SELECT BannerID from CourseRole where CourseID = '%s' AND RoleID = '%s'";
    public static final String GET_USERS_WHO_ARE_GUEST_OR_INSTRUCTOR = "SELECT BannerID FROM CourseRole WHERE RoleID = '%s' UNION (SELECT BannerID FROM SystemRole WHERE RoleID = '%s' AND BannerID NOT IN (SELECT BannerID from CourseRole))";
    public static final String UPDATE_COURSE = "UPDATE Courses SET CourseName = '%s', CourseID = '%s' where CourseID = '%s'";
    public static final String UPDATE_INSTRUCTOR = "UPDATE CourseRole SET BannerID = '%s' where CourseID = '%s' AND RoleID = '%s'";
    public static final String DELETE_COURSE = "DELETE FROM Courses WHERE CourseID = '%s'";
    public static final String GET_ALL_NON_ADMIN_USERS = "SELECT Users.BannerID, Users.FirstName, Users.LastName FROM " +
            "Users INNER JOIN SystemRole on Users.BannerID = SystemRole.BannerID AND SystemRole.RoleID = '%s'";
}
