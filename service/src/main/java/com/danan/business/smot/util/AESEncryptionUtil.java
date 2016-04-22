package com.danan.business.smot.util;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

/**
 * <b>This class be used to implement AES Encryption/Decryption</b>
 * Created by danan on 2016/1/1.
 */
public class AESEncryptionUtil {

    private static final int KEY_SIZE = 128;

    private static final String ALGORITHM = "AES";

    private static final String MODE = "CBC";

    private static final String PADDING = "PKCS5Padding";

    private static final String AES_CBC_PKCS5Padding = ALGORITHM + "/" + MODE + "/" + PADDING;

    private int size = KEY_SIZE;

    public AESEncryptionUtil() {

    }

    /**
     * @param size the available key size is 128/192/256
     */
    public AESEncryptionUtil(int size) {
        if (size != 128 || size != 192 || size != 256) {
            throw new IllegalArgumentException("Invalid construct parameter " + size + ", The valid size is 128/192/256 ");
        }
        this.size = size;
    }

    public SecretKey generateSecretKey(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            keyGenerator.init(this.size);
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


}
