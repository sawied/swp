package com.danan.business.smot.util;

import java.io.File;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

/**
 * This class be used to generate key pair for RSA encryption.
 * 
 * @author DANAN
 * 
 */
public class KeyGen {

	private final static Map<String, String> msg = new HashMap<String, String>();
	
	private static final String CURRENT_PATH=System.getProperty("user.dir"); 
	
	private static final String DEFAULT_NAME="KeyPair.jks";
	
	private static final File OUT= new File(CURRENT_PATH,DEFAULT_NAME);
	
	private static final File pass1= new File(CURRENT_PATH,"pass1");
	
	private static final File pass2 =new File(CURRENT_PATH,"pass2");

	static {
		msg.put("-help", "Usage:java -jar keyGen");
		msg.put("confirm",
				"Keygen will use following information to generate the key pair:\n"
				+ "Out put directory:" + OUT.getAbsolutePath() +"\n"
				+ "Password1:"+ pass1.getAbsolutePath() +"\n"
				+ "Password2:"+ pass2.getAbsolutePath() +"\n"
				);

	}

	public static void main(String[] args) {

		for (int i = 0; i < args.length; i++) {
			if ("-help".equalsIgnoreCase(args[i])) {
				printMessage("-help");
			}
		}
		printMessage("confirm");
		generateKeyPair();
	}

	/**
	 * Generate key pair
	 */
	private static void generateKeyPair() {
		try {
			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
			SecureRandom random = new SecureRandom();
			keyGenerator.initialize(2048, random);
			KeyPair keyPair = keyGenerator.genKeyPair();
			PrivateKey privateKey= keyPair.getPrivate();
			
			
			
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	private static void printMessage(String key) {
		System.out.println(msg.get(key));
	}

}
