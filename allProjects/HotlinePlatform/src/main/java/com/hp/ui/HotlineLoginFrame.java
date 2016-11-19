package com.hp.ui;

import com.cmsl.db.DBConnection;
import com.cmsl.db.entities.Operator;
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


    }


    @Override
    public boolean login() {

        String username = getUsername();
        String password = getPassword();
        int code = operatorService.authenticate(username,password);
        switch(code){
            case 0:
                System.out.println("User Authenticated!");
                Operator operator = operatorService.getOperator(username);
                HotlinePlatformFrame hotlinePlatformFrame = new HotlinePlatformFrame("./data/hotline/cases/",operator);
                hotlinePlatformFrame.setVisible(true);
                this.setVisible(false);
                return true;
            case 1:
                System.out.println("User not found!");
                clearUsername();
                clearPassword();
                JOptionPane.showMessageDialog(this,"User not found!","Error",JOptionPane.INFORMATION_MESSAGE);
                return false;
            case 2:
                System.out.println("Password doesn't match!");
                clearPassword();
                JOptionPane.showMessageDialog(this,"Your password is wrong!","Error",JOptionPane.INFORMATION_MESSAGE);
                return false;
        }

        return false;
    }
}
