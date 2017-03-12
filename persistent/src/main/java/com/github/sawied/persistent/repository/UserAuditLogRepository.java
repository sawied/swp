package com.github.sawied.persistent.repository;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.sawied.persistent.domain.UserAuditLog;

/**
 * 
 * @author DANAN
 *
 */
public  class UserAuditLogRepository extends SimpleJpaRepository<UserAuditLog,Long> {
    
    private EntityManager em;

    @Autowired
    public UserAuditLogRepository(
	    EntityManager em) {	
	super(UserAuditLog.class,em);
	this.em=em;
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public Page<UserAuditLog> searchUserLog(Map<String,Object> params,Pageable pageable){
	CriteriaBuilder cb = this.em.getCriteriaBuilder();
	CriteriaQuery<UserAuditLog> query = cb.createQuery(UserAuditLog.class);
	Root<UserAuditLog> root = query.from(UserAuditLog.class);
	query.select(root);
	
	ParameterExpression<String> p = cb.parameter(String.class, "message");
	query.where(cb.like(root.<String>get("message"), p));
	
	TypedQuery<UserAuditLog> q = em.createQuery(query);
	Set<String> keys = params.keySet();
	Iterator<String> iterator = keys.iterator();
	while(iterator.hasNext()){
	    String key = iterator.next();
	    q.setParameter(key,params.get(key));
	}
	
	List<UserAuditLog> result = q.getResultList();
	
	return new PageImpl<UserAuditLog>(result, pageable, result.size());
    }
    
    
    
    

}
