package com.github.sawied.microservice.authorization.config;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import org.springframework.context.annotation.Configuration;

@Configuration
public class OauthApplicaionRootConfig {

	//private Resource rasPrivateKey = new ClassPathResource("github/sawied/microservice/key/pkcs8_privateKey.pem");
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(OauthApplicaionRootConfig.class);
	
	
	//@Bean
	public KeyPair signerKeyPair() throws NoSuchAlgorithmException, IOException, InvalidKeySpecException{
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048, new SecureRandom());
		return  keyGen.generateKeyPair();
	}
	
	
}
