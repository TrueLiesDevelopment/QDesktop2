/*
 * All work contained within is subject to copyright.
 * (c)2018 - MrScabby, TrueLies CNN
 * no work may be reproduced without prior consent.
 * All Rights Reserved.
 */
package qd2.api;

/**
 *
 * @author idiot
 */
import qd2.BotUtils;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public class MyEvents {

    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "hello"))
            BotUtils.sendMessage(event.getChannel(), "ahh hello, welcome.");
        
        if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "delete"))
            BotUtils.sendMessage(event.getChannel(), "not allowed");
    }
    
    /*
    Im considering an edit to this
    */

}
