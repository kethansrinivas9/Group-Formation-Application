package com.group8.dalsmartteamwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DalSmartTeamworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DalSmartTeamworkApplication.class, args);
    }

}
