DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spUpdateInstructor`(
    IN iBannerId varchar(45),
    IN iCourseId int
)
BEGIN
    UPDATE CourseRole SET CourseRole.BannerID = iBannerId where CourseRole.CourseID = iCourseId AND CourseRole.RoleID = 4;
    SELECT ROW_COUNT();
END$$
DELIMITER ;