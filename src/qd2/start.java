/*
 * All work contained within is subject to copyright.
 * (c)2018 
 * no work may be reproduced without prior consent.
 * All Rights Reserved.
 */
package qd2;

import datechooser.beans.DateChooserDialog;
import java.awt.Color;
import java.awt.Toolkit;
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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import sun.security.jca.GetInstance.Instance;
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
    public Color darkBlue = new Color(0x2F3136);
    
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

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        loadPane = new javax.swing.JPanel();
        mssagesScroll = new javax.swing.JScrollPane();
        messageDisplay = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loginBut = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        guildLabel = new javax.swing.JLabel();
        channelLabel = new javax.swing.JLabel();
        channelCombo = new javax.swing.JComboBox<>();
        guildCombo = new javax.swing.JComboBox<>();
        exTextOnly = new javax.swing.JCheckBox();
        loadTables = new javax.swing.JButton();
        dateChooser = new javax.swing.JButton();
        QPostPane = new javax.swing.JPanel();
        QPostSroll = new javax.swing.JScrollPane();
        qPostList = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(47, 49, 54));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setToolTipText("First step");

        mssagesScroll.setBackground(new java.awt.Color(47, 49, 54));
        mssagesScroll.setEnabled(false);

        messageDisplay.setBackground(new java.awt.Color(47, 49, 54));
        messageDisplay.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        messageDisplay.setEnabled(false);
        mssagesScroll.setViewportView(messageDisplay);

        jPanel1.setBackground(new java.awt.Color(47, 49, 54));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel1.setText("Connect...");

        loginBut.setText("Log In");
        loginBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButActionPerformed(evt);
            }
        });

        username.setText("MrScabby");
        username.setToolTipText("Enter your online Username");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loginBut, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(79, 79, 79))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(194, 194, 194))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(loginBut, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(47, 49, 54));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 1, 24)); // NOI18N
        jLabel2.setText("Search for content...");

        guildLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        guildLabel.setText("Guild");
        guildLabel.setEnabled(false);

        channelLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        channelLabel.setText("Channel");
        channelLabel.setEnabled(false);

        channelCombo.setEnabled(false);

        guildCombo.setEnabled(false);

        exTextOnly.setText("exc text only");

        loadTables.setText("Load Tables");
        loadTables.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadTablesActionPerformed(evt);
            }
        });

        dateChooser.setText("Choose Date");
        dateChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(294, 294, 294))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(guildLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(channelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exTextOnly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(channelCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guildCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(loadTables, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(guildLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guildCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(channelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(channelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exTextOnly)
                .addGap(30, 30, 30)
                .addComponent(loadTables, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout loadPaneLayout = new javax.swing.GroupLayout(loadPane);
        loadPane.setLayout(loadPaneLayout);
        loadPaneLayout.setHorizontalGroup(
            loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadPaneLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mssagesScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(455, Short.MAX_VALUE))
        );
        loadPaneLayout.setVerticalGroup(
            loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(loadPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mssagesScroll)
                    .addGroup(loadPaneLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Members Posts", loadPane);

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
                .addComponent(QPostSroll, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                .addGap(527, 527, 527))
        );
        QPostPaneLayout.setVerticalGroup(
            QPostPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QPostPaneLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(QPostSroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Take Aim", QPostPane);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 1310, 620));

        jPanel3.setBackground(new java.awt.Color(47, 49, 54));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadTablesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadTablesActionPerformed

        String aString = channelCombo.getSelectedItem().toString();
        System.out.println("Selected=" + aString);
        List channels = cli.getChannels(); 
        for(int i = 0;i<channels.size();i++){
            IChannel aChan = (IChannel) channels.get(i);
            if (aChan.getName().equalsIgnoreCase(aString)) { selectedChannel = aChan; }
        }
        
        messagesList = selectedChannel.getMessageHistory(1000);
        mModel = (DefaultTableModel) new DefaultTableModel();
        setupMessagesTable(mModel);
        boolean hasEmbed = false, hasAttachment = false;
        for (int i = 0; i<messagesList.size(); i++ ) {
            IMessage m = (IMessage) messagesList.get(i);
            if(m.getEmbeds().size()>0) { hasEmbed = true; } else { hasEmbed = false; }
            if(m.getAttachments().size()>0) { hasAttachment = true; } else { hasAttachment = false; }
            
            if(exTextOnly.isSelected() && (hasEmbed || hasAttachment)) { insertRow(m,messageDisplay); } else {
                if(!exTextOnly.isSelected()) {  insertRow(m,messageDisplay); }
            }
            
        }
    }//GEN-LAST:event_loadTablesActionPerformed

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

        while (cli.getGuilds().size()<1) { }        // wait till confirmed login\

        checkUserData();                          // combo population
        populateChannelsCombo("");
    }//GEN-LAST:event_loginButActionPerformed

    private void dateChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateChooserActionPerformed
        DateChooserDialog p = new DateChooserDialog();
        p.showDialog(this);
    }//GEN-LAST:event_dateChooserActionPerformed

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
        
        mModel.insertRow(mModel.getRowCount(), new Object[] { false, o.getAuthor().getName(), o.getTimestamp().toString(), o.getContent() });
        
        j.setModel(mModel);
    }
    
    private void insertCombo(String line, JComboBox combo){
        
        combo.addItem(line);

    }
    
    private void setupTables(){
        
        mModel = (DefaultTableModel) messageDisplay.getModel();
        setupMessagesTable(mModel);
        messageDisplay.setModel(mModel);
        
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
            loadTables.setEnabled(true);
            guildCombo.setEnabled(true);
            channelCombo.setEnabled(true);
            channelLabel.setEnabled(true);
            guildLabel.setEnabled(true);
        } else {
            mssagesScroll.setEnabled(false);
            messageDisplay.setEnabled(false);
            loadTables.setEnabled(false);
            guildCombo.setEnabled(true);
            channelCombo.setEnabled(true);
            channelLabel.setEnabled(true);
            guildLabel.setEnabled(true);
        }
    }
    
    private DefaultTableModel setupMessagesTable(DefaultTableModel mM){
        mModel = mM;
        Object[] columnNames = {"inc", "User", "Date", "Content"};
        Object[][] data = { {} };
        mModel = new DefaultTableModel(data, columnNames);
        JTableHeader header = messageDisplay.getTableHeader();
        header.setBackground(darkBlue);
        header.setForeground(text);
        
        messageDisplay.setModel(mModel);
        messageDisplay.setBackground(darkBlue);
        
        TableColumnModel columnModel = messageDisplay.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(190);
        columnModel.getColumn(3).setPreferredWidth(350);
        messageDisplay.setColumnModel(columnModel);
        return mModel;
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
    private javax.swing.JButton dateChooser;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JCheckBox exTextOnly;
    private javax.swing.JComboBox<String> guildCombo;
    private javax.swing.JLabel guildLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel loadPane;
    private javax.swing.JButton loadTables;
    private javax.swing.JButton loginBut;
    private javax.swing.JTable messageDisplay;
    private javax.swing.JScrollPane mssagesScroll;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private javax.swing.JTable qPostList;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
