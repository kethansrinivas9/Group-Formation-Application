DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetCourseRole`(
	IN bannerID VARCHAR(55)
)
BEGIN
    
   select Role.RoleName, Role.RoleID, Users.BannerID from Courses INNER JOIN CourseRole on (Courses.CourseID = CourseRole.CourseID) INNER JOIN Role on (CourseRole.RoleID = Role.RoleID) INNER JOIN Users on (Users.BannerID = CourseRole.BannerID) where Users.BannerID= bannerID;
    
END$$
DELIMITER ;
