DELIMITER $$
CREATE DEFINER=`CSCI5308_8_DEVINT_USER`@`%` PROCEDURE `spDisplayQuestionsToTA`(
	IN courseID VARCHAR(55),
    IN bannerID VARCHAR(55)
)
BEGIN
    
    select Question.QuestionID,Question.QuestionText from SurveyStatus Join CourseRole on (SurveyStatus.courseID = CourseRole.courseID) Join Question on (Question.BannerID = CourseRole.BannerID) where CourseRole.RoleID="4" and CourseRole.courseID = courseID ;
    
END$$

DELIMITER ;