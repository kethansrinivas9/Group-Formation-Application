CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetQuestionTypeID`(IN questionID int(11))
BEGIN
select TypeID from Question where QuestionID=questionID;
END