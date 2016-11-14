package com.hp.ui;

import com.hp.tools.EncryptedCase;
import com.hp.tools.HotlineCaseManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by zgeorg03 on 11/14/16.
 */
public class HotlinePlatformFrame extends  JFrame{

    private final HotlineCaseManager caseManager;

    private final JPanel mainPanel = new JPanel(new BorderLayout());
    private final JPanel bottomPanel = new JPanel(new GridLayout(1,2,12,0));
    private final JButton evaluateCase = new JButton("Evaluate");
    private final JButton sendToPolice = new JButton("Send to Police");
    private final JButton discard = new JButton("Discard");


    private final JPanel newCases = new JPanel(new BorderLayout());
    private boolean newCasesLoaded;


    private EncryptedCase selectedEncryptedCase;

    public HotlinePlatformFrame(String casesPath){
        super("Hotline Platform");

        JMenuBar menuBar = new JMenuBar();
        caseManager = new HotlineCaseManager(casesPath);

        TitledBorder newCasesTitle = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"New Cases");
        TitledBorder pendingCasesTitle = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Pending Cases");
        TitledBorder casesTitle = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Case Details");

        JPanel pendingCases = new JPanel();

        JPanel sidebar = new JPanel(new GridLayout(2,1));
        sidebar.setPreferredSize(new Dimension(240,240));

        newCases.setBorder(newCasesTitle);
        pendingCases.setBorder(pendingCasesTitle);
        mainPanel.setBorder(casesTitle);


        sidebar.add(newCases);
        sidebar.add(pendingCases);
        this.getContentPane().add(sidebar,BorderLayout.WEST);
        this.getContentPane().add(mainPanel,BorderLayout.CENTER);



        menuBar.add(new JSeparator(SwingConstants.VERTICAL));


        evaluateCase.setEnabled(false);
        sendToPolice.setEnabled(false);
        discard.setEnabled(false);

        bottomPanel.add(evaluateCase);
        bottomPanel.add(sendToPolice);
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);


        Dimension dimension = new Dimension(720,540);
        setMinimumSize(dimension);
        setSize(dimension);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(menuBar);
        pack();

        new Thread(new NewCasesMonitor()).start();
    }


    /**
     *
     */
    public  class NewCasesMonitor implements Runnable{
        private java.util.List<EncryptedCase> old = new LinkedList();

        private boolean isChanged(java.util.List<EncryptedCase> newCases){
            if(old.isEmpty() || newCases.isEmpty())
                return true;

            if(old.size()!= newCases.size())
                return true;

            for(int i=0;i< old.size();i++){
                EncryptedCase x1 = old.get(i);
                EncryptedCase x2 = newCases.get(i);
                if(!x1.getId().equals(x2.getId()))
                    return true;
            }
            return false;
        }

        @Override
        public void run() {
            while(true) {
                java.util.List<EncryptedCase> list = caseManager.findNewCases();
                if(isChanged(list)) {
                    EncryptedCase array[] = new EncryptedCase[list.size()];
                    list.toArray(array);
                    this.old = list;
                    JList<EncryptedCase> jList = new JList<>(array);
                    JScrollPane scrollPane = new JScrollPane(jList);
                    scrollPane.setMinimumSize(new Dimension(240, 240));
                    if (newCasesLoaded)
                        newCases.remove(0);
                    newCasesLoaded = true;
                    newCases.add(scrollPane, BorderLayout.CENTER);
                    newCases.updateUI();

                    jList.addListSelectionListener(e -> {
                        if(e.getValueIsAdjusting())
                            return;
                        selectedEncryptedCase = jList.getSelectedValue();
                        if(selectedEncryptedCase==null)
                            return;
                        jList.setEnabled(false);
                        evaluateCase.setEnabled(true);
                    });
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }
    }
}
