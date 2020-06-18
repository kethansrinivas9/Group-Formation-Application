DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spUpdateRequestStatus`(
    IN bannerID VARCHAR(55)
)
BEGIN
    UPDATE PasswordResetToken SET Status='expired' WHERE PasswordResetToken.BannerID=bannerID;
END$$

DELIMITER ;