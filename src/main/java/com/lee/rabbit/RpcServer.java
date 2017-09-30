package com.lee.rabbit;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

/**
 * Description:
 * On 2017/9/30 15:30 created by LW
 */
public class RpcServer {
    public static void main(String[] args) {
        String queueName = "rpc_queue";
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.1.93");
        factory.setUsername("liw");
        factory.setPassword("liw");
        factory.setVirtualHost("test");
        Connection conn = null;
        try {
            conn = factory.newConnection();
            final Channel ch = conn.createChannel();
            ch.queueDeclare(queueName, false, false, false, null);
            ch.basicQos(1);
            System.out.println("Await for invoke");
            Consumer consumer = new DefaultConsumer(ch) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    AMQP.BasicProperties replyProperty = new AMQP.BasicProperties.Builder()
                            .correlationId(properties.getCorrelationId())
                            .build();
                    String resp = "";
                    try {
                        String msg = new String(body, "UTF-8");
                        int n = Integer.parseInt(msg);
                        n++;
                        resp += n;
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    } finally {
                        ch.basicPublish("", properties.getReplyTo(), replyProperty, resp.getBytes("UTF-8"));
                        ch.basicAck(envelope.getDeliveryTag(), false);
                        synchronized (this) {
                            this.notify();
                        }
                    }

                }
            };
            ch.basicConsume(queueName, false, consumer);
            while (true) {
                synchronized (consumer) {
                    try {
                        consumer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (null != conn) {
                try {
                    conn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
