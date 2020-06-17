DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spEnrollStudentToCourse`(
	IN bannerID VARCHAR(45),
	IN courseID int(11)
)
BEGIN
    INSERT INTO CourseRole(BannerID, CourseID, RoleID)
    VALUES (bannerID, CourseID, 2);
END$$
DELIMITER ;