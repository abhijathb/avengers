package com.shield.avengers.rest;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shield.avengers.entity.Chatmessage;
import com.shield.avengers.service.ChatmessageService;
import com.shield.avengers.service.UserService;

@RestController
@RequestMapping("/api/chatmessage")
public class ChatmessageController {

	private Logger logger = Logger.getLogger(getClass().getName());
	@Autowired
	private ChatmessageService chatmessageService;
	@Autowired
	private UserService userService;

	@Autowired
	public ChatmessageController(ChatmessageService chatmessageService) {
		this.chatmessageService = chatmessageService;
	}

	@GetMapping("/")
	public List<Chatmessage> getAll() {
		return chatmessageService.getAll();
	}

	@PostMapping("/")
	public Chatmessage save(@RequestBody Chatmessage chatmessage) {
		chatmessage.setId(0);
		return chatmessageService.save(chatmessage);
	}

	@PostMapping("/send")
	public Chatmessage send(@RequestBody String stringPayload) throws JsonMappingException, JsonProcessingException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode payload = mapper.readTree(stringPayload);
		Chatmessage chatmessage = new Chatmessage();
		chatmessage.setId(0);
		chatmessage.setFrom_user(userService.findByName(authentication.getName()));
		chatmessage.setTo_user(userService.findByName(payload.get("to_user").textValue()));
		chatmessage.setMessage(payload.get("message").textValue());
		chatmessage.setLoggedtime(new Date());
		return chatmessageService.save(chatmessage);
	}
}
