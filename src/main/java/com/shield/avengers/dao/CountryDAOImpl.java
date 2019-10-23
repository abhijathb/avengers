package com.shield.avengers.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shield.avengers.entity.Country;

@Repository
public class CountryDAOImpl implements CountryDAO {
	private EntityManager entityManager;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public CountryDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Country> getAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Country> query = session.createQuery("from Country", Country.class);
		List<Country> countryList = query.getResultList();
		logger.info(">>> countryList=" + countryList.toString());
		return countryList;
	}
}
