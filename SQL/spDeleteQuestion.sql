DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spDeleteQuestion`(
	IN questionID VARCHAR(55)
)
BEGIN
    
   Delete from Question where Question.QuestionID=questionID;
    
END$$
DELIMITER ;


