package com.group8.dalsmartteamwork.login.login_security;

import org.springframework.context.annotation.Configuration;
import com.group8.dalsmartteamwork.login.login_security.Successhandler;
import com.group8.dalsmartteamwork.login.login_security.LoginAuthentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebConfig extends WebSecurityConfigurerAdapter {

    public Successhandler successHandler = new Successhandler();

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return new LoginAuthentication();
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/admin**").hasAnyAuthority("Admin")
            .antMatchers("/student**").hasAnyAuthority("Student", "TA","Instructor")
            .antMatchers("/guest**").hasAnyAuthority("Guest")
            .antMatchers("/login").permitAll()
            .antMatchers("/loginError").permitAll()
            .antMatchers("/register").permitAll()       
            .and()
            .formLogin()
            .loginPage("/login").permitAll()
            .failureUrl("/loginError")
            .successHandler(successHandler)
            .and()
            .logout().permitAll()
            .and()
            .httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**");
    }
}