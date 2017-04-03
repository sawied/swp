package com.github.sawied.persistent.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.sawied.persistent.domain.Address;
import com.github.sawied.persistent.domain.User;

public class UserRepository extends SimpleJpaRepository<User,Long>{

	 private EntityManager em;
	
	 @Autowired
	public UserRepository(EntityManager em) {
		super(User.class,em);
		this.em=em;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public User saveOrUpdateUser(User User){
		 em.persist(User);
		 return User;
	}

	
	@Transactional(propagation=Propagation.REQUIRED)
	public Address saveOrUpdateAddress(Address address){
		em.persist(address);
		return address;
	}
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteEntity(){
		Long uid =22L;Long udId=23L;
		Query query=em.createNativeQuery("begin delete from USERAUDITLOG where id=?;delete from users where id=?;end;");
		query.setParameter(1, udId);
		query.setParameter(2, uid);
		query.executeUpdate();
	}
	
	
	public Address loadAddress(Long id){
		return em.getReference(Address.class, id);
	}
	
	
	
	

}
