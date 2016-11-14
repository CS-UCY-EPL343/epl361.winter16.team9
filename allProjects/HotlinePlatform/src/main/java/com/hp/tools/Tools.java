package com.hp.tools;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zgeorg03 on 11/14/16.
 */
public class Tools {

    /**
     *
     * @param path
     * @param description
     * @return
     */
    public static ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = Tools.class.getClass().getResource(path);
        System.out.println(imgURL);
        if (imgURL != null) {
            return new ImageIcon(new ImageIcon(imgURL, description).getImage().getScaledInstance(32,32, Image.SCALE_SMOOTH));
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
