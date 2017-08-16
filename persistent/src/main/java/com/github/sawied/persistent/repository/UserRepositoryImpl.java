package com.github.sawied.persistent.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.ResultTransformer;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.sawied.persistent.domain.Address;
import com.github.sawied.persistent.domain.User;


public class UserRepositoryImpl implements UserRepositoryCustom{


	@PersistenceContext
	private EntityManager em;



	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public User saveOrUpdateUser(User user){
		 em.persist(user);
		 return user;
	}

	

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Address saveOrUpdateAddress(Address address){
		em.persist(address);
		return address;
	}
	
	
	/* (non-Javadoc)
	 * @see com.github.sawied.persistent.repository.UserRepository#deleteEntity()
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteEntity(){
		Long uid =22L;Long udId=23L;
		Query query=em.createNativeQuery("begin delete from USERAUDITLOG where id=?;delete from users where id=?;end;");
		query.setParameter(1, udId);
		query.setParameter(2, uid);
		query.executeUpdate();
	}


	@Override
	public Address loadAddress(Address address) {
		return this.em.merge(address);
	}



	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public List<User> searchUsers() {
		Session session=em.unwrap(Session.class);
		
		return session.createCriteria(User.class).setFetchMode("logs", FetchMode.JOIN).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	}
	
	
	
	
	

}
