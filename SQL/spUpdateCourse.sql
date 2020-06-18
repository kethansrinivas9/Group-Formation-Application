DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spUpdateCourse`(
    IN iCourseName varchar(45),
    IN newCourseId int,
    IN oldCourseId int
)
BEGIN
    UPDATE Courses SET Courses.CourseName = iCourseName, Courses.CourseID = newCourseId where Courses.CourseID = oldCourseId;
END$$
DELIMITER ;