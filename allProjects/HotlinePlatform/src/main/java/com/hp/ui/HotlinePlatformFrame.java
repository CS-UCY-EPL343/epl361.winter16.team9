package com.hp.ui;

import com.cmsl.db.entities.Operator;
import com.cmsl.entities.CaseDetails;
import com.hp.tools.EncryptedCase;
import com.hp.tools.HotlineCaseManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * Created by zgeorg03 on 11/14/16.
 */
public class HotlinePlatformFrame extends  JFrame{

    private enum State{
        NOTHING, SELECTED_NEW_CASE,SELECTED_PENDING_CASE, EVALUATING
    }
    private State currentState;

    private final HotlineCaseManager caseManager;
    private final Operator operator;

    private final JPanel mainPanel = new JPanel(new BorderLayout());
    private final JPanel bottomPanel = new JPanel(new GridLayout(1,2,12,0));
    private final JButton evaluateCase = new JButton("Evaluate");
    private final JButton sendToPolice = new JButton("Send to Police");
    private final JButton discard = new JButton("Discard");
    private final JButton close = new JButton("Close");


    private final JPanel newCases = new JPanel(new BorderLayout());
    private JList<EncryptedCase> jListNewCases;
    private boolean newCasesLoaded;

    private final JPanel pendingCases = new JPanel(new BorderLayout());
    private JList<EncryptedCase> jListPendingCases;
    private boolean pendingCasesLoaded;
    private boolean firstEvaluationHappend;


    private EncryptedCase selectedEncryptedCase;
    private CaseDetails selectedCaseDetails;

    public HotlinePlatformFrame(String casesPath, Operator operator){
        super("Hotline Platform");
        currentState= State.NOTHING;
        this.operator = operator;

        JMenuBar menuBar = new JMenuBar();
        caseManager = new HotlineCaseManager(casesPath);



        TitledBorder newCasesTitle = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"New Cases");
        TitledBorder pendingCasesTitle = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Pending Cases");
        TitledBorder casesTitle = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Case Details");


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
        close.setEnabled(false);

