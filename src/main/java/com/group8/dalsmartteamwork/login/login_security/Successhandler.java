package com.group8.dalsmartteamwork.login.login_security;

import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.group8.dalsmartteamwork.login.dao.CourseRoleImp;
import com.group8.dalsmartteamwork.login.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class Successhandler implements AuthenticationSuccessHandler {

    CourseRoleImp courseRole = new CourseRoleImp();
    User user = new User();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();
        String username = authentication.getPrincipal().toString();
        session.setAttribute("user", authentication.getPrincipal());
        session.setAttribute("username", username);
        session.setAttribute("authorities", authentication.getAuthorities());

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        Set<String> courseRoles = courseRole.getCourseRoles();

        if (roles.contains("Admin")) {
            response.sendRedirect("/admin");
        } else if (roles.contains("Guest")) {
            if ((courseRoles.contains("Student") && courseRoles.contains("TA"))) {
                response.sendRedirect("/TA");
            } else if (courseRoles.contains("Student")) {
                response.sendRedirect("/student");
            } else if (courseRoles.contains("Instructor")) {
                response.sendRedirect("/instructor");
            } else {
                response.sendRedirect("/guest");
            }   
        }
    }
}
