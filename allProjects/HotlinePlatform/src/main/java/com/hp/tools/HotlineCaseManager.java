package com.hp.tools;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zgeorg03 on 11/14/16.
 */
public class HotlineCaseManager {

    private final String casesPath;


    public HotlineCaseManager(String casesPath) {
        this.casesPath = casesPath;
    }

    public List<EncryptedCase> findNewCases(){
        List<EncryptedCase> newCases = new LinkedList<>();
        File fp = new File(casesPath);
        for(File f : fp.listFiles()) {
            long time = f.lastModified()/1000;
            newCases.add(new EncryptedCase(f.getName(),time));
        }
        Collections.sort(newCases,(x1,x2)-> (x1.getTimestamp()<x2.getTimestamp())
                ?-1:(x1.getTimestamp()>x2.getTimestamp()?1:0));
        return newCases;
    }
}
