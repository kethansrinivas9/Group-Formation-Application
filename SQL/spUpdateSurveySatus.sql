DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spUpdateSurveyStatus`(

    IN courseID int,
    IN Status int

)
BEGIN
    UPDATE SurveyStatus SET SurveyStatus.Status = Status WHERE SurveyStatus.CourseID = courseID;
END$$

DELIMITER ;