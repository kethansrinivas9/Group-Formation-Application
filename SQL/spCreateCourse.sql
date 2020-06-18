DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spCreateCourse`(
    IN courseID int(11),
    IN courseName varchar(55)
)
BEGIN
    INSERT INTO Courses VALUES (courseID, courseName);
END$$
DELIMITER ;