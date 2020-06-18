
DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spDisplayCourses`(
	IN bannerID VARCHAR(55)
)
BEGIN
    
select Courses.CourseID, Courses.CourseName, Users.BannerID from Courses INNER JOIN CourseRole on (Courses.CourseID = CourseRole.CourseID) INNER JOIN Role on (CourseRole.RoleID = Role.RoleID) INNER JOIN Users on (Users.BannerID = Users.BannerID) where Role.RoleID='2' and Users.BannerID= bannerID;
END$$
DELIMITER ;

