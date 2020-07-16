DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spCheckIfQuestionsExist`(
	IN courseID int
)
BEGIN
    select count(QuestionID) from Survey where Survey.CourseID=courseID;
END$$
DELIMITER ;