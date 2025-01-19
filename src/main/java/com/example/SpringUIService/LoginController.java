package com.example.SpringUIService;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	   @RequestMapping("/")
	    public String home() {
	    	return "welcome";
	    }
	    
	    @RequestMapping("/user")
	    public Principal user (Principal user) {
			return user;
	    	
	    }
}
