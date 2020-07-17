CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetAnswers`(IN courseID int(11))
BEGIN
SELECT * from Answer where CourseID = courseID;
END