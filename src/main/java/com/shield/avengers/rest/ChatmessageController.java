package com.shield.avengers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shield.avengers.entity.Chatmessage;
import com.shield.avengers.service.ChatmessageService;

@RestController
@RequestMapping("/api/chatmessage")
public class ChatmessageController {

	private ChatmessageService chatmessageService;

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
}
