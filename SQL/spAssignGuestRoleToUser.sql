DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spAssignGuestRoleToUser`(
	IN bannerID VARCHAR(45),
	IN roleID int(11)
)
BEGIN
    INSERT INTO SystemRole(BannerID, RoleID)
    VALUES (bannerID, roleID);
END$$
DELIMITER ;