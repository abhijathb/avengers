package com.shield.avengers.dao;

import java.util.List;

import com.shield.avengers.entity.User;

public interface UserDAO {
	public List<User> findAll();
	public User findByName(String username);
	public User save(User user);
	public User delete(String name);
	public int update(User user);
}
