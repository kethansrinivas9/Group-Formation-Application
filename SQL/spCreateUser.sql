DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spCreateUser`(
	IN bannerID VARCHAR(45),
	IN lastName varchar(45),
	IN firstName varchar(45),
	IN email varchar(45),
	IN password varchar(45)
)
BEGIN
    INSERT INTO Users(BannerID, LastName, FirstName, Email, Password)
    VALUES (bannerID, lastName, firstName, email, password);
END$$

DELIMITER ;