package ru.edu.example.rabbitmqproducer.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String EXCHANGE_NAME = "fanout.exchange";
    public static final String QUEUE_NAME = "fanout.queue";
    public static final String SUB_QUEUE_NAME = "fanout.queue-sub";

    @Bean
    public Declarables fanoutBindings() {
        var fanoutQueue = new Queue(QUEUE_NAME, false);
        var fanoutQueueSub = new Queue(SUB_QUEUE_NAME, false);
        FanoutExchange fanoutExchange = new FanoutExchange(EXCHANGE_NAME);
        return new Declarables(
            fanoutQueue,
            fanoutQueueSub,
            fanoutExchange,
            BindingBuilder.bind(fanoutQueue).to(fanoutExchange),
            BindingBuilder.bind(fanoutQueueSub).to(fanoutExchange));
    }

}
