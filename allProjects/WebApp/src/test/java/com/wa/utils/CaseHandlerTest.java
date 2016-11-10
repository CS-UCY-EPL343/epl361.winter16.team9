package com.wa.utils;

import org.junit.Test;

import java.io.File;

/**
 * Created by zgeorg03 on 11/10/16.
 */
public class CaseHandlerTest {

    @Test
    public void createCaseTest(){
        CaseHandler caseHandler = new CaseHandler(new File("./"));
        caseHandler.newCase("test1");
    }
}
