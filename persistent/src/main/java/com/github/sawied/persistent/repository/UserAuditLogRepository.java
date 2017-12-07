package com.github.sawied.persistent.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.github.sawied.persistent.domain.UserAuditLog;

@Repository
public interface UserAuditLogRepository extends PagingAndSortingRepository<UserAuditLog, Long>, UserAuditLogRepositoryCustom {

}
