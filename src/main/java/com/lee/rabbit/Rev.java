package com.lee.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Description:
 * On 2017/9/30 11:07 created by LW
 */
public class Rev {
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
        queueName = ch.queueDeclare().getQueue();
        ch.exchangeBind(queueName, "ex1", "");
        System.out.println("waiting...");
        Consumer consumer = new DefaultConsumer(ch){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.println("receive: " + msg);
            }
        };
        ch.basicConsume(queueName, true, consumer);
    }
}
