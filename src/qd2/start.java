/*
 * All work contained within is subject to copyright.
 * (c)2018 
 * no work may be reproduced without prior consent.
 * All Rights Reserved.
 */
package qd2;

import java.awt.Color;
import java.awt.ItemSelectable;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import qd2.api.MyEvents;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JComboBox;
import javax.swing.JTable;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.impl.obj.Guild;
import sx.blah.discord.handle.impl.obj.User;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;

/**
 *
 * @author idiot
 */
public class start extends javax.swing.JFrame{

    
    public IDiscordClient cli = null;
    public IDiscordClient shrd = null;
    
    public boolean flag = false;                    // login flag, checks for username existance
    
    public Color amber = new Color(0xFAA61A);
    public Color green = new Color(0x43B581);
    public Color red = new Color(0xF04747);
    public Color text = new Color(0xBBBBA9);
    
    public List channelsList=null, messagesList=null, guildsList=null, usersList=null;
    private DefaultTableModel mModel;
    private DefaultTableModel qModel;
    public ArrayList<String> guildComboReply = null;
    public IGuild selectedGuild = null;
    public IUser selectedUser = null;
    public IChannel selectedChannel = null;
    public IMessage selectedMessage = null;
    
    
    
    /**
     * Creates new form start
     */
    public start() {
        
        initComponents();
        setupTables();
        listeners();                               // add table & combo listeners

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        loadPane = new javax.swing.JPanel();
        loginBut = new javax.swing.JButton();
        getBut = new javax.swing.JButton();
        loadPanel = new javax.swing.JScrollPane();
        displayText = new javax.swing.JTextArea();
        username = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        mssagesScroll = new javax.swing.JScrollPane();
        messageDisplay = new javax.swing.JTable();
        guildCombo = new javax.swing.JComboBox<>();
        guildLabel = new javax.swing.JLabel();
        channelLabel = new javax.swing.JLabel();
        channelCombo = new javax.swing.JComboBox<>();
        QPostPane = new javax.swing.JPanel();
        QPostSroll = new javax.swing.JScrollPane();
        qPostList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setToolTipText("First step");

        loginBut.setText("Log In");
        loginBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButActionPerformed(evt);
            }
        });

        getBut.setText("Load Tables");
        getBut.setEnabled(false);
        getBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getButActionPerformed(evt);
            }
        });

        displayText.setColumns(20);
        displayText.setRows(5);
        loadPanel.setViewportView(displayText);

        username.setText("MrScabby");
        username.setToolTipText("Enter your online Username");

        usernameLabel.setText("Username");

        mssagesScroll.setEnabled(false);

        messageDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        messageDisplay.setEnabled(false);
        mssagesScroll.setViewportView(messageDisplay);

        guildCombo.setEnabled(false);

        guildLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        guildLabel.setText("Guild");
        guildLabel.setEnabled(false);

        channelLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        channelLabel.setText("Channel");
        channelLabel.setEnabled(false);

        channelCombo.setEnabled(false);

        javax.swing.GroupLayout loadPaneLayout = new javax.swing.GroupLayout(loadPane);
        loadPane.setLayout(loadPaneLayout);
        loadPaneLayout.setHorizontalGroup(
            loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadPaneLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadPaneLayout.createSequentialGroup()
                        .addComponent(loadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadPaneLayout.createSequentialGroup()
                        .addComponent(loginBut, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(loadPaneLayout.createSequentialGroup()
                                .addComponent(usernameLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadPaneLayout.createSequentialGroup()
                                .addGroup(loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(loadPaneLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(channelLabel))
                                    .addGroup(loadPaneLayout.createSequentialGroup()
                                        .addComponent(username)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(guildLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(getBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(guildCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(channelCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)))
                .addComponent(mssagesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        loadPaneLayout.setVerticalGroup(
            loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loadPaneLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadPaneLayout.createSequentialGroup()
                        .addGroup(loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loginBut)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guildCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guildLabel))
                        .addGap(4, 4, 4)
                        .addGroup(loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(channelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(channelLabel))
                        .addGap(85, 85, 85)
                        .addComponent(getBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mssagesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Lock and Load", loadPane);

        qPostList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        QPostSroll.setViewportView(qPostList);

        javax.swing.GroupLayout QPostPaneLayout = new javax.swing.GroupLayout(QPostPane);
        QPostPane.setLayout(QPostPaneLayout);
        QPostPaneLayout.setHorizontalGroup(
            QPostPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QPostPaneLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(QPostSroll, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addGap(527, 527, 527))
        );
        QPostPaneLayout.setVerticalGroup(
            QPostPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QPostPaneLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(QPostSroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Take Aim", QPostPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButActionPerformed

        String loginButStatus = loginBut.getText();
        
        if(loginButStatus.length()<1) { return; }
        
            cli = null;
        
            cli = BotUtils.getBuiltDiscordClient("NDI2NDU4OTAzODgzMDIyMzU2.DZWXBg.GqluTwQt5yJvVoQZPFuklaksbsw");

            cli.getDispatcher().registerListener(new IListener<MessageReceivedEvent>() {
                public void handle(MessageReceivedEvent event) {
                    if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "test"))
                        BotUtils.sendMessage(event.getChannel(), "I am sending a message from an IListener listener");
                }
            });
        
            cli.getDispatcher().registerListener(new MyEvents());
        
            cli.login();
            
            switchOnOff("on");
        
            while (cli.getGuilds().size()<1) { }                   // wait till confirmed login

            checkUserData();                          // combo population
            populateChannelsCombo("");
    
    }//GEN-LAST:event_loginButActionPerformed

    private void getButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getButActionPerformed
        
        messagesList = selectedChannel.getMessageHistory(5000);
        mModel = (DefaultTableModel) messageDisplay.getModel();
        
        for (int i = 0; i<mModel.getRowCount(); i++) { mModel.removeRow(0);} messageDisplay.setModel(mModel);
        
            for (int i = 0; i<messagesList.size(); i++ ) {
                IMessage m = (IMessage) messagesList.get(i);
                insertRow(m,messageDisplay);
            }
    }//GEN-LAST:event_getButActionPerformed

    private void checkUserData(){

        if(cli.isLoggedIn()) {
        
        try {
        
        guildsList = cli.getGuilds();
            for (int i = 0; i < guildsList.size(); i++) {
                
                Guild guild = (Guild) guildsList.get(i);
                insertCombo(guild.getName(), guildCombo);
            }
        
        usersList = cli.getUsers();String logInName = username.getText().trim();
        
        for(int i = 0;i<usersList.size();i++){
            IUser user = (User) usersList.get(i);
            if(logInName.matches(user.getName())) { flag = true; }
            
        }

        
       
        } catch (NullPointerException e) {
            
            java.util.logging.Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Null nay never NOT");
        }
        } else { return; }
    }
    
    private void insertRow(IMessage o, JTable j){
        
        mModel = (DefaultTableModel) j.getModel();
        mModel.addRow(new Object[]{false, o.getAuthor().getName(), o.getTimestamp().toString(), o.getContent()});
        j.setModel(mModel);
        
    }
    
    private void insertCombo(String line, JComboBox combo){
        
        combo.addItem(line);

    }
    
    private void setupTables(){
        
        mModel = (DefaultTableModel) messageDisplay.getModel();
        
        String[] columns={"inc", "User", "Date", "Comment"};
        mModel.setColumnIdentifiers(columns);
        
        messageDisplay.setModel(mModel);
        
        TableColumnModel columnModel = messageDisplay.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(190);
        columnModel.getColumn(3).setPreferredWidth(350);
        
        messageDisplay.setColumnModel(columnModel);
        
        qModel = (DefaultTableModel) qPostList.getModel();
        
        String[] qcolumns={"use", "ID", "Date", "Text"};
        qModel.setColumnIdentifiers(qcolumns);
        
        qPostList.setModel(qModel);
        
        TableColumnModel qcolumnModel = qPostList.getColumnModel();
        qcolumnModel.getColumn(0).setPreferredWidth(50);
        qcolumnModel.getColumn(1).setPreferredWidth(100);
        qcolumnModel.getColumn(2).setPreferredWidth(280);
        qcolumnModel.getColumn(3).setPreferredWidth(400);
        
        qPostList.setColumnModel(qcolumnModel);
    }
    
    private void switchOnOff(String type){

        if (type.endsWith("on")){
            mssagesScroll.setEnabled(true);
            messageDisplay.setEnabled(true);
            getBut.setEnabled(true);
            guildCombo.setEnabled(true);
            channelCombo.setEnabled(true);
            channelLabel.setEnabled(true);
            guildLabel.setEnabled(true);
        } else {
            mssagesScroll.setEnabled(false);
            messageDisplay.setEnabled(false);
            getBut.setEnabled(false);
            guildCombo.setEnabled(true);
            channelCombo.setEnabled(true);
            channelLabel.setEnabled(true);
            guildLabel.setEnabled(true);
        }
    }
    
    
    
    private void listeners() {

        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        
            guildCombo.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e){
               if(e.getStateChange() == ItemEvent.SELECTED){
                  JComboBox localCombo = (JComboBox)e.getSource();
                   String result = localCombo.getSelectedItem().toString();
                   if (result.length()>0) { populateChannelsCombo(result); }
               }  
            }
        });
        
    }
    
    public void populateChannelsCombo(String guild){
        
        channelsList = null;guildsList = null;                     // dual purpose - if match made for item selected or
        guildsList = cli.getGuilds();                              // if match = "" = if we are at selected or none selected
        
        for(int i = 0;i<guildsList.size();i++){ 
            IGuild aGuild = (IGuild) guildsList.get(i);
            if (aGuild.getName().equals(guild)) {
                selectedGuild = aGuild;
                channelsList = aGuild.getChannels();
            }}
        
            if(channelsList!=null) {
                channelCombo.removeAll();
                for(int i = 0;i<channelsList.size();i++){
                    IChannel aChannel = (IChannel) channelsList.get(i);
                    if (i<1) { selectedChannel = aChannel; }
                    insertCombo(aChannel.getName(),channelCombo);
        }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
           
            public void run() {
                 
                
                try {
                    UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
                    
                    
                    new start().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
    });
                }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QPostPane;
    private javax.swing.JScrollPane QPostSroll;
    private javax.swing.JComboBox<String> channelCombo;
    private javax.swing.JLabel channelLabel;
    private javax.swing.JTextArea displayText;
    private javax.swing.JButton getBut;
    private javax.swing.JComboBox<String> guildCombo;
    private javax.swing.JLabel guildLabel;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel loadPane;
    private javax.swing.JScrollPane loadPanel;
    private javax.swing.JButton loginBut;
    private javax.swing.JTable messageDisplay;
    private javax.swing.JScrollPane mssagesScroll;
    private javax.swing.JTable qPostList;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
