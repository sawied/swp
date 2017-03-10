package com.github.sawied.persistent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.github.sawied.persistent.domain.UserAuditLog;

/**
 * 
 * @author DANAN
 *
 */
@Repository
public interface UserAuditLogRepository extends JpaRepository<UserAuditLog,Long>,JpaSpecificationExecutor<UserAuditLog> {

}
