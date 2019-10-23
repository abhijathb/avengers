package com.shield.avengers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shield.avengers.service.ChatmessageService;
import com.shield.avengers.service.CountryService;

@Controller
public class SessionController {

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private ChatmessageService chatmessageService;

	@RequestMapping("/login")
	public String showLoginPage() {
		return "login-page";
	}

	@RequestMapping("/")
	public String showHomePage(Authentication authentication, Model model) {
		model.addAttribute("username", authentication.getName());
		model.addAttribute("countryList", countryService.getAll());
		model.addAttribute("messageList", chatmessageService.getByTouser(authentication.getName()));
		return "home";
	}

	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
