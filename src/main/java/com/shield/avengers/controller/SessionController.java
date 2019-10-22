package com.shield.avengers.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionController {

	@RequestMapping("/login")
	public String showLoginPage(){
		return "login-page";
	}
	
	@RequestMapping("/")
	public String showHomePage(Authentication authentication, Model model){
		model.addAttribute("username", authentication.getName());
		return "home";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
