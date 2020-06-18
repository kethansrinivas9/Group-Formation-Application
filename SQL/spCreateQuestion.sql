DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spCreateQuestion`(
	IN title VARCHAR(150),
    IN typeID INT(11),
    IN questionText VARCHAR(400),
    IN bannerId VARCHAR(45)
)
BEGIN
    DECLARE qID INT(11);
	INSERT INTO Question(Title, TypeID, QuestionText, BannerID, DateCreated)
    VALUES (title, typeID, questionText, bannerID, now());
	SET qID = LAST_INSERT_ID();
    SELECT Q.questionID FROM Question Q WHERE Q.questionID = qID;
END$$
DELIMITER ;