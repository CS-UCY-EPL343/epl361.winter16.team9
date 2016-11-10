package com.cmsl.security;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public class KeysTest {


    @Test
    public void generateKeysTest() throws NoSuchProviderException, NoSuchAlgorithmException, IOException {
        File file = new File(System.getProperty("user.dir"));
        String name = file.getParent() + "/keys/test";
        assert Keys.generateKeys(name);
    }

    @Test
    public void loadKeysTest() throws InvalidKeySpecException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        File file = new File(System.getProperty("user.dir"));
        String name = file.getParent() + "/keys/test";
        KeyPair pair = Keys.loadKeyPair(name);
        String word= "Hello";
        byte encrypted[] = Keys.encrypt(pair.getPublic(),word);
        System.out.println(Security.encodeHex(encrypted));
        assert (Keys.decrypt(pair.getPrivate(),encrypted)).equals(word);

    }
}

