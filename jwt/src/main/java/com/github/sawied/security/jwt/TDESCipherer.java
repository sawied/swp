package com.github.sawied.security.jwt;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.Cipher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

/**
 * Provide encryption or decryption service using RSA
 * @author DANAN
 *
 */
public class TDESCipherer {
	
	private static final Logger LOG=LoggerFactory.getLogger(TDESCipherer.class);

	private static final String KEYSTORE_TYPE = "jceks";

	private static final String  ALGORITHM ="DESede";
	
	private static final String CIPHER_ALGORITHM=ALGORITHM+"/"+"ECB"+"/"+"PKCS5Padding";
	
	//@Value("${keystore.path}")
	private Resource keystoreResource=null;
	
	@Value("${keystore.password}")
	private String password =null;
	
	@Value("${keystore.alias}")
	private String alias =null;
	
	private Key getKey() throws Exception{
		try {
			KeyStore keystore = KeyStore.getInstance(KEYSTORE_TYPE);
			
			InputStream inputStream = keystoreResource.getInputStream();
			keystore.load(inputStream, password.toCharArray());
			
			return keystore.getKey(alias, password.toCharArray());	
			
		} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException | UnrecoverableKeyException e) {
				LOG.error("some error occured while get Desede key");
				throw e;
		}
		
	}
	
		public byte[] encrypt(byte[] data) throws Exception{
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, getKey());
			return cipher.doFinal(data);
		}
		
		
		public byte[] decrypt(byte[] data) throws Exception{
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, getKey());
			return cipher.doFinal(data);
		}

		public  void setKeystoreResource(Resource keystoreResource) {
			this.keystoreResource = keystoreResource;
		}

		public Resource getKeystoreResource() {
			return keystoreResource;
		}
		
		
		
}
	


