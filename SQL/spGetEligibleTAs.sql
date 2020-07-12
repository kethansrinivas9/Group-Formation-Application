DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetEligibleTAs`(IN courseID VARCHAR(40))
BEGIN
SELECT Users.* from Users LEFT JOIN CourseRole ON Users.BannerID = CourseRole.BannerID where CourseRole.CourseID!=courseID and CourseRole.RoleID!=4;
END$$

DELIMITER ;