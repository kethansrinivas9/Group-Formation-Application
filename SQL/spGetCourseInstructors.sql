DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetCourseInstructors`(
    IN courseId int
)
BEGIN
    SELECT * FROM CourseRole WHERE CourseRole.CourseID=courseId and CourseRole.RoleID=4;
END$$
DELIMITER ;