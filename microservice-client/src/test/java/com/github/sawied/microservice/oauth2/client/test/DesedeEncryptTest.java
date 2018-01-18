package com.github.sawied.microservice.oauth2.client.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStore.SecretKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DesedeEncryptTest {

	private static final String PASSWORD = "hacn1234";
	
	 public static final String KEY_ALGORITHM="DESede";  
	
	private static final String KEYALG="DESede/ECB/PKCS5Padding";

	private Resource ibm_keystore_resource = new ClassPathResource("sawied/microservice/client/key/keystore_IBM.jks");
	
	private Resource keystore_resource = new ClassPathResource("sawied/microservice/client/key/keystore.p12");
	
	private Resource sun_keystore_resource = new ClassPathResource("sawied/microservice/client/key/key.jceks");
	
	
	private byte[] secureKey= new byte[] {21, 47, -15, 32, -108, -27, -122, 107, -63, 61, -33, -85, -83, -123, 62, -60, -92, 81, -125, 35, -108, -29, 2, -105};
	
	//private String str ="lONSLJ6KnX9dQO/3C1cOhikHa7qJro/c";
	
	
	@Test
	public void samekeyTest() throws Exception {
		KeyStore keyStore = KeyStore.getInstance("jceks");
		keyStore.load(null,null);
		SecretKeyEntry keyEntry = new KeyStore.SecretKeyEntry((SecretKey) toKey(this.secureKey));
		char[] password = PASSWORD.toCharArray();
	    KeyStore.ProtectionParameter protParam = 
	    new KeyStore.PasswordProtection(password);
	    keyStore.setEntry("client-key", keyEntry, protParam);
		
		FileOutputStream stream = new FileOutputStream("D:/works/sawied/key.p12");
		keyStore.store(stream, PASSWORD.toCharArray());
		stream.close();
	}
	
	@Test
	public void encryptStrTest() throws Exception {
		
	    KeyStore keyStore = KeyStore.getInstance("jceks");
	    
		keyStore.load(sun_keystore_resource.getInputStream(), "hacn1234".toCharArray());
		Key key = keyStore.getKey("client-key", "hacn1234".toCharArray());
		Cipher cipher=Cipher.getInstance(KEYALG);
		cipher.init(Cipher.DECRYPT_MODE,key);
		String result=new String((cipher.doFinal(Base64.decodeBase64("irUJGfa+Nq5sX4TOVZyZCxEtB4NiZ8dg/+lphsNt24c="))));
		System.out.println(result);
		
	}
	
	
    /** 
     * 转换密钥 
     * @param key 二进制密钥 
     * @return Key 密钥 
     * */  
    public static Key toKey(byte[] key) throws Exception{  	
    	SecretKey deskey = new SecretKeySpec(key, KEY_ALGORITHM);
        return deskey;  
    }  
    
	
	
}
