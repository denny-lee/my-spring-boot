package com.lee.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

/**
 * Description:
 * On 2017/9/30 15:58 created by LW
 */
public class RpcClient {

    private String queueName = "rpc_queue";
    private Connection conn;
    private Channel ch;
    private String rep_queue;

    public RpcClient() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.1.93");
        factory.setUsername("liw");
        factory.setPassword("liw");
        factory.setVirtualHost("test");
        conn = factory.newConnection();
        ch = conn.createChannel();
        rep_queue = ch.queueDeclare().getQueue();
    }

    public String call(String msg) throws IOException, InterruptedException {
        final String corrId = UUID.randomUUID().toString();
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                .correlationId(corrId)
                .replyTo(rep_queue)
                .build();
        ch.basicPublish("", queueName, properties, msg.getBytes("UTF-8"));
        final BlockingQueue<String> resp = new ArrayBlockingQueue<String>(1);
        ch.basicConsume(rep_queue, true, new DefaultConsumer(ch) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                if (corrId.equals(properties.getCorrelationId())) {
                    resp.offer(new String(body, "UTF-8"));
                }
            }
        });
        return resp.take();
    }

    public void close() throws IOException {
        conn.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {
        RpcClient rpcClient = new RpcClient();
        String s = rpcClient.call("20");
        System.out.println(s);
        rpcClient.close();
    }
}
