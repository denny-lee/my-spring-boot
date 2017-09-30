package com.lee.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Description:
 * On 2017/9/30 9:51 created by LW
 */
public class Hello {
    public static void main(String[] args) throws IOException, TimeoutException {
        // send
        String queueName = "hello";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.1.93");
        factory.setUsername("liw");
        factory.setPassword("liw");
        factory.setVirtualHost("test");
        Connection conn = factory.newConnection();
        Channel ch = conn.createChannel();
//        ch.queueDeclare(queueName, false, false, false, null);
        ch.exchangeDeclare("ex1", "fanout");
        String message = "Hello baby~";
        ch.basicPublish("ex1", "", null, message.getBytes());
        System.out.println(" sent msg : " + message);
        if ((System.in.read()) > 0) {
            ch.close();
            conn.close();
        }
    }
}
