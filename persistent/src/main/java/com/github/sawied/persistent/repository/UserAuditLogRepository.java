package com.github.sawied.persistent.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.QueryUtils;
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
    
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public Page<UserAuditLog> searchUserLog(Map<String, Object> params, Pageable pageable) {
		// Query Count
		Long count = countByCondition(params);

		// Query Result List
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<UserAuditLog> query = cb.createQuery(UserAuditLog.class);
		Root<UserAuditLog> root = query.from(UserAuditLog.class);
		root.fetch("logDetails");
		query.select(root);
		//query.select(cb.construct(UserAuditLog.class, root.get("id"),root.get("message"),cb.prod(cb.diff(cb.sum(root.<Number>get("start"), 0),cb.sum(root.<Number>get("end"), 0)),86400).alias("duration")));
		//query.multiselect(cb.prod(cb.diff(cb.sum(root.<Number>get("start"), 0),cb.sum(root.<Number>get("end"), 0)),86400).alias("duration"),root);
		
		List<Predicate> predicates=buildPridicate(params,root,cb);
    	if(!predicates.isEmpty()){    	
    		query.where(predicates.toArray(new Predicate[0]));
    	}
    	if(pageable!=null&&pageable.getSort()!=null){
    		 List<Order> orders = QueryUtils.toOrders(pageable.getSort(), root, cb);
    		query.orderBy(orders);
    	}
    	
		TypedQuery<UserAuditLog> q = em.createQuery(query);
		q.setMaxResults(pageable.getPageSize());
		q.setFirstResult(pageable.getOffset());
		List<UserAuditLog> result = this.applyParameters(params, q).getResultList();
		return new PageImpl<UserAuditLog>(result, pageable, count);
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void exportLargeData(){
	    Session session =(Session)this.em.getDelegate();
	    ScrollableResults scroll = session.createSQLQuery("").scroll();
	    
	}
	
    
    
    private Long countByCondition(Map<String,Object> params){
    	CriteriaBuilder cb = this.em.getCriteriaBuilder();
    	CriteriaQuery<Long> cq=cb.createQuery(Long.class);
    	Root<UserAuditLog> root=cq.from(UserAuditLog.class);
    	cq.select(cb.count(root));
    	List<Predicate> predicates=buildPridicate(params,root,cb);
    	if(!predicates.isEmpty()){    	
    		cq.where(predicates.toArray(new Predicate[0]));
    	}
    	
    	return this.applyParameters(params, this.em.createQuery(cq)).getSingleResult();
    }
    
    private <T>TypedQuery<T> applyParameters(Map<String,Object> params,TypedQuery<T> q){
    	Set<String> keys = params.keySet();
    	Iterator<String> iterator = keys.iterator();
    	while(iterator.hasNext()){
    	    String key = iterator.next();
    	    q.setParameter(key,params.get(key));
    	}
    	return q;
    }
    
    
    /**
     * 
     * @param params
     * @param cb
     * @return
     */
    private List<Predicate> buildPridicate(Map<String,Object> params,Root<UserAuditLog> root,CriteriaBuilder cb){
    	List<Predicate> list = new ArrayList<Predicate>();
    	if(params.containsKey("message")){
    		ParameterExpression<String> p=cb.parameter(String.class, "message");
    		 Expression<String> wp = cb.concat(cb.concat("%",p),"%");
    		 list.add(cb.like(root.<String>get("message"), wp));
    	}
    	return list;
    }
    
    
    
    

}
