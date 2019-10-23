package com.shield.avengers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shield.avengers.dao.ChatmessageDAO;
import com.shield.avengers.entity.Chatmessage;

@Service
public class ChatmessageServiceImpl implements ChatmessageService {

	private ChatmessageDAO chatmessageDAO;
	
	@Autowired
	public ChatmessageServiceImpl(ChatmessageDAO chatmessageDAO){
		this.chatmessageDAO = chatmessageDAO;
	}
	
	@Override
	@Transactional
	public List<Chatmessage> getAll() {
		return chatmessageDAO.getAll();
	}

	@Override
	@Transactional
	public Chatmessage save(Chatmessage chatmessage) {
		return chatmessageDAO.save(chatmessage);
	}

	@Override
	@Transactional
	public Chatmessage update(Chatmessage chatmessage) {
		return chatmessageDAO.update(chatmessage);
	}

	@Override
	@Transactional
	public List<Chatmessage> getByTouser(String username) {
		return chatmessageDAO.getByTouser(username);
	}

	@Override
	@Transactional
	public Chatmessage getById(long id) {
		return chatmessageDAO.getById(id);
	}

	@Override
	@Transactional
	public int delete(long id) {
		return chatmessageDAO.delete(id);
	}

}
