package com.lee.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.cloud.sleuth.zipkin2.ZipkinAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author : Liw
 * @description :
 * @date : 2018/2/9 11:31
 */
@Configuration
public class MqConfig {

    @Value("${spring.rabbitmq.first.host}")
    private String host;
    @Value("${spring.rabbitmq.first.port}")
    private int port;
    @Value("${spring.rabbitmq.first.username}")
    private String username;
    @Value("${spring.rabbitmq.first.password}")
    private String password;
    @Value("${spring.rabbitmq.first.virtual-host}")
    private String vhost;

    @Value("${spring.rabbitmq.second.host}")
    private String host2;
    @Value("${spring.rabbitmq.second.port}")
    private int port2;
    @Value("${spring.rabbitmq.second.username}")
    private String username2;
    @Value("${spring.rabbitmq.second.password}")
    private String password2;
    @Value("${spring.rabbitmq.second.virtual-host}")
    private String vhost2;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cf = new CachingConnectionFactory();
        cf.setHost(host);
        cf.setPort(port);
        cf.setUsername(username);
        cf.setPassword(password);
        cf.setVirtualHost(vhost);
        return cf;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        AmqpAdmin admin = new RabbitAdmin(connectionFactory());
        admin.declareQueue(new Queue("hello"));
        return admin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    @Primary
    public CachingConnectionFactory bizConnectionFactory() {
        CachingConnectionFactory cf = new CachingConnectionFactory();
        cf.setHost(host2);
        cf.setPort(port2);
        cf.setUsername(username2);
        cf.setPassword(password2);
        cf.setVirtualHost(vhost2);
        return cf;
    }

//    @Bean(name = "bizAmqpAdmin")
    @Bean
    public AmqpAdmin bizAmqpAdmin() {
        AmqpAdmin admin = new RabbitAdmin(bizConnectionFactory());
        admin.declareQueue(new Queue("biz"));
        return admin;
    }

//    @Bean(name = "bizRabbitTemplate")
    @Bean
    public RabbitTemplate bizRabbitTemplate() {
        return new RabbitTemplate(bizConnectionFactory());
    }

    /*@Bean
    public RabbitProperties rabbitProperties() {
        RabbitProperties p = new RabbitProperties();
    }*/
}
