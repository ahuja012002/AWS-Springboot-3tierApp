package com.example.SpringUIService;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests(registry->{registry.requestMatchers("/","/login").permitAll();
		registry.anyRequest().authenticated();
	
	}).oauth2Login(oauth2login -> {
        oauth2login.loginPage("/login")
        .successHandler((request, response, authentication) -> response.sendRedirect("/home"));
        
    })
				.build();
	}
}