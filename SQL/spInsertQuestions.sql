DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spInsertQuestions`(
    IN courseID VARCHAR(150),
    IN questionID INT(11))
BEGIN
	INSERT INTO Survey(courseID,questionID)
    VALUES (courseID, questionID);
END$$

DELIMITER ;