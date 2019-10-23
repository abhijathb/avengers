package com.shield.avengers.service;

import java.util.List;

import com.shield.avengers.entity.Chatmessage;

public interface ChatmessageService {
	public List<Chatmessage> getAll();
	public Chatmessage save(Chatmessage chatmessage);
	public Chatmessage update(Chatmessage chatmessage);
	public List<Chatmessage> getByTouser(String username);
	public Chatmessage getById(long id);
	public int delete(long id);
}
