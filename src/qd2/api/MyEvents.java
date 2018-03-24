/*
 * All work contained within is subject to copyright.
 * (c)2017 - MrScabby
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
        if(event.getMessage().getContent().startsWith(BotUtils.BOT_PREFIX + "test"))
            BotUtils.sendMessage(event.getChannel(), "I am sending a message from an EventSubscriber listener");
    }
    
    

}
