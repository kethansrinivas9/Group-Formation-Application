DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetEligibleTAs`(IN courseID VARCHAR(40))
BEGIN
SELECT * FROM Users u, CourseRole c WHERE c.CourseID=c and c.RoleID=3 and u.BannerID=c.BannerID;
END$$

DELIMITER ;