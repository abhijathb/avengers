package com.shield.avengers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shield.avengers.dao.UserDAO;
import com.shield.avengers.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	@Autowired
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public User save(User user) {
		return userDAO.save(user);
	}

	@Override
	@Transactional
	public User delete(String name) {
		return userDAO.delete(name);
	}

	@Override
	@Transactional
	public int update(User user) {
		return userDAO.update(user);
	}

	@Override
	@Transactional
	public User findByName(String username) {
		return userDAO.findByName(username);
	}

}
