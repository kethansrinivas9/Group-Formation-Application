package com.group8.dalsmartteamwork.login.model;

import com.group8.dalsmartteamwork.accesscontrol.CurrentUser;
import com.group8.dalsmartteamwork.login.dao.CourseRoleDaoImpl;
import com.group8.dalsmartteamwork.login.dao.ICourseRoleDao;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@Component
public class Successhandler implements AuthenticationSuccessHandler {

    ICourseRoleDao courseRole = new CourseRoleDaoImpl();
    private String BannerID;

    public String getBannerID() {
        return BannerID;
    }

    public void setBannerID(String bannerID) {
        BannerID = bannerID;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        CurrentUser currentUser = CurrentUser.getInstance();
        HttpSession session = request.getSession();
        String username = authentication.getPrincipal().toString();
        session.setAttribute("username", username);
        session.setAttribute("authorities", authentication.getAuthorities());
        setBannerID((String) session.getAttribute("username"));

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        Set<String> courseRoles = courseRole.getCourseRoles();

        currentUser.setBannerId(this.BannerID);

        if (roles.contains("Admin")) {
            currentUser.setRoles(roles);
            response.sendRedirect("/admin");
        } else if (roles.contains("Guest")) {
            currentUser.setRoles(courseRoles);

            if (courseRoles.contains("TA")) {
                response.sendRedirect("/TApage");
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
