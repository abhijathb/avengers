package com.shield.avengers.dao;

import java.util.List;

import com.shield.avengers.entity.Chatmessage;

public interface ChatmessageDAO {

	public List<Chatmessage> getAll();
	public Chatmessage save(Chatmessage chatmessage);
	public Chatmessage update(Chatmessage chatmessage);
	public List<Chatmessage> getByTouser(String username);
	public Chatmessage getById(long id);
	public int delete(long id);
}
