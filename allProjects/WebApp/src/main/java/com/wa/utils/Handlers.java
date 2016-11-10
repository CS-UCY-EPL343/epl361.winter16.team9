package com.wa.utils;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public class Handlers {

    private  final DirectoriesHandler directoriesHandler;
    private  final LoggersHandler loggersHandler;

    public Handlers(String location) throws Exception {
        this.directoriesHandler = new DirectoriesHandler(location);
        this.loggersHandler = new LoggersHandler(location);
    }

    public DirectoriesHandler getDirectoriesHandler() {
        return directoriesHandler;
    }

    public LoggersHandler getLoggersHandler() {
        return loggersHandler;
    }
}
