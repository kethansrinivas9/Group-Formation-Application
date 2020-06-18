DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spGetUserDetails`(
	IN bannerID VARCHAR(55),
    IN password VARCHAR(55)
)
BEGIN
    
Select Users.Password, Role.RoleName, Users.BannerID from Users INNER JOIN SystemRole on (Users.BannerID = SystemRole.BannerID) INNER JOIN Role on (Role.RoleID = SystemRole.RoleID) where Users.BannerID = bannerID and Users.Password = password;

END$$
DELIMITER ;