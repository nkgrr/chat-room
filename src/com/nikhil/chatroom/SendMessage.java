package com.nikhil.chatroom;

import java.util.Scanner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;


public class SendMessage {
    public static void main(String  args[]){
        Jedis jedis = new Jedis("localhost");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter the channel name:");
        String channelName=scanner.nextLine();
        System.out.println("Starting publisher Redis for channelName "+ channelName);

        while (true){
            System.out.println("Enter the string to Publish to channelName :"+channelName);
            String msg = scanner.nextLine();
            jedis.publish(channelName,msg);
        }
    }
}