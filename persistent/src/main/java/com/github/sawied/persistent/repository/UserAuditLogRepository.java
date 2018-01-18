package com.github.sawied.persistent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.sawied.persistent.domain.UserAuditLog;

@Repository
public interface UserAuditLogRepository extends PagingAndSortingRepository<UserAuditLog, Long>, UserAuditLogRepositoryCustom {

	
	@Query(nativeQuery=true,value="select id,code,message,starttimestamp,endtimestamp,userId from userAuditLog where code=:code")
	List<UserAuditLog> searchLastAuditLog(@Param("code") String code);
	
}
