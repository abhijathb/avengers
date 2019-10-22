package com.shield.avengers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {

	@RequestMapping("/login")
	public String showLoginPage(){
		return "fancy-login";
	}
	
	@RequestMapping("/")
	public String showHomePage(){
		return "home";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
