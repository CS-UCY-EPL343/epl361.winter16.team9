package com.cmsl.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by zgeorg03 on 11/7/16.
 */
public abstract class LoginFrame extends JFrame {

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

       txt_username.addKeyListener(new KeyAdapter() {
           public void keyPressed(KeyEvent e) {
               if(e.getKeyCode()==KeyEvent.VK_ENTER)
                   txt_password.requestFocus();
           }
       });
       txt_password.addKeyListener(new KeyAdapter() {
           public void keyPressed(KeyEvent e) {
               if(e.getKeyCode()==KeyEvent.VK_ENTER)
                   if(!login())
                       txt_username.requestFocus();
           }
       });
       panel.add(lbl_username);
       panel.add(txt_username);
       panel.add(lbl_password);
       panel.add(txt_password);

       JPanel panelBottom = new JPanel();
       panelBottom.setLayout(new GridLayout(1,2));


       bttn_sign_in = new JButton("Sign In");
       bttn_sign_in.addActionListener(x -> login());

       bttn_exit = new JButton("Exit");
       bttn_exit.addActionListener(event ->{
           int ans = JOptionPane.showOptionDialog(this,"Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
                   null,new String[]{"Yes","No"},"Yes");

           if(ans==0)
               System.exit(0);

       });
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

    /**
     * Login
     */
    public abstract boolean login();
}
