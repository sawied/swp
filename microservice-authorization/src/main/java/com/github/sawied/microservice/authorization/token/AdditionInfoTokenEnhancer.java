package com.github.sawied.microservice.authorization.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.github.sawied.microservice.authorization.userdetails.ExtentedUser;

public class AdditionInfoTokenEnhancer implements TokenEnhancer{

	private static final Logger LOGGER = LoggerFactory.getLogger(AdditionInfoTokenEnhancer.class);
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Object principal = authentication.getPrincipal();
		if(accessToken.getAdditionalInformation()!=null && principal instanceof ExtentedUser) {
			ExtentedUser user = (ExtentedUser) principal;
			if(user.getInadditionInfo()!=null) {				
				accessToken.getAdditionalInformation().putAll(user.getInadditionInfo());
				LOGGER.debug("user additionInfo added into access token : {}",user.getInadditionInfo());
			}
		}else {
			LOGGER.debug("principal is {} and accessToken is {} ,that don't match the condition to add addition info.",principal,accessToken);
		}
		return accessToken;
	}

}
