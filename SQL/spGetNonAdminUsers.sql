DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetNonAdminUsers`(
)
BEGIN
    SELECT Users.BannerID, Users.FirstName, Users.LastName FROM Users INNER JOIN SystemRole on Users.BannerID = SystemRole.BannerID AND SystemRole.RoleID = 1;
END$$
DELIMITER ;