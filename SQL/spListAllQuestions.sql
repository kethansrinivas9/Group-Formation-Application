DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spListAllQuestions`(
	IN bannerID VARCHAR(55)
)
BEGIN
    
    Select QuestionID, QuestionText from Question where Question.BannerID = bannerID;
    
END$$
DELIMITER ;


