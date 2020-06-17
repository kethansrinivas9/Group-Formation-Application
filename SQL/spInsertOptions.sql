DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spInsertOptions`(
	IN questionID INT(11),
    IN displayText VARCHAR(150),
    IN storedAs INT(11))
BEGIN
	INSERT INTO QuestionOptions(QuestionID, DisplayText, StoredAs)
    VALUES (questionID, displayText, storedAs);
END$$
DELIMITER ;