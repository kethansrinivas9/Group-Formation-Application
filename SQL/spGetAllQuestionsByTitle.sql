
DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetAllQuestionsByTitle`(
	IN bannerID VARCHAR(55)
)
BEGIN
    
    Select Title from Question where Question.BannerID = bannerID ORDER BY Title;
    
END$$
DELIMITER ;
