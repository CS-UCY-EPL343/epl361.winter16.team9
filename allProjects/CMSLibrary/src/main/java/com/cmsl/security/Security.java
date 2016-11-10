package com.cmsl.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public class Security {


    /**
     * Encodes the given string int hex
     * @param digest
     * @return
     */
    public static String encodeHex(byte[] digest) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }


    /**
     * Create a hash256
     * @param input
     * @return
     */
    public static String createHash256(String input){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] buffer = input.getBytes("UTF-8");
            md.update(buffer);
            byte[] digest = md.digest();
            return encodeHex(digest);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
            return e.getMessage();
        }
    }

    /**
     * Generate a random Salt
     * @return
     */
    public static String generateSalt(){
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        byte bytes[] = new byte[64];
        random.nextBytes(bytes);
        String hexInput = encodeHex(bytes);
        return createHash256(hexInput);
    }
}
