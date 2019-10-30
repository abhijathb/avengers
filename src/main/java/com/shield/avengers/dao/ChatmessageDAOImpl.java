package com.shield.avengers.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shield.avengers.entity.Chatmessage;
import com.shield.avengers.service.UserService;

@Repository
public class ChatmessageDAOImpl implements ChatmessageDAO {
	private EntityManager entityManager;

	@Autowired
	private UserService userService;

	@Autowired
	public ChatmessageDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Chatmessage> getAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Chatmessage> query = session.createQuery("from Chatmessage", Chatmessage.class);
		List<Chatmessage> chatmessageList = query.getResultList();
		return chatmessageList;
	}

	@Override
	public Chatmessage save(Chatmessage chatmessage) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(chatmessage);
		return chatmessage;
	}

	@Override
	public Chatmessage update(Chatmessage chatmessage) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(chatmessage);
		return chatmessage;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Chatmessage> getByTouser(String username) {
		Session session = entityManager.unwrap(Session.class);
		List<Chatmessage> chatmessageList = (List<Chatmessage>) session
				.createQuery("from Chatmessage c where c.to_user = ?1")
				.setParameter(1, userService.findByName(username)).list();
		return chatmessageList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int delete(long id) {
		Session session = entityManager.unwrap(Session.class);
		Query<Chatmessage> query = session.createQuery("delete from Chatmessage c where c.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		return 1;
	}

	@Override
	public Chatmessage getById(long id) {
		Session session = entityManager.unwrap(Session.class);
		Chatmessage chatmessage = (Chatmessage) session
				.createQuery("from Chatmessage c where c.id = ?1")
				.setParameter(1, id).list().get(0);
		return chatmessage;
	}

}
