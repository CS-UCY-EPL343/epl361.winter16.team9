package com.cmsl.security;

import javax.crypto.Cipher;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public class Keys {


    /**
     * Generate New Keys
     *
     * @param fileName
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static boolean generateKeys(String fileName) throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        gen.initialize(2048);
        KeyPair pair = gen.generateKeyPair();
        FileOutputStream ospvt = new FileOutputStream(fileName + "-prv.der");
        try {
            ospvt.write(pair.getPrivate().getEncoded());
            ospvt.flush();
        } finally {
            ospvt.close();
        }
        FileOutputStream ospub = new FileOutputStream(fileName + "-pub.der");
        try {
            ospub.write(pair.getPublic().getEncoded());
            ospub.flush();
        } finally {
            ospub.close();
        }
        return true;
    }

    public static KeyPair loadKeyPair(String path) throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, InvalidKeySpecException {
        //get the private key
        File file = new File(path+"-prv.der");
        FileInputStream fis = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int) file.length()];
        dis.readFully(keyBytes);
        dis.close();
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privateKey =  kf.generatePrivate(spec);

        //get the public key
        file = new File(path+"-pub.der");
        fis = new FileInputStream(file);
        dis = new DataInputStream(fis);
        keyBytes = new byte[(int) file.length()];
        dis.readFully(keyBytes);
        dis.close();
        X509EncodedKeySpec spec1 = new X509EncodedKeySpec(keyBytes);
        kf = KeyFactory.getInstance("RSA");
        PublicKey publicKey =  kf.generatePublic(spec1);
        return new KeyPair(publicKey,privateKey);

    }
    public static byte[] encrypt(PublicKey pubkey, String text) {
        try {
            Cipher rsa;
            rsa = Cipher.getInstance("RSA");
            rsa.init(Cipher.ENCRYPT_MODE, pubkey);
            return rsa.doFinal(text.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String decrypt(PrivateKey decryptionKey, byte[] buffer) {
        try {
            Cipher rsa;
            rsa = Cipher.getInstance("RSA");
            rsa.init(Cipher.DECRYPT_MODE, decryptionKey);
            byte[] utf8 = rsa.doFinal(buffer);
            return new String(utf8, "UTF8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
