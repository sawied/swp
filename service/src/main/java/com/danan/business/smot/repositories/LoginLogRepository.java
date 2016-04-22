package com.danan.business.smot.repositories;



import java.util.List;

import com.danan.business.smot.domain.LoginLog;



/**
 *
 * @author danan
 *
 */
public interface LoginLogRepository {
	
	public static final int MAX=10;
	
	/**
	 *
	 * @param log
	 */
	void saveLoginLog(LoginLog log);
	
	List<LoginLog> queryUserLoginLog(String name);
	
}
