package com.github.sawied.jwt.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * Provide encryption or decryption service using RSA
 * @author DANAN
 *
 */
public class TDESipherer {
	
	private static final Logger LOG=LoggerFactory.getLogger(TDESipherer.class);

	private static final String JKS = "JKS";

	private static final String  ALGORITHM ="DESede";
	
	private static final String CIPHER_ALGORITHM=ALGORITHM+"/"+"ECB"+"/"+"PKCS5Padding";
	
	@Value("${keystore.path}")
	private File keystorePath=null;
	
	@Value("${keystore.password}")
	private String password =null;
	
	@Value("${keystore.alias}")
	private String alias =null;
	
	private Key getKey() throws Exception{
		try {
			KeyStore keystore = KeyStore.getInstance(JKS);
			
			FileInputStream inputStream = new FileInputStream(keystorePath);
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
		
		
}
	


