package com.ayaz.crypto.asymmetric;

import org.junit.jupiter.api.Test;

import javax.xml.bind.DatatypeConverter;
import java.security.KeyPair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AsymmetricEncryptionUtilsTest {

    @Test
    void generateRSAKeyPair() throws Exception {
        KeyPair keyPair = AsymmetricEncryptionUtils.generateRSAKeyPair();
        assertNotNull(keyPair);
        System.out.println("Private Key:"+ DatatypeConverter.printHexBinary(keyPair.getPrivate().getEncoded()));
        System.out.println("Public Key:   "+DatatypeConverter.printHexBinary(keyPair.getPublic().getEncoded()));
    }

    @Test
    void testRSACryptoRouiene() throws Exception {
        KeyPair keyPair = AsymmetricEncryptionUtils.generateRSAKeyPair();
        String plainText = "This is the text we are going to hide in plain sight";
        byte[] cipherText = AsymmetricEncryptionUtils.performRSAEncryption(plainText, keyPair.getPrivate());
        System.out.println("Cipher Text="+DatatypeConverter.printHexBinary(cipherText));

        String text = AsymmetricEncryptionUtils.performRSADecryption(cipherText, keyPair.getPublic());
        assertEquals(plainText, text);

    }
}