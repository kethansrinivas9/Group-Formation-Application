DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spListAllCourses`(
	IN bannerID VARCHAR(55)
)
BEGIN
    
    Select CourseID from CourseRole where CourseRole.BannerID = bannerID;
    
END$$

DELIMITER ;