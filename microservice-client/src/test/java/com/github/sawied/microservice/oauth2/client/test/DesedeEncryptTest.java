package com.github.sawied.microservice.oauth2.client.test;

import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DesedeEncryptTest {

	private Resource ibm_keystore_resource = new ClassPathResource("sawied/microservice/client/key/keystore_IBM.jks");
	
	private Resource sun_keystore_resource = new ClassPathResource("sawied/microservice/client/key/keystore_SUN.jks");
	
	private String str ="lONSLJ6KnX9dQO/3C1cOhikHa7qJro/c";
	
	
	@Test
	public void samekeyTest() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException {
		KeyStore keyStore = KeyStore.getInstance("jceks");
		keyStore.load(sun_keystore_resource.getInputStream(), "212121_vtm_keystore_password_121212".toCharArray());
		Key key = keyStore.getKey("vtm_logon_encrypt_pk", "101010_vtm_key_password_010101".toCharArray());
		System.out.println(Base64.encodeBase64String(key.getEncoded()));
		
		
		
	}
	
}
