package com.shield.avengers.rest;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shield.avengers.entity.User;
import com.shield.avengers.rest.consuming.Country;
import com.shield.avengers.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/country/{countryCode}")
	public Country getCountryDetails(@PathVariable String countryCode) {
		String restAPIString = "https://restcountries.eu/rest/v2/alpha/{0}";
		Country country = restTemplate.getForObject(MessageFormat.format(restAPIString, countryCode), Country.class);
		return country;
	}
	
	@GetMapping("/{username}")
	public User getUserDetails(@PathVariable String username) {
		return userService.findByName(username);
	}
}
