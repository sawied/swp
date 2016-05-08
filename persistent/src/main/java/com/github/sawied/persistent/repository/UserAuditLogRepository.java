package com.github.sawied.persistent.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.sawied.persistent.domain.UserAuditLog;

/**
 * 
 * @author DANAN
 *
 */
@Repository
public interface UserAuditLogRepository extends CrudRepository<UserAuditLog,Long> {

}
