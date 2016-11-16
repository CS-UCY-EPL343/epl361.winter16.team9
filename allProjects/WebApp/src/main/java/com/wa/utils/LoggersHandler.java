package com.wa.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

/**
 * Created by zgeorg03 on 11/8/16.
 */
public class LoggersHandler {

    public Logger getRootLogger() {
        return rootLogger;
    }

    public Logger getHotlineLogger() {
        return hotlineLogger;
    }

    public Logger getHelplineLogger() {
        return helplineLogger;
    }

    public Logger getDescriptionLogger() {
        return descriptionLogger;
    }

    private final Logger rootLogger;
    private final Logger hotlineLogger;
    private final Logger helplineLogger;
    private final Logger descriptionLogger;

    public LoggersHandler(String base) throws IOException {
        Date date = new Date(System.currentTimeMillis());
        DateFormat df =new SimpleDateFormat("yyyy-MM-dd:hh:mm");
        String name = df.format(date)+".log";



        FileHandler fh = new FileHandler(base+"/log/" + name);
        FileHandler hotlineFh = new FileHandler(base+"reports/log/"+name);
        FileHandler helplineFh = new FileHandler(base+"helpline/log/"+name);
        FileHandler descriptionFh = new FileHandler(base+"description/log/"+name);

        fh.setFormatter(new MyFormatter());
        hotlineFh.setFormatter(new MyFormatter());
        helplineFh.setFormatter(new MyFormatter());
        descriptionFh.setFormatter(new MyFormatter());

        rootLogger = Logger.getLogger("/log/"+name);
        rootLogger.addHandler(fh);

        hotlineLogger = Logger.getLogger("reports/log/"+name);
        hotlineLogger.addHandler(hotlineFh);

        helplineLogger = Logger.getLogger("helpline/log/"+name);
        helplineLogger.addHandler(helplineFh);

        descriptionLogger = Logger.getLogger("description/log/"+name);
        descriptionLogger.addHandler(descriptionFh);
    }
}

class MyFormatter extends Formatter{
    @Override
    public String format(LogRecord record) {
        return "[" + record.getLevel().getName()+"]:\t"+record.getMillis() +":\t" + record.getMessage()+"\n";
    }
}
