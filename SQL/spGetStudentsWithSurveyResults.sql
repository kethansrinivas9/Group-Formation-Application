CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetStudentsWithSurveyResults`(IN courseID int(11))
BEGIN
SELECT Distinct BannerID from Answer where CourseID = courseID;
END