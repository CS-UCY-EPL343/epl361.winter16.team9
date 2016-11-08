package com.cmsl.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zgeorg03 on 11/7/16.
 */
public class LoginFrame extends JFrame {

    private final JLabel lbl_username;
    private final JLabel lbl_password;
    private final JTextField txt_username;
    private final JPasswordField txt_password;
    protected final JButton bttn_sign_in;
    protected final JButton bttn_exit;

   public LoginFrame(String title,int width,int height){
       super(title);

       JPanel panel = new JPanel();
       panel.setLayout(new GridLayout(2,2));
       lbl_username = new JLabel("Username");
       lbl_password = new JLabel("Password");
       txt_username = new JTextField(16);
       txt_password = new JPasswordField(16);
       panel.add(lbl_username);
       panel.add(txt_username);
       panel.add(lbl_password);
       panel.add(txt_password);

       JPanel panelBottom = new JPanel();
       panelBottom.setLayout(new GridLayout(1,2));


       bttn_sign_in = new JButton("Sign In");
       bttn_exit = new JButton("Exit");
       panelBottom.add(bttn_exit);
       panelBottom.add(bttn_sign_in);

       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.add(panel,BorderLayout.CENTER);
       this.add(panelBottom,BorderLayout.SOUTH);
       this.setSize(width,height);
       this.pack();

   }

    public void clearUsername(){txt_username.setText("");}
    public void clearPassword(){txt_password.setText("");}

    /**
     * Get username
     * @return
     */
   public String getUsername(){
       return txt_username.getText().trim();
   }

    /**
     * Get password
     * @return
     */
    public String getPassword(){
        return new String(txt_password.getPassword());
    }

}
