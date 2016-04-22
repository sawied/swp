package com.danan.util.encryption;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

import org.junit.Assert;
import org.junit.Test;

public class AESEncrptionTest {

    private static final String ALGORITHM = "AES";

    private static final int KEY_SIZE = 128;

    private static final String AES_CBC_PKCS5_PADDING = "AES/CBC/PKCS5Padding";

    @Test
    public void AESInitTest() {
        try {

            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            Assert.assertNotNull(keyGenerator);
            keyGenerator.init(KEY_SIZE);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
