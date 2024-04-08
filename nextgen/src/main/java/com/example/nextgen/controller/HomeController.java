package com.example.nextgen.controller;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String viewLoginPage() {
	return "newhome";
	}
	
	@GetMapping("/secured")
	public String viewSecure() {
		return "hello secure";
	}


}
