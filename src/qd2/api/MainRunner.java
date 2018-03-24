/*
 * All work contained within is subject to copyright.
 * (c)2017 - Phil Crumpton
 * no work may be reproduced without prior consent.
 * All Rights Reserved.
 */
package qd2.api;

/**
 *
 * @author idiot
 */
import qd2.BotUtils;
import java.util.logging.Level;
import qd2.start;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import qd2.start.*;

public class MainRunner {

    IDiscordClient con = null;
    
    public MainRunner(){


        IDiscordClient cli = BotUtils.getBuiltDiscordClient("NDI2MTkzMjMxNTU5MTMxMTY2.DZSrxg.aAy4spfZItLZtwn3-N7ISD2SMyo");
        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.withToken("NDI2MTkzMjMxNTU5MTMxMTY2.DZSrxg.aAy4spfZItLZtwn3-N7ISD2SMyo");
        
        

        cli.getDispatcher().registerListener(new IListener<MessageReceivedEvent>() {
            public void handle(MessageReceivedEvent event) {
                if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "test"))
                    BotUtils.sendMessage(event.getChannel(), "I am sending a message from an IListener listener");
            }
        });
       

        // Register a listener via the EventSubscriber - changed soon
        cli.getDispatcher().registerListener(new MyEvents());

        // altered.
try {
            
        //clientBuilder.login();
        

            
        } catch (NullPointerException e) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Error in line " + e.getStackTrace());
        }
        
    }
    
    
    
    
    
    
}

