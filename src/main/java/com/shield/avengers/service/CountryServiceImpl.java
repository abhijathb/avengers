package com.shield.avengers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shield.avengers.dao.CountryDAO;
import com.shield.avengers.entity.Country;

@Service
public class CountryServiceImpl implements CountryService {

	private CountryDAO countryDAO;

	@Autowired
	public CountryServiceImpl(CountryDAO countryDAO) {
		this.countryDAO = countryDAO;
	}

	@Override
	@Transactional
	public List<Country> getAll() {
		return countryDAO.getAll();
	}
}
