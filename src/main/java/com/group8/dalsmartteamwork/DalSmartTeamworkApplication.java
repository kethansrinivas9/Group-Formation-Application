package com.group8.dalsmartteamwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
//@RestController
public class DalSmartTeamworkApplication {

	// @GetMapping(value = "/hello")
	// public String getMethodName()
	// {
	// 	return "Hello";
	// }

	public static void main(String[] args) {
		SpringApplication.run(DalSmartTeamworkApplication.class, args);
	}

}
