DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetCurrentStudents`(IN courseID VARCHAR(40))
BEGIN
SELECT * FROM Users u, CourseRole c WHERE c.CourseID=courseID and c.RoleID=2 and u.BannerID=c.BannerID;
END$$

DELIMITER ;