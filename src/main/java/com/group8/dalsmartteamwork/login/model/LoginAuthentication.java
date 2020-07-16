package com.group8.dalsmartteamwork.login.model;

import com.group8.dalsmartteamwork.accesscontrol.User;
import com.group8.dalsmartteamwork.login.dao.ILoginDao;
import com.group8.dalsmartteamwork.login.dao.LoginDaoFactory;
import com.group8.dalsmartteamwork.login.dao.LoginDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class LoginAuthentication implements AuthenticationManager {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public String role;
    Boolean status;
    ILoginDao loginImplementation = LoginDaoFactory.instance().loginDao();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = new User();
        String username = authentication.getPrincipal().toString();
        String password = authentication.getCredentials().toString();
        IEncryption encryption = LoginModelFactory.instance().encryption();
        String encryptedPassword = encryption.encrypt(password);
        try {
            status = loginImplementation.getUserDetails(username, user.getFirstName(), user.getEmail(),
                    encryptedPassword);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            if (status) {
                role = loginImplementation.getRole();
                user.setRole(role);
                RoleAuthorization roleAuthorization = new RoleAuthorization(user);
                return new UsernamePasswordAuthenticationToken(username, password, roleAuthorization.getAuthorities());
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred while authenticating user.", e);
        }
        return null;
    }
}
