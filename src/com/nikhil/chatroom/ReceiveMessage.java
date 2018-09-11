package com.nikhil.chatroom;

import java.util.Scanner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;


public class ReceiveMessage	
{
	
    public static void main(String args[])
    {
        Jedis jedis = new Jedis("localhost");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter the channel name:");
        String channelName = scanner.nextLine();
        System.out.println("Starting subscriber for channelName " + channelName);

        while (true) {
            jedis.subscribe(new JedisPubSub() 
			{
				  @Override
                public void onMessage(String channel, String message) 
                {         
            		//super.onMessage(channel, message);
                    System.out.println("Received message:" + message);
                }
                @Override
                public void onSubscribe(String channel, int subscribedChannels){
				}
                
                @Override
                public void onUnsubscribe(String channel, int subscribedChannels) {					
				}

                @Override
                public void onPMessage(String pattern, String channel, String message){					
				}

                @Override
                public void onPUnsubscribe(String pattern, int subscribedChannels) {
				}
                
                @Override
                public void onPSubscribe(String pattern, int subscribedChannels) {
				}
            }, channel);
        }
    }
}