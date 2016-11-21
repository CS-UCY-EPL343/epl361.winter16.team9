package com.wa.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public class DirectoriesHandler {

    private final File rootDirectory;
    private final File rootLoggerDirectory;

    private final File hotlineDirectory;
    private final File hotlineLoggerDirectory;
    private final File hotlineCasesDirectory;

    private final File helplineDirectory;
    private final File helplineLoggerDirectory;
    private final File helplineCasesDirectory;

    private final File descriptionDirectory;
    private final File descriptionLoggerDirectory;
    private final File descriptionCasesDirectory;

    public DirectoriesHandler(String location) throws Exception {

        rootDirectory = constructDirectory(location);
        rootLoggerDirectory = constructDirectory(location+"/log/");

        hotlineDirectory = constructDirectory(location+"hotline/");
        hotlineLoggerDirectory = constructDirectory(location+"hotline/log/");
        hotlineCasesDirectory = constructDirectory(location+"hotline/cases/");

        helplineDirectory = constructDirectory(location+"helpline/");
        helplineLoggerDirectory = constructDirectory(location+"helpline/log/");
        helplineCasesDirectory = constructDirectory(location+"helpline/cases/");

        descriptionDirectory = constructDirectory(location+"description/");
        descriptionLoggerDirectory = constructDirectory(location+"description/log/");
        descriptionCasesDirectory = constructDirectory(location+"description/cases/");

        Runtime.getRuntime().exec("chmod 777 -R "+ rootDirectory.getAbsolutePath());



    }

    public File constructDirectory(String location) throws Exception {
        File fp = new File(location);
        if(!fp.exists()){
            try {
                Files.createDirectory(fp.toPath());
                System.out.println("[Info] Created directory: " + fp.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Failed to create reports directory");
            }
        }else if(!fp.isDirectory()){
            System.err.println(location +" is not a directory");
            throw new Exception("Error");
        }
        return fp;
    }

    public File getHotlineCasesDirectory() {
        return hotlineCasesDirectory;
    }
}
