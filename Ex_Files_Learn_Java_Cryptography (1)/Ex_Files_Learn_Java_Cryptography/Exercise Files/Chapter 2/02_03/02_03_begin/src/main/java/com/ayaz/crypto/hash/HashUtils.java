package com.ayaz.crypto.hash;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class HashUtils {

    private static final String SHA2_ALFORITHM = "SHA-256";

    public static byte[] generateRandomSalt() {
        byte[] salt = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);
        return salt;
    }

    public static byte[] createSHA2Hash(String input, byte[] salt) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(salt);
        byteArrayOutputStream.write(input.getBytes());
        byte[] valueToHash = byteArrayOutputStream.toByteArray();

        MessageDigest messageDigest = MessageDigest.getInstance(SHA2_ALFORITHM);
        return messageDigest.digest(valueToHash);
    }
}
