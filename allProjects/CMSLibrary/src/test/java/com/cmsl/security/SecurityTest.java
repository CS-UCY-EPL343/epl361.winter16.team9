package com.cmsl.security;

import org.junit.Test;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public class SecurityTest {

    @Test
    public void createHash256Test(){
        String input ="test";
        String hash = Security.createHash256(input);
        assert "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08".equals(hash);
    }

    @Test
    public void generateRandomSaltTest(){
        String rnd = Security.generateSalt();
        assert true;
    }
}
