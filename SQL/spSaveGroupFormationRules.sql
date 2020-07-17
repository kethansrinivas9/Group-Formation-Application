DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spSaveGroupFormationRules`(
	IN courseID INT(11),
    IN groupSize INT(11),
    IN multipleChoiceSingleOptionRule VARCHAR (45),
    IN multipleChoiceMultipleOptionRule VARCHAR (45),
    IN numericRule VARCHAR (45),
    IN numericValue INT(11),
    IN freeTextRule VARCHAR (45))
BEGIN
	INSERT INTO GroupFormationRules(CourseID, GroupSize, MultipleChoiceSingleOptionRule, MultipleChoiceMultipleOptionRule, NumericRule, NumericValue, FreeTextRule)
    VALUES (courseID, groupSize, multipleChoiceSingleOptionRule, multipleChoiceMultipleOptionRule, numericRule, numericValue, freeTextRule);
END$$
DELIMITER;