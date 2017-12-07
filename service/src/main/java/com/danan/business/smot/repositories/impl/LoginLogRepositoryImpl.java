/**package com.danan.business.smot.repositories.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.danan.business.smot.domain.LoginLog;
import com.danan.business.smot.repositories.LoginLogRepository;



public class LoginLogRepositoryImpl implements LoginLogRepository {

	@Autowired
	private MongoTemplate mongoTemplate = null;

	
	public void saveLoginLog(LoginLog log) {
		mongoTemplate.updateMulti(new Query(Criteria.where("loginName").is(log.getLoginName())),new Update().inc("indexNo", -1), LoginLog.class);
		mongoTemplate.upsert(new Query(Criteria.where("loginName").is(log.getLoginName()).and("indexNo").is(-1)), new Update().set("indexNo",LoginLogRepository.MAX-1).set("loginTime", new Date()).set("address", log.getIpAddress()), LoginLog.class);
	}

	
	public List<LoginLog> queryUserLoginLog(String name) {
		Query query = new Query(Criteria.where("loginName").is(name));
		return mongoTemplate.find(query,LoginLog.class);
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
**/