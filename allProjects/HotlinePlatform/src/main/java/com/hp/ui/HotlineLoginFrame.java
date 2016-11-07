package com.hp.ui;

import com.cmsl.ui.LoginFrame;

import javax.swing.*;

/**
 * Created by zgeorg03 on 11/7/16.
 */
public class HotlineLoginFrame extends LoginFrame {

    /**
     *
     * @param width
     * @param height
     */
    public HotlineLoginFrame(int width, int height) {
        super("Hotline", width, height);

        bttn_sign_in.addActionListener(event ->{

        });

        bttn_exit.addActionListener(event ->{
            int ans = JOptionPane.showOptionDialog(this,"Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                    null,new String[]{"Yes","No"},"Yes");

            if(ans==0)
                System.exit(0);

        });

    }


}
