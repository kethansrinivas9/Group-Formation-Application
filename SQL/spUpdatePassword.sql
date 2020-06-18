DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spUpdatePassword`(
	IN newPassword VARCHAR(55),
    IN bannerID VARCHAR(55)
)
BEGIN
    UPDATE Users SET Users.Password=newPassword WHERE Users.BannerID=bannerID;
END$$

DELIMITER ;