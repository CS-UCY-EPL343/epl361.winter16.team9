package com.hp.ui;

import com.cmsl.db.DBConnection;
import com.cmsl.db.services.OperatorService;
import com.cmsl.ui.LoginFrame;

import javax.swing.*;

/**
 * Created by zgeorg03 on 11/7/16.
 */
public class HotlineLoginFrame extends LoginFrame {


    private final OperatorService operatorService;
    /**
     * @param width
     * @param height
     */
    public HotlineLoginFrame(int width, int height,DBConnection connection) {
        super("Hotline", width, height);
        operatorService = new OperatorService(connection);
        bttn_sign_in.addActionListener(event ->{

            String username = getUsername();
            String password = getPassword();
            int code = operatorService.authenticate(username,password);
            switch(code){
                case 0:
                    System.out.println("User Authenticated!");
                    break;
                case 1:
                    System.out.println("User not found!");
                    clearUsername();
                    clearPassword();
                    break;
                case 2:
                    System.out.println("Password doesn't match!");
                    clearPassword();
                    break;
            }

        });

        bttn_exit.addActionListener(event ->{
            int ans = JOptionPane.showOptionDialog(this,"Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                    null,new String[]{"Yes","No"},"Yes");

            if(ans==0)
                System.exit(0);

        });

    }


}
