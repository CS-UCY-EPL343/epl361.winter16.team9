package com.hp.main;

import com.cmsl.db.DBConnection;
import com.hp.ui.HotlineLoginFrame;
import com.hp.ui.HotlinePlatformFrame;
import com.sun.javafx.event.EventQueue;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by zgeorg03 on 11/7/16.
 */
public class Main {


    /**
     *
     * @param args
     */
    public static void main(String args[]) throws InvocationTargetException, InterruptedException {

        String path = "data/reports/";

        try {
            DBConnection connection = new DBConnection("localhost","hotline","team9","Epl361project!");

            SwingUtilities.invokeAndWait( () -> {

                //HotlinePlatformFrame platformFrame = new HotlinePlatformFrame(path+"cases/");
                //platformFrame.setVisible(true);

                HotlineLoginFrame loginFrame = new HotlineLoginFrame(200,280,connection);
                loginFrame.setVisible(true);

            });
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to connect to Hotline Database");
            System.exit(1);
        }

    }
}
