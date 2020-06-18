DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetResetRequest`(
	IN bannerID VARCHAR(55),
    IN token VARCHAR(55)
)
BEGIN
    SELECT * FROM PasswordResetToken WHERE PasswordResetToken.BannerID=bannerID and PasswordResetToken.Token=token;
END$$

DELIMITER ;