package com.shield.avengers.service;

import java.util.List;

import com.shield.avengers.entity.User;

public interface UserService {
	public List<User> findAll();
	public User save(User user);
	public User findByName(String username);
	public User delete(String name);
	public int update(User user);
}
