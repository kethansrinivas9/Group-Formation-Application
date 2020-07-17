CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetGroupFormationRules`(IN courseID int(11))
BEGIN
SELECT * From GroupFormationRules where CourseID=courseID;
END