        bottomPanel.add(evaluateCase);
        bottomPanel.add(sendToPolice);
        bottomPanel.add(discard);
        bottomPanel.add(close);
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);


        Dimension dimension = new Dimension(720,540);
        setMinimumSize(dimension);
        setSize(dimension);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(menuBar);
        pack();

        new Thread(new NewCasesMonitor()).start();
        new Thread(new PendingCasesMonitor()).start();


        evaluateCase.addActionListener(e -> {
            currentState=State.EVALUATING;
            evaluateCase.setEnabled(false);
            sendToPolice.setEnabled(true);
            discard.setEnabled(true);
            showCase();
        });

        sendToPolice.addActionListener(e -> sendToPolice());


        close.addActionListener(e->{
            mainPanel.remove(1);
            mainPanel.remove(1);
            mainPanel.updateUI();
            currentState = State.NOTHING;
            close.setEnabled(false);
            jListPendingCases.clearSelection();
            jListPendingCases.setEnabled(true);
            jListNewCases.setEnabled(true);
            firstEvaluationHappend=false;
        });
    }

    private void sendToPolice() {
        if(State.NOTHING == currentState)
            return;

        String path= selectedEncryptedCase.getPath();
        File file = new File(path);
        String parent = file.getParent();
        String newName = "pending_" + file.getName().substring(4);
        file.renameTo(Paths.get(parent,newName).toFile());
        mainPanel.remove(1);
        mainPanel.remove(1);
        mainPanel.updateUI();
        currentState = State.NOTHING;
        firstEvaluationHappend=false;
        JOptionPane.showMessageDialog(this,"The case has been sent to police","Success",JOptionPane.INFORMATION_MESSAGE);



    }


    /**
     * Evaluate Case
     */
    private void showCase() {
        try {
            selectedCaseDetails = selectedEncryptedCase.decryptCase(operator);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"Case not found! Make sure that is not deleted","Error",JOptionPane.INFORMATION_MESSAGE);
            currentState = State.NOTHING;
            sendToPolice.setEnabled(false);
            discard.setEnabled(false);

            return;
        }

        JPanel grid = new JPanel(new GridLayout(9,9,5,5));
        JLabel lblTopic = new JLabel("Topic:");
        JLabel txtTopic = new JLabel(selectedCaseDetails.getTopic());
        txtTopic.setForeground(Color.BLUE);
        grid.add(lblTopic);
        grid.add(txtTopic);

        JLabel lblUrl = new JLabel("\tUrl:");
        JLabel txtUrl = new JLabel(selectedCaseDetails.getUrl_link());
        txtUrl.setForeground(Color.BLUE);
        grid.add(lblUrl);
        grid.add(txtUrl);

        JLabel lblName = new JLabel("\tName:");
        JLabel txtName = new JLabel(selectedCaseDetails.getName());
        txtName.setForeground(Color.BLUE);
        grid.add(lblName);
        grid.add(txtName);

        JLabel lblSurname = new JLabel("\tSurname:");
        JLabel txtSurname = new JLabel(selectedCaseDetails.getSurname());
        txtSurname.setForeground(Color.BLUE);
        grid.add(lblSurname);
        grid.add(txtSurname);

        JLabel lblEmail = new JLabel("\tEmail:");
        JLabel txtEmail = new JLabel(selectedCaseDetails.getEmail());

        txtEmail.setForeground(Color.BLUE);
        grid.add(lblEmail);
        grid.add(txtEmail);

        JLabel lblAge = new JLabel("\tAge:");
        JLabel txtAge = new JLabel(selectedCaseDetails.getAge());
        txtAge.setForeground(Color.BLUE);
        grid.add(lblAge);
        grid.add(txtAge);

        JLabel lblAddress = new JLabel("\tAddress:");
        JLabel  txtAddress = new JLabel(selectedCaseDetails.getAddress());
        txtAddress.setForeground(Color.BLUE);
        grid.add(lblAddress);
        grid.add(txtAddress);

        JLabel lblCity = new JLabel("\tCity:");
        JLabel  txtCity = new JLabel(selectedCaseDetails.getCity());
        txtCity.setForeground(Color.BLUE);
        grid.add(lblCity);
        grid.add(txtCity);

        JLabel lblCountry = new JLabel("\tCountry:");
        JLabel txtCountry = new JLabel(selectedCaseDetails.getCountry());
        txtCountry.setForeground(Color.BLUE);
        grid.add(lblCountry);
        grid.add(txtCountry);

        JTextArea textArea = new JTextArea(selectedCaseDetails.getComments());
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        JScrollPane comments = new JScrollPane(textArea);
        if(firstEvaluationHappend) {
            mainPanel.remove(1);
            mainPanel.remove(1);
        }
        firstEvaluationHappend = true;

        mainPanel.add(grid,BorderLayout.NORTH);
        mainPanel.add(comments,BorderLayout.CENTER);
        mainPanel.updateUI();


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
                    jListNewCases = new JList<>(array);
                    JScrollPane scrollPane = new JScrollPane(jListNewCases);
                    scrollPane.setMinimumSize(new Dimension(240, 240));
                    if (newCasesLoaded)
                        newCases.remove(0);
                    newCasesLoaded = true;
                    newCases.add(scrollPane, BorderLayout.CENTER);
                    newCases.updateUI();

                    if(currentState==State.SELECTED_NEW_CASE || currentState== State.SELECTED_PENDING_CASE) {
                        jListNewCases.setEnabled(false);
                        jListNewCases.setSelectedValue(selectedEncryptedCase,true);
                    }

                    jListNewCases.addListSelectionListener(e -> {
                        if(e.getValueIsAdjusting())
                            return;
                        selectedEncryptedCase = jListNewCases.getSelectedValue();
                        if(selectedEncryptedCase==null)
                            return;
                        currentState = State.SELECTED_NEW_CASE;
                        jListNewCases.setEnabled(false);
                        jListPendingCases.setEnabled(false);
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

    public  class PendingCasesMonitor implements Runnable{
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
                java.util.List<EncryptedCase> list = caseManager.findPendingCases();


                if(isChanged(list)) {
                    EncryptedCase array[] = new EncryptedCase[list.size()];
                    list.toArray(array);
                    this.old = list;
                    jListPendingCases = new JList<>(array);
                    JScrollPane scrollPane = new JScrollPane(jListPendingCases);
                    scrollPane.setMinimumSize(new Dimension(240, 240));
                    if (pendingCasesLoaded)
                        pendingCases.remove(0);
                    pendingCasesLoaded = true;
                    pendingCases.add(scrollPane, BorderLayout.CENTER);
                    pendingCases.updateUI();

                    if(currentState==State.SELECTED_NEW_CASE || currentState== State.SELECTED_PENDING_CASE) {
                        jListPendingCases.setEnabled(false);
                        jListPendingCases.setSelectedValue(selectedEncryptedCase,true);
                    }

                    jListPendingCases.addListSelectionListener(e -> {
                        if(e.getValueIsAdjusting())
                            return;
                        selectedEncryptedCase = jListPendingCases.getSelectedValue();
                        if(selectedEncryptedCase==null)
                            return;
                        currentState = State.SELECTED_PENDING_CASE;
                        jListPendingCases.setEnabled(false);
                        jListNewCases.setEnabled(false);
                        close.setEnabled(true);
                        showCase();
                        //showCase.setEnabled(true);
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
