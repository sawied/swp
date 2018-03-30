package com.github.sawied.jweb.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import com.github.sawied.jweb.entity.User;

public class UserRepositoryImpl implements UserRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public User loadUserById(Long id) {
		Session session=entityManager.unwrap(Session.class);
		Criteria  criteria =session.createCriteria(User.class).add(Restrictions.idEq(id));
		User user =(User) criteria.uniqueResult();
		//System.out.println(user.getXmlData());
		return user;
	}

	@Override
	@Transactional
	public User saveUser(final User user) {
		Session session=entityManager.unwrap(Session.class);
		User exist = session.load(User.class, user.getId());
		//exist.setXmlData(user.getXmlData());
		session.update(exist);
		return user;
	}

}
