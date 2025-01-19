package com.example.SpringUIService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringUiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUiServiceApplication.class, args);
	}

}
