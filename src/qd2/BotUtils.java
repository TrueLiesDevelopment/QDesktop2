/*
 * All work contained within is subject to copyright.
 * (c)2018
 * no work may be reproduced without prior consent.
 * All Rights Reserved.
 */
package qd2;

/**
 *
 * @author idiot
 */

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.RateLimitException;
import sx.blah.discord.util.RequestBuffer;

public class BotUtils {

    // Constant
public static String BOT_PREFIX = ".";

    // IDiscordClient object for a token
public static IDiscordClient getBuiltDiscordClient(String token){

        // Such as withToken, setDaemon etc
        return new ClientBuilder()
                    .withToken(token)
                    .build();
    }

    // Helper functions sendMessage
public static void sendMessage(IChannel channel, String message){

        
        RequestBuffer.request(() -> {
            try{
                channel.sendMessage(message);
            } catch (DiscordException e){
                System.err.println("Message could not be sent with error: ");
                e.printStackTrace();
            }
        });

        
        // The below  to demonstrate sending a message
        RequestBuffer.request(() -> {
            try{
                channel.sendMessage(message);
            } catch (RateLimitException e){
                System.out.println("Do some logging");
                throw e;
            }
        });
       

    }

}
