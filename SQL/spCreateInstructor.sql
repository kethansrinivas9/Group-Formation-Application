DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spCreateInstructor`(
    IN bannerId varchar(45),
    IN courseId int
)
BEGIN
    INSERT INTO CourseRole VALUES (bannerId, courseId, 4);
END$$
DELIMITER ;