package com.ayaz.crypto.keystore;

import com.ayaz.crypto.symmetric.SymmetricEncryptionUtils;
import org.junit.jupiter.api.Test;
import sun.security.tools.KeyStoreUtil;

import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

import java.security.KeyStore;

import static org.junit.jupiter.api.Assertions.*;

class KeystoreUtilsTest {

    @Test
    void createPrivatekeyJavaKeyStore() throws Exception {
        SecretKey secretKey = SymmetricEncryptionUtils.createAESKey();
        String secertKeyHex = DatatypeConverter.printHexBinary(secretKey.getEncoded());
        KeyStore keyStore = KeystoreUtils.createPrivatekeyJavaKeyStore("password", "foo", secretKey, "keyPassword");
        assertNotNull(keyStore);

        keyStore.load(null, "password".toCharArray());
        KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection("keyPassword".toCharArray());
        KeyStore.SecretKeyEntry resultEntry = (KeyStore.SecretKeyEntry) keyStore.getEntry("foo", entryPassword);
        SecretKey result = resultEntry.getSecretKey();
        String resultKeyHex = DatatypeConverter.printHexBinary(result.getEncoded());

        assertEquals(secertKeyHex, resultKeyHex);

    }
}