DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetUser`(
    IN bannerID VARCHAR(55)
)
BEGIN
    SELECT * FROM Users WHERE Users.BannerID=bannerID;
END$$

DELIMITER ;