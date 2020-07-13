create
    definer = CSCI5308_8_DEVINT_USER@`%` procedure spGetEnrolledCourses(IN bannerID varchar(55))
BEGIN
select Courses.CourseID, Courses.CourseName from CourseRole, Courses  where BannerID=bannerID and RoleID=2 and CourseRole.CourseID = Courses.CourseID;
END;