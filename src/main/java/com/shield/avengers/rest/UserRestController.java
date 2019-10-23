package com.shield.avengers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shield.avengers.entity.User;
import com.shield.avengers.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	private UserService userService;
	
	@Autowired
	public UserRestController(UserService userService){
		this.userService = userService;
	}
	
	@GetMapping("/")
	public List<User> findAll(){
		return userService.findAll();
	}
}
