package com.hp.main;

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

        SwingUtilities.invokeAndWait( () -> {

            HotlineLoginFrame loginFrame = new HotlineLoginFrame(200,280);
            loginFrame.setVisible(true);

        });

    }
}
