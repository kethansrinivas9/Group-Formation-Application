package com.group8.dalsmartteamwork.login.login_security;

import org.springframework.security.authentication.AuthenticationManager;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.group8.dalsmartteamwork.login.dao.LoginImplementation;
import com.group8.dalsmartteamwork.login.model.Role;
import com.group8.dalsmartteamwork.login.model.User;
import com.group8.dalsmartteamwork.utils.Encryption;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class LoginAuthentication implements AuthenticationManager {

    public Set<Role> roleName = new HashSet<Role>();
    Boolean status;
    LoginImplementation loginImplementation = new LoginImplementation();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = new User();
        Iterator<Role> role;
        Iterator<Role> course;
        String[] roles = new String[20];
        String[] courses = new String[60];
        int i = 0;
        int j = 0;
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        Encryption encryption = new Encryption();
        String encryptedPassword = encryption.encrypt(password);
        try {
            status = loginImplementation.getUserDetails(username, user.getFirstName(), user.getEmail(),
                    encryptedPassword);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            if (status) {
                roleName = loginImplementation.roles;
                role = roleName.iterator();
                course = roleName.iterator();

                while (role.hasNext()) {
                    roles[i] = role.next().getRoleName();
                    i++;
                }
                while (course.hasNext()) {
                    courses[j] = course.next().getCourseName();
                    j++;
                }

                user.setRole(roles);
                user.setCourses(courses);
                RoleAuthorization roleAuthorization = new RoleAuthorization(user);
                return new UsernamePasswordAuthenticationToken(username, password, roleAuthorization.getAuthorities());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
