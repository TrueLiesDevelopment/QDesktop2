/*
 * All work contained within is subject to copyright.
 * (c)2017 - Phil Crumpton
 * no work may be reproduced without prior consent.
 * All Rights Reserved.
 */
package qd2;

import java.util.List;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
public class start extends javax.swing.JFrame {

    
    public IDiscordClient cli = null;
    public IDiscordClient shrd = null;
    
    /**
     * Creates new form start
     */
    public start() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginBut = new javax.swing.JButton();
        statusLabel = new javax.swing.JTextField();
        getBut = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginBut.setText("Log in");
        loginBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButActionPerformed(evt);
            }
        });

        statusLabel.setText("off-line");

        getBut.setText("Get Details");
        getBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getButActionPerformed(evt);
            }
        });

        displayText.setColumns(20);
        displayText.setRows(5);
        jScrollPane1.setViewportView(displayText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(getBut, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginBut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(227, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBut)
                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(getBut)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButActionPerformed
        
        statusLabel.setText("logging in..");
        
        cli = BotUtils.getBuiltDiscordClient("NDI2NDU4OTAzODgzMDIyMzU2.DZWXBg.GqluTwQt5yJvVoQZPFuklaksbsw");

        cli.getDispatcher().registerListener(new IListener<MessageReceivedEvent>() {
            public void handle(MessageReceivedEvent event) {
                if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "test"))
                    BotUtils.sendMessage(event.getChannel(), "I am sending a message from an IListener listener");
            }
        });
        cli.getDispatcher().registerListener(new MyEvents());
        cli.login();
        while (!cli.isLoggedIn()) { }
        if (cli.isLoggedIn()) statusLabel.setText("on line");
        System.out.println("end!");
       

        
    }//GEN-LAST:event_loginButActionPerformed

    private void getButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getButActionPerformed
        
        List aList = cli.getGuilds();
        for(int i = 0;i<aList.size();i++){
            Guild guild = (Guild) aList.get(i);
            long id = (long) guild.getLongID();
            displayText.append("Guild:" + id + "\n");
        }
        
        List bList = cli.getUsers();
        for(int i = 0;i<bList.size();i++){
            IUser user = (User) bList.get(i);
            
            long id = (long) user.getLongID();
            String name = user.getName();
            
            
            displayText.append("User:" + id + " : " + name + "\n");
        }
        
        List chnList,mList=null,eList=null;
        
        List iGuilds = cli.getGuilds();
            IGuild g = (IGuild) iGuilds.get(0);
            chnList = g.getChannels();
            displayText.append("Guild. [id,name]" + g.getStringID() + " - " + g.getName() + "\n");
        
        if (chnList.size()>0) {
            IChannel ch = (IChannel) chnList.get(0);
            mList = ch.getFullMessageHistory();
            System.out.println("mList size = " + mList.size());
            displayText.append("channel [id,name]" + ch.getStringID() + " - " + ch.getName() + "\n");
            List usrs = ch.getUsersHere();
            IUser me = (IUser) usrs.get(2);
            displayText.append("Me I think:" + me.getName() + "\n");
        } else { displayText.append("No channels yet.");
        }
        
        for(int i = 0;i<mList.size();i++){
            
            IMessage iMessage = (IMessage) mList.get(i);
            
            long iM = (long) iMessage.getLongID();
            String content = iMessage.getContent();
 
            displayText.append("Message:" + iM + " : " + content + "\n");
        }
        
        
        
    }//GEN-LAST:event_getButActionPerformed

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
    private javax.swing.JTextArea displayText;
    private javax.swing.JButton getBut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loginBut;
    private javax.swing.JTextField statusLabel;
    // End of variables declaration//GEN-END:variables
}
