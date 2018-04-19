package com.github.sawied.jweb.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import com.github.sawied.jweb.entity.UserEntity;

public class UserRepositoryImpl implements UserRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public UserEntity loadUserById(Long id) {
		Session session=entityManager.unwrap(Session.class);
		Criteria  criteria =session.createCriteria(UserEntity.class).add(Restrictions.idEq(id));
		UserEntity user =(UserEntity) criteria.uniqueResult();
		//System.out.println(user.getXmlData());
		return user;
	}

	@Override
	@Transactional
	public UserEntity saveUser(final UserEntity user) {
		Session session=entityManager.unwrap(Session.class);
		UserEntity exist = session.load(UserEntity.class, user.getId());
		//exist.setXmlData(user.getXmlData());
		session.update(exist);
		return user;
	}

}
