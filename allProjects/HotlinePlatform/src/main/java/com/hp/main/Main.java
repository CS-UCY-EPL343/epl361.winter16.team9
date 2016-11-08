package com.hp.main;

import com.cmsl.db.DBConnection;
import com.hp.ui.HotlineLoginFrame;
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

        try {
            DBConnection connection = new DBConnection("localhost","hotline","team9","Epl361project!");
        SwingUtilities.invokeAndWait( () -> {

            HotlineLoginFrame loginFrame = new HotlineLoginFrame(200,280,connection);
            loginFrame.setVisible(true);

        });
        } catch (Exception e) {
            System.err.println("Failed to connect to Hotline Database");
            return;
        }

    }
}
