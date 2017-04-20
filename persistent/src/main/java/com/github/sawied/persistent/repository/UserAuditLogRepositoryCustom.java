package com.github.sawied.persistent.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.github.sawied.persistent.domain.SearchAuditResponse;
import com.github.sawied.persistent.domain.UserAuditLog;


public interface UserAuditLogRepositoryCustom {

	Page<UserAuditLog> searchUserLog(Map<String, Object> params, Pageable pageable);

	void exportLargeData();

	List<SearchAuditResponse> searchAuditUssScalar();

	List<SearchAuditResponse> searchAuditUseResultMapping();

}