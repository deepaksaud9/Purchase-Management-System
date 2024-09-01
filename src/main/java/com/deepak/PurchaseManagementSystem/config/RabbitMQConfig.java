package com.deepak.PurchaseManagementSystem.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "purchaseQueue";
    public static final String EXCHANGE_NAME = "purchaseExchange";
    public static final String ROUTING_KEY = "purchase.created";

    @Bean
    public Queue purchaseQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public TopicExchange purchaseExchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding binding(Queue purchaseQueue, TopicExchange purchaseExchange) {
        return BindingBuilder.bind(purchaseQueue).to(purchaseExchange).with(ROUTING_KEY);
    }
}