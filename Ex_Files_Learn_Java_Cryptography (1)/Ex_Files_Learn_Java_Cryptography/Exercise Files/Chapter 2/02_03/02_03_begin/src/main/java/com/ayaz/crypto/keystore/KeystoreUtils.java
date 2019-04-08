package com.ayaz.crypto.keystore;

import javax.crypto.SecretKey;
import java.security.KeyStore;

public class KeystoreUtils {

    private static final String SECRET_KEY_KEYSTORE_TYPE = "JCEKS";

    public static KeyStore createPrivatekeyJavaKeyStore(String keyStorePassword, String keyAlias, SecretKey secretKey, String secretKeyPssword) throws Exception {
        KeyStore keyStore = KeyStore.getInstance(SECRET_KEY_KEYSTORE_TYPE);
        keyStore.load(null, keyStorePassword.toCharArray());
        KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(secretKeyPssword.toCharArray());
        KeyStore.SecretKeyEntry privateKeyEntry = new KeyStore.SecretKeyEntry(secretKey);
        keyStore.setEntry(keyAlias, privateKeyEntry, entryPassword);
        return keyStore;
    }
}
